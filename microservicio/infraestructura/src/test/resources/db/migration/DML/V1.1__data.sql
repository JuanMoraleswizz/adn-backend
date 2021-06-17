insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());
insert into productos (codigo,nombre,presentacion,url_imagen, valor_unitario)
values('test','producto1','LB','NONE','2000');
insert into persona (identificacion,nombres,primer_apellido,segundo_apellido, sexo)
values('1038125422','JUAN DAVID','MORALES','MUÑOZ','MASCULINO');
insert into orden (id_persona,fecha)
values(1,now());
insert into orden_detalle (id_orden,id_producto,valor_unitario,cantidad,sub_total,iva,descuento)
values(1,1,1000.0,1.0,1000.0,0.0,0.0);
