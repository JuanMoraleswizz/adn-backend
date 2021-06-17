update orden_detalle
set id_producto = :idProducto,
	 valor_unitario= :valorUnitario,
	cantidad= :cantidad,
	iva = :iva,
	descuento =:descuento
where id = :id