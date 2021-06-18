SELECT
 orden.id,
 persona.id AS id_persona,
 CONCAT(persona.nombres,' ',persona.primer_apellido,' ',persona.segundo_apellido) AS cliente,
 persona.identificacion,
 orden.fecha,
 SUM(orden_detalle.sub_total) as valor_total
FROM orden
INNER JOIN orden_detalle
ON(orden.id = orden_detalle.id_orden)
INNER JOIN persona
ON (persona.id = orden.id_persona)
where orden.id_persona = :idPersona
GROUP BY orden.id
