update productos
set nombre = :nombre,
	codigo = :codigo,
	presentacion = :presentacion,
	url_imagen = :urlImagen,
	valor_unitario = :valorUnitario
where id = :id