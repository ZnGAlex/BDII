create table Administrador
(
	nick varchar(20) not null primary key,
	clave varchar(20) not null,
	correo varchar(60),
	fecha_nac date,
	sueldo integer not null default 1000
);

create table Jugador
(
	nick varchar(20) not null primary key,
	clave varchar(100) not null,
	correo varchar(60),
	fec_nacimiento date,
	baneado boolean not null default false
);

create table SerAmigo
(
	jugador varchar(20) not null,
	amigo varchar(20) not null,
	primary key(jugador,amigo),
	foreign key(jugador) references jugador(nick)
	on delete cascade on update cascade,
	foreign key(amigo) references jugador(nick)
	on delete cascade on update cascade
);

create table Bloquear
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

create table Categoria
(
	nombre varchar(30) not null primary key,
	descripcion varchar(300) not null
);

create table Desarrolladora
(
	nombre varchar(30) not null primary key,
	pais varchar(30) not null
);

create table Juego
(
	id serial primary key, 
	nombre varchar(40) not null unique,
	edadrecomendada integer,
	desarrolladora varchar(30),
	foreign key(desarrolladora) references desarrolladora(nombre)
	on delete set null on update cascade
);

create table Complemento
(
	nombre varchar(40) not null,
	descripcion varchar(500),
	juego integer not null,
	primary key(nombre,juego),
	foreign key(juego) references Juego(id)
	on delete cascade on update cascade
);

create table Logro
(
	nombre varchar(30) not null,
	descripcion varchar(500),
	puntos integer not null default 10,
	juego integer not null,
	primary key(nombre,juego),
	foreign key(juego) references Juego(id)
	on delete cascade on update cascade
);

create table TenerCategoria
(
	categoria varchar(30) not null,
	juego integer not null,
	primary key(categoria,juego),
	foreign key(juego) references Juego(id)
	on delete cascade on update cascade,
	foreign key(categoria) references Categoria(nombre)
	on delete cascade on update cascade
);

create table Jugar
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

create table Retransmitir
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

create table Comprar
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

create table ConseguirLogro
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
