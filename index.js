const auth = require('basic-auth');
const bodyparser = require('body-parser');
const register = require('./functions/register');
const login = require('./functions/login');
const profile = require('./functions/profile');
const password = require('./functions/password');
const config = require('./config/config.json');
const createroom = require('./functions/createroom');
const jwt = require('jsonwebtoken');
const express = require('express'),
http = require('http'),
app = express();

//ARRAY 


server = http.createServer(app),
io = require('socket.io').listen(server);
app.get('/',(req,res)=>{
    res.send('chat server is running on port 3000')
});
//implementamos socket io 
var people = {};
io.on('connection',(socket)=>{
    socket.room = null;
    refreshrooms();
    console.log('user connected')
       /*lista de salas*/   
        function refreshrooms(){
            io.emit('allroms',Object.keys(io.sockets.adapter.rooms))
        }
    
        socket.on('create',(nameroom,nickname)=>{
                    socket.join("room "+ nameroom);
                    people[socket.id] = nickname;
                    socket.room = nameroom;
                    console.log("se ha creado la habitación "+ nameroom); 
                    console.log("room: %j", nameroom)
                    console.log(Object.keys(io.sockets.adapter.rooms));
                    console.log("el usuario "+ nickname +  " ha creado una habitación ");
                    refreshrooms();
                    tab = shuffle(tablero);
                    io.sockets.adapter.rooms[nameroom].tablero = tab;
                    console.log(xd[0]);
                    console.log(xd[1]);
                    console.log(xd[2]);
                    console.log(xd[3]);
        })
        socket.on('join',(nameroom,nickname)=>{
            var rum = io.sockets.adapter.rooms[nameroom];
            if(rum.length < 8){
            socket.room = nameroom; 
            socket.join(nameroom);
            console.log("alguien ha entrado a la habitación "+ nameroom )
            console.log("tiene " + rum.length + " usuarios" ); 
            console.log("el usuario: "+ nickname + " se ha conectado");
            
            }else{
                console.log("la sala esta llena ");
            } 
            var roster = io.sockets.clients(nameroom);
            roster.foreach(function(people){
                console.log('Username: ' + people[nameroom].nickname)
            })        
          
        })

        socket.on('start',()=>{
            var rum  = io.sockets.adapter.room[socket.room];
            if(rum.length){
                console.log("pueden empezar");
            }
        })

       socket.on('disconnect', function() {
        var rum = io.sockets.adapter.rooms[socket.room];
        if(rum!=undefined){
            console.log( 'un usuario ha salido de la sala' + socket.room + " solo quedan "+ rum.length +" en la sala")
        }else{
            console.log("la sala ha sido eliminada");
            refreshrooms();
        }
        
       // socket.broadcast.emit( "userdisconnect" ,' user has left')
    
    
    });

})



                                        //RUTAS 

app.post('/rooms',(req,res)=>{
    const name = req.body.name;
    if(!name || !name.trim()){
        res.status(400).json({message: 'Petición invalida'});
    }else{
            createroom.createroom(name)
            .then(result =>{
                res.setHeader('Location', '/rooms'+name);
                res.status(result.status).json({message: result.message});
            })
            .catch(err => res.status(err.status).json({message: err.message}));
    }
});



app.post('/authenticate',(req,res)=>{
    const credentials = auth(req);
    if(!credentials){
        res.status(400).json({message: 'Invalid Request'});
    }else{
        login.loginUser(credentials.name, credentials.pass)
        .then(result =>{
                const token = jwt.sign(result, config.secret,{expiresIn: 1440});
                res.status(result.status).json({message: result.message, token: token});
        })
            .catch(err => res.status(err.status).json({message: err.message}));
    }
});
app.post('/users',(req,res)=>{
        const name = req.body.name;
        const email = req.body.email;
        const password = req.body.password;
        if(!name || !email || !password || !name.trim() || !email.trim() || !password.trim()){
                res.status(400).json({message: 'Invalid Request !'});
        }else{
            register.registerUser(name, email, password)
            .then(result =>{
                    res.setHeader('Location', '/users'+email);
                    res.status(result.status).json({message: result.message})
            })
            .catch(err => res.status(err.status).json({message: err.message}));
        }
});
app.get('/users/:id',(req,res)=>{
    if(checkToken(req)){
        profile.getProfile(req.params.id)
        .then(result => res.json(result))
        .catch(err => res.status(err.status).json({message: err.message}));

    }else{
        res.status(401).json({message: 'Invalid Token !'});
    }
});
    app.put('/users/:id',(req,res)=>{
        if(checkToken(req)){

            const oldPassword = req.body.password;
            const newPassword = req.body.newPassword;
            if(!oldPassword || !newPassword || oldPassword.trim() || !newPassword.trim()){
                    res.status(400).json({message: 'Invalid Request'});
            }else{
                    password.changePassword(req.params.id, oldPassword, newPassword)
                    .then(result => res.status(result.status).json({message: result.message}))
                    .catch(res.status(err.status).json({message: err.message}))
            }
        }else{
            res.status(401).json({message: 'Invalid Token !'});
        }
    });
app.put('/users/:id', (req,res) => {

        if (checkToken(req)) {

            const oldPassword = req.body.password;
            const newPassword = req.body.newPassword;

            if (!oldPassword || !newPassword || !oldPassword.trim() || !newPassword.trim()) {

                res.status(400).json({ message: 'Invalid Request !' });

            } else {

                password.changePassword(req.params.id, oldPassword, newPassword)

                .then(result => res.status(result.status).json({ message: result.message }))

                .catch(err => res.status(err.status).json({ message: err.message }));

            }
        } else {

            res.status(401).json({ message: 'Invalid Token !' });
        }
    });

    app.post('/users/:id/password', (req,res) => {

        const email = req.params.id;
        const token = req.body.token;
        const newPassword = req.body.password;

        if (!token || !newPassword || !token.trim() || !newPassword.trim()) {

            password.resetPasswordInit(email)

            .then(result => res.status(result.status).json({ message: result.message }))

            .catch(err => res.status(err.status).json({ message: err.message }));

        } else {

            password.resetPasswordFinish(email, token, newPassword)

            .then(result => res.status(result.status).json({ message: result.message }))

            .catch(err => res.status(err.status).json({ message: err.message }));
        }
    });

    function checkToken(req) {

        const token = req.headers['x-access-token'];

        if (token) {

            try {

                  var decoded = jwt.verify(token, config.secret);

                  return decoded.message === req.params.id;

            } catch(err) {

                return false;
            }

        } else {

            return false;
        }
    }


                        //Funtions
server.listen(3000,()=>{
    console.log('Node app is running on port 3000')
})