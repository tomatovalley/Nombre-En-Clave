var io;
var gameSocket;

/**
 * This function is called by index.js to initialize a new game instance.
 *
 * @param sio The Socket.IO library
 * @param socket The socket object for the connected client.
 */

exports.initGame = function(sio,socket){
    io = sio;
    gameSocket = socket;
    gameSocket.emit('connected',{message: "You are connected!"});
    console.log("Se ha conectado un usuario");
    //Host Events
    gameSocket.on('hostCreateNewGame', hostCreateNewGame);
    gameSocket.on('hostStartGame', hostStartGame);
  //  gameSocket.on('hostNextRound', hostNextRound);
    gameSocket.on('Disconnect',desconectado);
    //SpyMaster Events
    gameSocket.on('enviopistas',pistasenviadas);

    // Player Events
   gameSocket.on('playerJoinGame', playerJoinGame);
   gameSocket.on('atinada',atino);
   gameSocket.on('semiatinada',semiatino);
   gameSocket.on('gameover',gameover);
   gameSocket.on('noatinada',noatino);
   gameSocket.on('sigequipo',sigequipo)
   gameSocket.on('actpuntg',actpuntg);
   gameSocket.on('actpuntp',actpuntp);
    gameSocket.on('ganador',ganador);
   //PRUEBA 
   gameSocket.on('gettablero',sendtablero);
   gameSocket.on('getpalabras',sendWords)
  
}


/* ****************************
   *                          *
   *        HOST FUNCTIONS    *
   *                          *
   * ************************** */

/**
 * cuando creamos sala?
 */

 function hostCreateNewGame(){
     // Create a unique Socket.IO room
     var thisGameId = ( Math.random()* 10000)  | 0;
     //Return the Room ID (gameID) and the socket ID (mySocketID) to the Client
     var roles = [thisGameId,1,"red","spymaster",true,true]
     this.emit('newGamecreated', roles);
     //Join the Room and wait for the players
     this.join(thisGameId.toString());
     console.log("se ha creado una sala con el ID de : " + thisGameId);
 };

 function desconectado(){
    this.disconnect();
 }

 function hostStartGame(gameid){
     console.log("un usuario ha empezado la partida en " + gameid);
     io.sockets.in(gameid).emit('startgame');

 }

 function playerJoinGame(data){
     this.join(data);
     console.log("se ha unido un player a la habitación")
     var thisGameId = data;
     var rum = io.sockets.adapter.rooms[data];
    switch(rum.length){
        case 2:
        var roles = [thisGameId,2,"blue","spymaster",false,true]
        this.emit('newGamecreated',roles);
        break;
        case 3:
        var roles = [thisGameId,3,"red","operative",false,true]
        this.emit('newGamecreated',roles);
        break;
        case 4:
        var roles = [thisGameId,4,"blue","operative",false,true]
        this.emit('newGamecreated',roles);

    }
 }

 /*****************************
  *                           *
  *   SPYMASTER FUNCtiONS     *
  *                           *
  * ***************************
  */

 function pistasenviadas(pista,numero,gameId,turno){
     let turnonuevo;
        switch(turno){
            case 1: turnonuevo = 3;
                    break;
            case 2: turnonuevo = 4;
                    break;
        }
        var envio =[pista,numero,turnonuevo];
        io.sockets.in(gameId).emit('nuevoturno',envio);
 }




  /****************************
   *                          *
   *    Operative Funcions    * 
   *                          *
   *                          *
   *****************************/ 
  function atino(img,gameId){
        io.sockets.in(gameId).emit("respuesta",img)
  }
  function semiatino(img,gameId){
        io.sockets.in(gameId).emit("respuesta",img)
  }
  function gameover(img,gameId,team){
      io.sockets.in(gameId).emit("gameover",img,team)


  }
  function noatino(img,gameId){
        io.sockets.in(gameId).emit("respuesta",img)
  }
  function sigequipo(pos,gameId){
      var posicionn;
            switch(pos){
                case 3:
                posicionn = 2;
                break;
                case 4: 
                posicionn = 1;
                break;
            }
    io.sockets.in(gameId).emit("nuevoturno2",posicionn)
  }
  function actpuntg(team,gameId){
      console.log("el equipo rojo ha ganado punto");
    io.sockets.in(gameId).emit("actpuntg",team);
  }
  function actpuntp(team,gameId){
      console.log("el equipo azul ha ganado punto");
    io.sockets.in(gameId).emit("actpuntp",team);
  }

  function ganador(winner,gameId){
      console.log("ha ganado el : "+ winner)
    io.sockets.in(gameId).emit("fin",winner);
  }


 /** *************************
  *                          *
  *         GAME LOGIC       *
  *                          *
  * **************************
  */
//enviamos el tablero
function sendtablero(gameId){
    var data = gettablero(gameId);
 //   io.sockets.in(gameId).emit('newTablero',data)
        io.sockets.in(gameId).emit('newTablero',data)
}
    //cojemos uno de los dos tableros y lo mezclamos
function gettablero(gameId){
    var tab = selectcolor(gameId);
    tab = shuffle(tab);
    return tab;
}
    //elejimos al azar entre los dos tableros disponibles
function selectcolor(gameId){
    var tablero 
    var equis = Math.floor(Math.random() * 2) + 1 
    turno = [equis]
    if(equis == 1){
         tablero = [0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,3]
         io.sockets.in(gameId).emit('empieza',turno);
         console.log(1);
    }else{
         tablero = [0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,3]
         io.sockets.in(gameId).emit('empieza',turno);
         console.log(2);
    }
    return tablero;
}
    //funcion para mezclar arrays
function shuffle(a){
    for (let i = a.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [a[i], a[j]] = [a[j], a[i]];
    }
    return a;
}
//enviamos las palabras para las tarjetas
function sendWords(gameId){
    //cojemos las primeras 25 palabras del array mezclado
    var words = shuffle(wordPool).slice(0,25)
    //io.sockets.in(gameId).emit('newWordsData',data)
    io.sockets.in(gameId).emit('newpalabras',words);
    console.log("envio palabras" + words[0])
}
function verifyanswer(gameId,pista,playerteam){

}
var wordPool=["astronauta","agua","jugo","limón","naranja","escritorio","asfalto","ratón","perro",
                "brazo","robot","escuela","lapiz","pluma","cinta","ingeniero","artiste","calcetin",
                "Desodorante","cartera", "musica", "celular", "metro","bicicleta","etiqueta","flauta",
                "guitarra","rey","pantalon","camisa","silla","Perro", "Gato", "Liebre", "Elefante", "Vaca", 
                "Camello", "Mono", "Tigre", "León", "Rinoceronte", "Panda", "Koala", "Armadillo", "Topo", "Castor", 
                "Jirafa", "Serpiente", "Lagartija", "Jaguar", "Hormiga", "Iguana", "Oveja", "Gusano", "Cocodrilo", "Ballena", 
                "Pulpo", "Tortuga", "Pavo", "Lechuza","Silla", "Cama", "Mesa", "Armario", "Reloj", "Archivo","Espejo", "Lámpara", 
                "Librero",]