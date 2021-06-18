select id,id_orden, id_producto, valor_unitario, cantidad, iva,descuento
from orden_detalle
where id_orden= :idOrden;