create database SmartHouse;
use SmartHouse;

create table Usuario (
idUsuario int (50) PRIMARY KEY NOT NULL auto_increment,
nombre varchar (50),
apellido_Materno varchar(50),
apellido_Paterno varchar(50),
telefono_Movil varchar(10),
email varchar(100),
contrasenia varchar(100)
);

create table Casa (
idCasa int (100) PRIMARY KEY NOT NULL auto_increment,
idUsuario int(50),
Coordenadas varchar(200) not null,
Estado varchar(25) not null,
Municipio varchar(25) not null,
CodigoPostal char(5) not null,
Colonia varchar(25) not null,
Calle varchar(25) not null,
Numero_Interior varchar(10) not null,
foreign key (idUsuario) references usuario(idUsuario) on delete cascade on update cascade
);

create table Catalogo_Dispositivos(
idTipo_Dispo int(5) PRIMARY KEY NOT NULL auto_increment,
nombre varchar(20),
descripcion varchar(25)
);

create table Cuarto(
idCuarto int(20) PRIMARY KEY NOT NULL auto_increment,
idCasa int(100),
nombre varchar(100),
numero_Piso int(100),
observacion varchar(100),
foreign key(idCasa) references Casa(idCasa) on delete cascade on update cascade
);


create table Cuarto_Dispositivos(
idCuarto_Disp int(20) PRIMARY KEY NOT NULL auto_increment,
idCuarto int(100),
idTipo_Dispo int(5),
foreign key(idCuarto) references Cuarto(idCuarto) on delete cascade on update cascade,
foreign key(idTipo_Dispo) references Catalogo_Dispositivos(idTipo_Dispo) on delete cascade on update cascade
);

create table Uso_Dispositivo(
idUso_Dispo int(20) PRIMARY KEY NOT NULL auto_increment,
idCuarto_Disp int(20),
estado boolean,
inicio_Uso datetime,
fin_Uso datetime,
foreign key(idCuarto_Disp) references Cuarto_Dispositivos(idCuarto_Disp) on delete cascade on update cascade
);