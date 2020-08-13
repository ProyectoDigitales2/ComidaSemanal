use comida;

DROP PROCEDURE IF EXISTS buscarComida;
DELIMITER //
CREATE PROCEDURE buscarComida(comida varchar(50))
BEGIN
	select p.id_plato ,
			i.id_ingrediente, 
            i.nombre, 
            c.nombre 
	from ingrediente i, 
			comida c, 
			plato p 
	where p.id_ingrediente=i.id_ingrediente 
		and p.id_comida=c.id_comida 
        and c.nombre like CONCAT( comida , '%'); 
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE agregarIngrediente(comida varchar(50))
BEGIN
	insert into ingrediente (nombre) VALUES (comida);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE modificarIngrediente(in nombreI varchar(50))
BEGIN
	update ingrediente set nombre =nombreI where nombre=nombreI;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE agregarComida(in nombreP varchar(50), in tempt varchar(50), in catg varchar(50))
BEGIN
	INSERT INTO comida (nombre, temperatura, id_categoria) VALUES(nombreP,tempt, (select id_categoria from categoria where categoria=catg));
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE eliminarComida(in nombreP varchar(50))
BEGIN
	delete from comida  where nombre=nombreP;
    delete from plato where id_comida= (select id_comida from comida where nombre=nombreP);
END //
DELIMITER ;

select c.nombre, ca.categoria from comida c, categoria ca where c.id_categoria = ca.id_categoria ;

DELIMITER //
CREATE PROCEDURE agregarPlato(in nombreC varchar(50), in nombreI varchar(50) )
BEGIN
	INSERT INTO plato(id_comida,id_ingrediente) 
    select c.id_comida , i.id_ingrediente from comida c, ingrediente i where nombreC=c.nombre and  nombreI=i.nombre ;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE agregar_fecha_comida(in nombreC varchar(50), in _date date, in tipoC varchar(20) )
BEGIN
	INSERT INTO fecha_comida(id_comida,fecha,tipo) 
	values((select id_comida from comida where nombre=nombreC),_date,tipoC);
END //
DELIMITER ;
/*
DELIMITER //
CREATE PROCEDURE mostrar_catorce_ultimos()
BEGIN
	select * from (select from comida c, plato p, fecha_comida f where c.) comida ;
END //
DELIMITER ;*/

/*select * from (select c.nombre, f.fecha from comida c, fecha_comida f 
where c.id_comida= f.id_comida 
order by f.id_fecha_comida desc limit 14 ) as fech order by fech.id_comida ;*/

/*update comida set nombre= '',  temperatura='', categoria=(select id_categoria from categoria where categoria='') where id_comida='';--

select fec.id_fecha_comida, c.nombre, f.fecha from comida c 
right join fecha_comida f on c.id_comida= f.id_comida ;

SELECT * from fecha_comida;
select * from comida order by id_comida desc;


select c.nombre, i.nombre from plato p, comida c, ingrediente i where c.id_comida=37 and i.id_ingrediente=p.id_ingrediente and c.id_comida=p.id_comida;
select * from ingrediente order by id_ingrediente desc;

SELECT MAX(id_comida) as id FROM comida;

select i.nombre from ingrediente i, comida c, plato p where p.id_ingrediente = i.id_ingrediente and c.id_comida= p.id_comida and c.id_comida=?;
update Fecha_Comida 
            set fecha =?, id_comida=(select id_comida from Comida where nombre = ?), tipo = ? 
            where id_fecha_comida= ? ;*/
            
/*SELECT LAST_INSERT_ID('comida');

delete from plato where id_ingrediente = (select id_ingrediente from ingrediente where nombre = 0) and 
id_comida = 0;

select c.nombre as nombre 
from comida c, fecha_comida fc 
where c.id_comida= fc.id_comida and fc.fecha between '2020-03-16' and '2020-03-19';

select nombre, id_ingrediente from ingrediente where nombre like '%tom%';

select distinct i.nombre from ingrediente i, comida c, plato pl , fecha_comida fc 
where c.id_comida= fc.id_comida and pl.id_comida=c.id_comida and i.id_ingrediente=pl.id_ingrediente
 and fc.fecha between '2020-03-16' and '2020-03-19';

select fa.id_fecha_comida as ID, c.nombre as Comida, fa.fecha as Fecha, fa.tipo as Tipo 
from fecha_comida fa join comida c on c.id_comida= fa.id_comida
where fa.fecha between ? and DATE_ADD(?, INTERVAL 7 DAY);

select * from comida c, categoria cat  ;*/
