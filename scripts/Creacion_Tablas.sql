CREATE EXTENSION pgcrypto;

CREATE TABLE Administrador
(
	nick varchar(20) not null primary key,
	clave varchar(100) not null,
	correo varchar(60),
	fec_nacimiento date,
	sueldo integer not null default 1000
);

CREATE TABLE Jugador
(
	nick varchar(20) not null primary key,
	clave varchar(100) not null,
	correo varchar(60),
	fec_nacimiento date,
	baneado boolean not null default false
);

CREATE TABLE SerAmigo
(
	jugador varchar(20) not null,
	amigo varchar(20) not null,
	primary key(jugador,amigo),
	foreign key(jugador) references jugador(nick)
	on delete cascade on update cascade,
	foreign key(amigo) references jugador(nick)
	on delete cascade on update cascade
);

CREATE TABLE Bloquear
(
	jugador varchar(20) not null,
	bloqueado varchar(20) not null,
	fecha timestamp not null default CURRENT_TIMESTAMP,
	motivo varchar(200),
	primary key(jugador,bloqueado,fecha),
	foreign key(jugador) references jugador(nick)
	on delete cascade on update cascade,
	foreign key(bloqueado) references jugador(nick)
	on delete cascade on update cascade
);

CREATE TABLE Categoria
(
	nombre varchar(30) not null primary key,
	descripcion varchar(300) not null
);

CREATE TABLE Desarrolladora
(
	nombre varchar(30) not null primary key,
	pais varchar(30) not null
);

CREATE TABLE Juego
(
	id serial primary key, 
	nombre varchar(40) not null unique,
	edadrecomendada integer,
	desarrolladora varchar(30),
	foreign key(desarrolladora) references desarrolladora(nombre)
	on delete set null on update cascade
);

CREATE TABLE Complemento
(
	nombre varchar(40) not null,
	descripcion varchar(500),
	juego integer not null,
	primary key(nombre,juego),
	foreign key(juego) references Juego(id)
	on delete cascade on update cascade
);

CREATE TABLE Logro
(
	nombre varchar(30) not null,
	descripcion varchar(500),
	puntos integer not null default 10,
	juego integer not null,
	primary key(nombre,juego),
	foreign key(juego) references Juego(id)
	on delete cascade on update cascade
);

CREATE TABLE TenerCategoria
(
	categoria varchar(30) not null,
	juego integer not null,
	primary key(categoria,juego),
	foreign key(juego) references Juego(id)
	on delete cascade on update cascade,
	foreign key(categoria) references Categoria(nombre)
	on delete cascade on update cascade
);

CREATE TABLE Jugar
(
	fechaIn timestamp not null default CURRENT_TIMESTAMP,
	fechaFin timestamp,
	juego integer not null,
	jugador varchar(30) not null,
	primary key(jugador,juego,fechaIn),
	foreign key(juego) references Juego(id)
	on delete cascade on update cascade,
	foreign key(jugador) references Jugador(nick)
	on delete cascade on update cascade
);

CREATE TABLE Retransmitir
(
	fechaIn timestamp not null default CURRENT_TIMESTAMP,
	fechaFin timestamp,
	juego integer not null,
	jugador varchar(30) not null,
	primary key(jugador,juego,fechaIn),
	foreign key(juego) references Juego(id)
	on delete cascade on update cascade,
	foreign key(jugador) references Jugador(nick)
	on delete cascade on update cascade
);

CREATE TABLE Comprar
(
	fecha date not null default CURRENT_TIMESTAMP,
	visibilidad boolean not null default false,
	juego integer not null,
	jugador varchar(30) not null,
	primary key(jugador,juego,fecha),
	foreign key(juego) references Juego(id)
	on delete cascade on update cascade,
	foreign key(jugador) references Jugador(nick)
	on delete cascade on update cascade
);

CREATE TABLE ConseguirLogro
(
	fecha date not null default CURRENT_TIMESTAMP,
	visibilidad boolean not null default false,
	juego integer not null,
	jugador varchar(30) not null,
	logro varchar(30) not null,
	primary key(jugador,logro,juego),
	foreign key(logro,juego) references Logro(nombre,juego)
	on delete cascade on update cascade,
	foreign key(jugador) references Jugador(nick)
	on delete cascade on update cascade
);
