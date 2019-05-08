﻿insert into administrador(nick,clave,correo,fec_nacimiento,sueldo) values('pablo', crypt('kk', gen_salt('bf')),'jacknieve@gmail.com','1996-11-06',6500);
insert into administrador(nick,clave,correo,fec_nacimiento,sueldo) values('bosscostasuprem', crypt('elgrande', gen_salt('bf')),'jacknieve@gmail.com','1995-05-20',50000);
insert into administrador(nick,clave,correo,fec_nacimiento,sueldo) values('alex', crypt('alex', gen_salt('bf')),'alexalex@gmail.com','1990-12-24',7500);
insert into administrador(nick,clave,correo,fec_nacimiento,sueldo) values('adri', crypt('contrasenhafalsa', gen_salt('bf')),'koukoulis@gmail.com','1996-11-06',7000);
insert into jugador(nick,clave,correo,fec_nacimiento,baneado) values('juan', crypt('juan', gen_salt('bf')),'juan@gmail.com','1980-10-09',false);
insert into jugador(nick,clave,correo,fec_nacimiento,baneado) values('pedro', crypt('pedro', gen_salt('bf')),'pedro@gmail.com','2005-01-10',false);
insert into jugador(nick,clave,correo,fec_nacimiento,baneado) values('luis', crypt('luis', gen_salt('bf')),'luis@gmail.com','2000-4-11',false);
insert into jugador(nick,clave,correo,fec_nacimiento,baneado) values('pepe', crypt('pepe', gen_salt('bf')),'pepe@gmail.com','2003-07-12',false);
insert into jugador(nick,clave,correo,fec_nacimiento,baneado) values('baneado', crypt('baneado', gen_salt('bf')),'superkk@gmail.com','1900-11-06',true);
insert into bloquear(jugador,bloqueado,fecha,motivo) values('juan','pedro','2019-04-13','Mal comportamiento');
insert into seramigo(jugador,amigo) values ('pedro','luis');
insert into seramigo(jugador,amigo) values ('pedro','pepe');
insert into categoria(nombre,descripcion) values('estrategia','Juegos en lo que lo importante es planificar y crear una buena estrategia para vencer');
insert into categoria(nombre,descripcion) values('mundo abierto','Juegos en los que puedes alcanzar cualquier lugar del mundo y moverte libremente');
insert into categoria(nombre,descripcion) values('shooter','Juegos en lo controlas a un personaje armado para pelear contra otros jugadores, normalmente con armas de fuego');
insert into desarrolladora(nombre,pais) values('blizzart','estados unidos');
insert into desarrolladora(nombre,pais) values('riot','estados unidos');
insert into desarrolladora(nombre,pais) values('ubisoft','estados unidos');
insert into juego(nombre,edadrecomendada,desarrolladora) values('World of Warcraft',8,'blizzart');
insert into juego(nombre,edadrecomendada,desarrolladora) values('Leage of Legends',8,'riot');
insert into juego(nombre,edadrecomendada,desarrolladora) values('Far cry 5',8,'ubisoft');
insert into complemento(nombre,descripcion,juego) values('skin especial','skin especial de un campeon',2);
insert into complemento(nombre,descripcion,juego) values('montura cobre','montura de un dragon de cobre',1);
insert into complemento(nombre,descripcion,juego) values('arma legendaria','arma con unas estadisticas impresionantes',1);
insert into complemento(nombre,descripcion,juego) values('bazooka especial','bazzoka dorado',3);
insert into comprar(fecha,visibilidad,juego,jugador) values('2000-05-07',true,1,'pepe');
insert into comprar(fecha,visibilidad,juego,jugador) values('2012-03-06',true,2,'pepe');
insert into comprar(fecha,visibilidad,juego,jugador) values('2019-11-21',true,1,'juan');
insert into comprar(fecha,visibilidad,juego,jugador) values('2012-05-17',true,3,'pedro');
insert into comprar(fecha,visibilidad,juego,jugador) values('2014-07-19',true,3,'luis');
insert into logro(nombre,descripcion,puntos,juego) values('50 monturas','Conseguir 50 monturas',20,1);
insert into logro(nombre,descripcion,puntos,juego) values('Fin de la historia','Termina el modo historia',50,3);
insert into logro(nombre,descripcion,puntos,juego) values('Ganador','Gana 20 partidas',15,2);
insert into conseguirlogro(fecha,visibilidad,juego,jugador,logro) values('2014-02-14',true,1,'pepe','50 monturas');
insert into conseguirlogro(fecha,visibilidad,juego,jugador,logro) values('2019-10-10',false,3,'pedro','Fin de la historia');
insert into jugar(fechain,fechafin,juego,jugador) values('2013-06-14 20:00:00','2013-06-14 22:00:00',1,'pepe');
insert into jugar(fechain,fechafin,juego,jugador) values('2016-06-14 20:00:00','2016-06-14 22:00:00',2,'pepe');
insert into jugar(fechain,fechafin,juego,jugador) values('2018-06-14 14:00:00','2018-06-14 23:00:00',3,'pepe');
insert into jugar(fechain,fechafin,juego,jugador) values('2019-11-14 02:00:00','2019-11-14 04:00:00',1,'juan');
insert into jugar(fechain,fechafin,juego,jugador) values('2015-06-14 20:00:00','2016-06-14 22:00:00',3,'luis');
insert into retransmitir(fechain,fechafin,juego,jugador) values('2013-06-14 20:00:00','2013-06-14 22:00:00',1,'pepe');
insert into retransmitir(fechain,fechafin,juego,jugador) values('2018-06-14 20:00:00','2018-06-14 22:00:00',3,'pedro');
insert into tenercategoria(categoria,juego) values('mundo abierto',1);
insert into tenercategoria(categoria,juego) values('estrategia',2);
insert into tenercategoria(categoria,juego) values('mundo abierto',3);
insert into tenercategoria(categoria,juego) values('shooter',3);
