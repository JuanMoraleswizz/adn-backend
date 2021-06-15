create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table productos (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 codigo varchar(45) not null,
 presentacion varchar(25),
 url_imagen varchar(100),
 valor_unitario DOUBLE,
 primary key (id)
);
