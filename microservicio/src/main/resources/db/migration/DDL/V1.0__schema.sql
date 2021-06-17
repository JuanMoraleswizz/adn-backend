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
create table persona (
 id int(11) not null auto_increment,
 nombres varchar(100) not null,
 identificacion varchar(45) not null,
 primer_apellido varchar(30),
 segundo_apellido varchar(30),
 sexo varchar(10),
 primary key (id)
);
create table orden (
 id int(11) not null auto_increment,
 id_persona int(11) not null,
 fecha datetime not null,
 primary key (id)
);
create table orden_detalle (
 id int(11) not null auto_increment,
 id_orden int(11) not null,
 id_producto int(11) not null,
 valor_unitario double,
 cantidad double,
 sub_total double,
 iva double,
 descuento double,
 primary key (id)
);



