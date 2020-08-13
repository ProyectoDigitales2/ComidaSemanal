#drop database if exists comida;
#create database comida;
#use comida;

create table ingrediente(
	id_ingrediente int auto_increment primary key  ,
    nombre varchar(50) unique
);

create table categoria(
	id_categoria int auto_increment primary key  ,
    categoria varchar(50) unique
);

create table comida(
	id_comida int auto_increment primary key  ,
    nombre varchar(50) unique,
    temperatura varchar(50),
    id_categoria int,
    FOREIGN key (id_categoria) references categoria(id_categoria)
);

create table plato(
	id_plato int auto_increment primary key  ,
    id_ingrediente int,
    id_comida int,
    FOREIGN key (id_ingrediente) references ingrediente(id_ingrediente),
    FOREIGN key (id_comida) references comida(id_comida)
);

create table fecha_comida(
	id_fecha_comida int auto_increment primary key,
    id_comida int,
    fecha date,
    tipo varchar(20) ,
    FOREIGN key (id_comida) references comida(id_comida)
);



