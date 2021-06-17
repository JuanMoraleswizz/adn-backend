update persona
set nombres = :nombres,
	 identificacion= :identificacion,
	primer_apellido = :primerApellido,
	segundo_apellido = :segundoApellido,
	sexo = :sexo
where id = :id