var express = require('express');
var app = express();
var server = require('http').Server(app);
var io = require('socket.io')(server);
var crypto = require('crypto');
const jwt = require('jsonwebtoken');
var mongodb = require('mongodb');
var bodyparser = require('body-parser')

app.use(bodyparser.json())
app.use(bodyparser.urlencoded({ extended: true }));

//PASSWORD ULTILS
//CREATE FUNCTION TO RANDOM SALT
var genRandomString = function(length) {
    return crypto.randomBytes(Math.ceil(length / 2))
        .toString('hex')
        .slice('0,length')
}

var sha512 = function(password, salt) {
    var hash = crypto.createHmac('sha512', salt)
    hash.update(password)
    var value = hash.digest('hex')
    return {
        salt: salt,
        passwordHash: value
    };
}

function saltHashPassword(userPassword) {
    var salt = genRandomString(16);
    var passwordData = sha512(userPassword, salt);
    return passwordData
}

function checkHashPassword(userPassword, salt) {
    var passwordData = sha512(userPassword, salt)
    return passwordData
}
//Format of token 
//Authorization: Bearer <access_token>
//verify Token
function verifyToken(req, res, next) {
    //Get auth header value
    const bearerHeader = req.headers['authorization']
        //Check if baererHeader is undefined
    if (typeof bearerHeader !== 'undefined') {
        //Split at the space
        const bearer = bearerHeader.split(' ')
            //Get token from array
        const bearerToken = bearer[1]
            //Set the token
        req.token = bearerToken
            //Next middleware 
        next()
    } else {
        //Forbidden
        res.sendStatus(403);
    }


}

//create MongoDB client
var MongoClient = mongodb.MongoClient

//Conection URL
var url = 'mongodb://localhost:27017' //27017 is default port 
    //SOCKETS
var messages = [{
    id: 1,
    text: "Hola soy un mensaje",
    author: "Carlos Azaustre"
}]
app.use(express.static('public'))
app.get('/', function(req, res) {
    res.status(200).send("Hello World");
});

io.on('connection', function(socket) {
    console.log('Alguien se ha conectado con Sockets')
    socket.emit('messages', messages)
    socket.on('new-message', function(data) {
        messages.push(data);
        io.sockets.emit('messages', messages);
    })
});
//conect to mongo
MongoClient.connect(url, { useNewUrlParser: true }, function(err, client) {
    if (err)
        console.log('Unable to connect to the mongoDB server.Error', err);
    else {




        //SALA
        app.post('/sala', (req, response) => {
            var post_data = req.body
            var db = client.db('nombresenclave');

            var nombresala = post_data.sala
            var insertJson = {
                'nombresala': nombresala
            }

            console.log(nombresala)
            db.collection('salas')
                .find({ 'nombresala': nombresala }).count(function(err, number) {
                    if (number == 0) {
                        db.collection('salas')
                            // manejar las conexiones entrantes de los clientes
                            .insertOne(insertJson, function(error) {
                                console.log("sala creada")
                                response.json('sala creada')
                            })
                    } else {
                        response.json('La sala ya existe');
                        console.log('la sala ya existe');

                    }
                })
        })

        app.post('/listasala', (err, res) => {
                var db = client.db('nombresenclave');
                

                db.collection("salas").find().toArray(function(err, result) {
                    if (err) throw err;
                    console.log(result);
                    res.json( result )
                    
                })
            })
            //eliminar sala
        app.post('/eliminarsala', (req, res) => {
            var db = client.db('nombresenclave');
            var post_data = req.body
            var eliminarsala = post_data.salaname
            var myquery = { 'nombresala': eliminarsala }
            db.collection("salas").deleteOne(myquery, function(err, obj) {
                if (err) throw err;
                console.log(obj.result.n + " Sala eliminada");
                res.json(obj.result.n + " Sala eliminada")
            });


        })





        //register
        app.post('/register', (request, response, next) => {
            var post_data = request.body;
            var plaint_password = post_data.password;
            var hash_data = saltHashPassword(plaint_password);

            var password = hash_data.passwordHash; // save password hash
            var salt = hash_data.salt; // save salt


            var name = post_data.name;
            var email = post_data.email;
            var insertJson = {
                'email': email,
                'password': password,
                'salt': salt,
                'name': name
            };
            var db = client.db('nombresenclave');

            //check exist email
            db.collection('user')
                .find({ 'email': email }).count((err, number) => {
                    if (number != 0) {
                        response.json('Email already exists');
                        console.log('Email already exists');
                    } else {
                        //Inser data
                        db.collection('user')
                            .insertOne(insertJson, function(error, res) {
                                response.json('Regitro con exito');
                                console.log('Registro con exito');
                            })
                    }
                })

        });
        //Login
        app.post('/login', (request, response, next) => {
            var post_data = request.body;
            var email = post_data.email;
            var userPassword = post_data.password;

            var db = client.db('nombresenclave');

            //check exist email
            db.collection('user')
                .find({ 'email': email }).count(function(err, number) {
                    if (number == 0) {
                        response.json('El correo no existe');
                        console.log('El correo no existe');
                    } else {
                        //Inser data
                        db.collection('user')
                            .findOne({ 'email': email }, function(err, user) {
                                var salt = user.salt; //get salt from user
                                var hashed_password = checkHashPassword(userPassword, salt).passwordHash; //has password with salt
                                var encrypted_password = user.password; //Get password from usser
                                if (hashed_password == encrypted_password) {

                                    //creamos el token
                                    var user = {
                                        email: email,
                                        password: userPassword
                                    }
                                    jwt.sign({ user }, 'secretkey', { expiresIn: '15d' }, (err, token) => {
                                            response.json({
                                                token
                                            })
                                        })
                                        // response.json('Login success')
                                    console.log('Login success')
                                } else {
                                    response.json('wrong password')
                                    console.log('wrong password')
                                }
                            })
                    }
                })

        });
        //start Web Server 

    }


})


server.listen(8080, function() {
    console.log("Servidor corriendo en http://localhost:8080")
});