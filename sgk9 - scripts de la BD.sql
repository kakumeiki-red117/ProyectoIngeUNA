
connect / as sysdba;

CREATE TABLESPACE sguc_perm_01
  DATAFILE 'sguc_perm_01.dat' 
    SIZE 10M
    REUSE
    AUTOEXTEND ON NEXT 10M MAXSIZE 200M;

CREATE TEMPORARY TABLESPACE sguc_temp_01
  TEMPFILE 'sguc_temp_01.dbf'
    SIZE 5M
    AUTOEXTEND ON;

create user sguc identified by k9sguc
DEFAULT TABLESPACE sguc_perm_01
  TEMPORARY TABLESPACE sguc_temp_01
  QUOTA 20M on sguc_perm_01;

GRANT create session TO sguc;
GRANT create table TO sguc;
GRANT create view TO sguc;
GRANT create any trigger TO sguc;
GRANT create any procedure TO sguc;
GRANT create sequence TO sguc;
GRANT create synonym TO sguc;


connect sguc/k9sguc;


create table provincias (
	nombre varchar(12),
	CONSTRAINT provincias_PK PRIMARY KEY (nombre)
);

create table cantones (
	nombre varchar(20),
	provincia varchar(12),
	CONSTRAINT cantones_PK PRIMARY KEY (nombre), 
	CONSTRAINT provincia_FK FOREIGN KEY (provincia)
	REFERENCES provincias (nombre)
);

create table distritos(
	nombre varchar(30),
	canton varchar(20),
	CONSTRAINT distritos_PK PRIMARY KEY (nombre,canton), 
	CONSTRAINT canton_FK FOREIGN KEY (canton)
	REFERENCES cantones (nombre)
);

create table usuarios(
	id varchar(20), 
	clave varchar(20), 
	tipo int,
	CONSTRAINT usuarios_PK PRIMARY KEY (id)
);

create table organismos(
	nombre varchar(20),
	CONSTRAINT organismos_PK PRIMARY KEY (nombre)
);

create table anunciantes(
	nombre varchar(20),
	CONSTRAINT anunciantes_PK PRIMARY KEY (nombre)
);

create table personas(
	id varchar(15),
	nombre varchar(30),
	apellido1 varchar(30),
	apellido2 varchar(30),
	sexo char(1),
	edad int,
	nacionalidad varchar(30),
	nacimiento date,
	CONSTRAINT personas_PK PRIMARY KEY (id)
);

create table oficiales(
	id varchar(20),
	unidad varchar(20),
	CONSTRAINT oficiales_PK PRIMARY KEY (id)
);

create table informes(
	id varchar(30),
	descripcion varchar(500),
	diligencias varchar(500),
	anunciante varchar(20),
	organismo varchar(20),
	movil_organismo varchar(8),
	asesor_legal varchar(20),
	movil_asesor varchar(8),
	mp_vigentes number(1),
	expediente varchar(20),
	fecha_notif date,
	tipo_doc varchar(20),
	num_folio varchar(10),
	CONSTRAINT informes_PK PRIMARY KEY (id),
	CONSTRAINT anunciante_FK FOREIGN KEY (anunciante)
	REFERENCES anunciantes (nombre),
	CONSTRAINT organismo_FK FOREIGN KEY (organismo)
	REFERENCES organismos (nombre),
	CONSTRAINT asesor_FK FOREIGN KEY (asesor_legal)
	REFERENCES organismos (nombre)
);

create table actas(
	id varchar(20),
	informe varchar(20) NOT NULL,
	detalles varchar(500),
	CONSTRAINT actas_PK PRIMARY KEY (id),
	CONSTRAINT informe_ac_FK FOREIGN KEY (informe)
	REFERENCES informes (id)
);

create table sitios(
	informe varchar(20),
	fecha_hora date,
	provincia varchar(12),
	canton varchar(20),
	distrito varchar(20),
	barrio varchar(50),
	direccion varchar(200),
	tipo_lugar varchar(30),
	CONSTRAINT sitios_PK PRIMARY KEY (informe),
	CONSTRAINT informe_s_FK FOREIGN KEY (informe)
	REFERENCES informes (id)
);

create table oficiales_ac(
	id varchar(20),
	informe varchar(20),
	hora_confec date,
	CONSTRAINT oac_PK PRIMARY KEY (id,informe),
	CONSTRAINT informe_oac_FK FOREIGN KEY (informe)
	REFERENCES informes (id),
	CONSTRAINT id_oac_FK FOREIGN KEY (id)
	REFERENCES oficiales (id)
);

create table oficiales_as(
	id varchar(20),
	informe varchar(20),
	CONSTRAINT oas_PK PRIMARY KEY (id,informe),
	CONSTRAINT informe_oas_FK FOREIGN KEY (informe)
	REFERENCES informes (id),
	CONSTRAINT id_oas_FK FOREIGN KEY (id)
	REFERENCES oficiales (id)
);

create table imputados(
	id varchar(20),
	informe varchar(20),
	acta varchar(20),
	direccion varchar(200),
	telefono varchar(10),
	alias varchar(30),
	aprehendido number(1),
	hora_aprehension date,
	entendidos number(1),
	motivo_nofirma varchar(15),
	rasgos varchar(200),
	vestimenta varchar(200),
	CONSTRAINT imputados_PK PRIMARY KEY (id,informe),
	CONSTRAINT informe_im_FK FOREIGN KEY (informe)
	REFERENCES informes (id),
	CONSTRAINT acta_im_FK FOREIGN KEY (acta)
	REFERENCES actas (id),
	CONSTRAINT id_im_FK FOREIGN KEY (id)
	REFERENCES personas (id)
);

create table ofendidos(
	id varchar(20),
	informe varchar(20),
	delito varchar(50),
	direccion varchar(200),
	telefono_casa varchar(10),
	telefono_trabajo varchar(10),
	telefono_movil varchar(10),
	oficio varchar(30),
	email varchar(30),
	CONSTRAINT ofendidos_PK PRIMARY KEY (id,informe),
	CONSTRAINT informe_of_FK FOREIGN KEY (informe)
	REFERENCES informes (id),
	CONSTRAINT id_of_FK FOREIGN KEY (id)
	REFERENCES personas (id)
);

create table testigos(
	id varchar(20),
	informe varchar(20),
	direccion varchar(200),
	lugar_trabajo varchar(50),
	telefono varchar(10),
	email varchar(30),
	CONSTRAINT testigos_PK PRIMARY KEY (id,informe),
	CONSTRAINT informe_te_FK FOREIGN KEY (informe)
	REFERENCES informes (id),
	CONSTRAINT id_te_FK FOREIGN KEY (id)
	REFERENCES personas (id)
);

--create table acta_imput(
--	acta varchar(20),
--	imputado varchar(20),
--	informe varchar(20),
--	CONSTRAINT acta_imput_PK PRIMARY KEY (acta,imputado,informe),
--	CONSTRAINT acta_ai_FK FOREIGN KEY (acta)
--	REFERENCES actas (id),
--	CONSTRAINT imput_ai_FK FOREIGN KEY (imputado,informe)
--	REFERENCES imputados (id,informe)
--);

CREATE VIEW V_IMPUTADOS AS SELECT P.ID,P.NOMBRE,P.APELLIDO1,P.APELLIDO2,P.SEXO,P.EDAD,P.NACIONALIDAD,P.NACIMIENTO,I.INFORME,I.ACTA,I.DIRECCION,I.TELEFONO,I.ALIAS,I.APREHENDIDO,I.HORA_APREHENSION,I.ENTENDIDOS,I.MOTIVO_NOFIRMA,I.RASGOS,I.VESTIMENTA FROM PERSONAS P, IMPUTADOS I WHERE P.ID = I.ID WITH READ ONLY;
CREATE VIEW V_OFENDIDOS AS SELECT P.ID,P.NOMBRE,P.APELLIDO1,P.APELLIDO2,P.SEXO,P.EDAD,P.NACIONALIDAD,P.NACIMIENTO,O.INFORME,O.DELITO,O.TELEFONO_CASA,O.TELEFONO_TRABAJO,O.TELEFONO_MOVIL,O.OFICIO,O.EMAIL FROM PERSONAS P, OFENDIDOS O WHERE P.ID = O.ID WITH READ ONLY;
CREATE VIEW V_TESTIGOS AS SELECT P.ID,P.NOMBRE,P.APELLIDO1,P.APELLIDO2,P.SEXO,P.EDAD,P.NACIONALIDAD,P.NACIMIENTO,T.INFORME,T.DIRECCION,T.LUGAR_TRABAJO,T.TELEFONO,T.EMAIL FROM PERSONAS P, TESTIGOS T WHERE P.ID = T.ID WITH READ ONLY;



insert into provincias values('San Jose');
insert into provincias values('Alajuela');
insert into provincias values('Cartago');
insert into provincias values('Heredia');
insert into provincias values('Guanacaste');
insert into provincias values('Puntarenas');
insert into provincias values('Limon');

insert into cantones values('San Jose','San Jose');
insert into cantones values('Escazu','San Jose');
insert into cantones values('Desamparados','San Jose');
insert into cantones values('Puriscal','San Jose');
insert into cantones values('Tarrazu','San Jose');
insert into cantones values('Aserri','San Jose');
insert into cantones values('Mora','San Jose');
insert into cantones values('Goicoechea','San Jose');
insert into cantones values('Santa Ana','San Jose');
insert into cantones values('Alajuelita','San Jose');
insert into cantones values('Vazquez de Coronado','San Jose');
insert into cantones values('Acosta','San Jose');
insert into cantones values('Tibas','San Jose');
insert into cantones values('Moravia','San Jose');
insert into cantones values('Montes de Oca','San Jose');
insert into cantones values('Turrubares','San Jose');
insert into cantones values('Dota','San Jose');
insert into cantones values('Curridabat','San Jose');
insert into cantones values('Perez Zeledon','San Jose');
insert into cantones values('Leon Cortes','San Jose');
insert into cantones values('Alajuela','Alajuela');
insert into cantones values('San Ramon','Alajuela');
insert into cantones values('Grecia','Alajuela');
insert into cantones values('San Mateo','Alajuela');
insert into cantones values('Atenas','Alajuela');
insert into cantones values('Naranjo','Alajuela');
insert into cantones values('Palmares','Alajuela');
insert into cantones values('Poas','Alajuela');
insert into cantones values('Orotina','Alajuela');
insert into cantones values('San Carlos','Alajuela');
insert into cantones values('Zarcero','Alajuela');
insert into cantones values('Valverde Vega','Alajuela');
insert into cantones values('Upala','Alajuela');
insert into cantones values('Los Chiles','Alajuela');
insert into cantones values('Guatuso','Alajuela');
insert into cantones values('Cartago','Cartago');
insert into cantones values('Paraiso','Cartago');
insert into cantones values('La Union','Cartago');
insert into cantones values('Jimenez','Cartago');
insert into cantones values('Turrialba','Cartago');
insert into cantones values('Alvarado','Cartago');
insert into cantones values('Oreamuno','Cartago');
insert into cantones values('El Guarco','Cartago');
insert into cantones values('Heredia','Heredia');
insert into cantones values('Barva','Heredia');
insert into cantones values('Santo Domingo','Heredia');
insert into cantones values('Santa Barbara','Heredia');
insert into cantones values('San Rafael','Heredia');
insert into cantones values('San Isidro','Heredia');
insert into cantones values('Belen','Heredia');
insert into cantones values('Flores','Heredia');
insert into cantones values('San Pablo','Heredia');
insert into cantones values('Sarapiqui','Heredia');
insert into cantones values('Liberia','Guanacaste');
insert into cantones values('Nicoya','Guanacaste');
insert into cantones values('Santa Cruz','Guanacaste');
insert into cantones values('Bagaces','Guanacaste');
insert into cantones values('Carrillo','Guanacaste');
insert into cantones values('Cañas','Guanacaste');
insert into cantones values('Abangares','Guanacaste');
insert into cantones values('Tilaran','Guanacaste');
insert into cantones values('Nandayure','Guanacaste');
insert into cantones values('La Cruz','Guanacaste');
insert into cantones values('Hojancha','Guanacaste');
insert into cantones values('Puntarenas','Puntarenas');
insert into cantones values('Esparza','Puntarenas');
insert into cantones values('Buenos Aires','Puntarenas');
insert into cantones values('Montes de Oro','Puntarenas');
insert into cantones values('Osa','Puntarenas');
insert into cantones values('Quepos','Puntarenas');
insert into cantones values('Golfito','Puntarenas');
insert into cantones values('Coto Brus','Puntarenas');
insert into cantones values('Parrita','Puntarenas');
insert into cantones values('Corredores','Puntarenas');
insert into cantones values('Garabito','Puntarenas');
insert into cantones values('Limon','Limon');
insert into cantones values('Pococi','Limon');
insert into cantones values('Siquirres','Limon');
insert into cantones values('Talamanca','Limon');
insert into cantones values('Matina','Limon');
insert into cantones values('Guacimo','Limon');

insert into distritos values('Carmen','San Jose');
insert into distritos values('Merced','San Jose');
insert into distritos values('Hospital','San Jose');
insert into distritos values('Catedral','San Jose');
insert into distritos values('Zapote','San Jose');
insert into distritos values('San Francisco de Dos Rios','San Jose');
insert into distritos values('Uruca','San Jose');
insert into distritos values('Mata Redonda','San Jose');
insert into distritos values('Pavas','San Jose');
insert into distritos values('Hatillo','San Jose');
insert into distritos values('San Sebastian','San Jose');
insert into distritos values('Escazu','Escazu');
insert into distritos values('San Antonio','Escazu');
insert into distritos values('San Rafael','Escazu');
insert into distritos values('Desamparados','Desamparados');
insert into distritos values('San Miguel','Desamparados');
insert into distritos values('San Juan de Dios','Desamparados');
insert into distritos values('San Rafael Arriba','Desamparados');
insert into distritos values('San Antonio','Desamparados');
insert into distritos values('Frailes','Desamparados');
insert into distritos values('Patarra','Desamparados');
insert into distritos values('San Cristobal','Desamparados');
insert into distritos values('Rosario','Desamparados');
insert into distritos values('Damas','Desamparados');
insert into distritos values('San Rafael Abajo','Desamparados');
insert into distritos values('Gravilias','Desamparados');
insert into distritos values('Los Guido','Desamparados');
insert into distritos values('Santiago','Puriscal');
insert into distritos values('Mercedes Sur','Puriscal');
insert into distritos values('Barbacoas','Puriscal');
insert into distritos values('Grifo Alto','Puriscal');
insert into distritos values('San Rafael','Puriscal');
insert into distritos values('Candelarita','Puriscal');
insert into distritos values('Desamparaditos','Puriscal');
insert into distritos values('San Antonio','Puriscal');
insert into distritos values('Chires','Puriscal');
insert into distritos values('San Marcos','Tarrazu');
insert into distritos values('San Lorenzo','Tarrazu');
insert into distritos values('San Carlos','Tarrazu');
insert into distritos values('Aserri','Aserri');
insert into distritos values('Tarbaca','Aserri');
insert into distritos values('Vuelta de Jorco','Aserri');
insert into distritos values('San Gabriel','Aserri');
insert into distritos values('Legua','Aserri');
insert into distritos values('Monterrey','Aserri');
insert into distritos values('Salitrillos','Aserri');
insert into distritos values('Ciudad Colon','Mora');
insert into distritos values('Guayabo','Mora');
insert into distritos values('Tabarcia','Mora');
insert into distritos values('Piedras Negras','Mora');
insert into distritos values('Picagres','Mora');
insert into distritos values('Jaris','Mora');
insert into distritos values('Quitirrisi','Mora');
insert into distritos values('Guadalupe','Goicoechea');
insert into distritos values('San Francisco','Goicoechea');
insert into distritos values('Calle Blancos','Goicoechea');
insert into distritos values('Mata de Platano','Goicoechea');
insert into distritos values('Ipis','Goicoechea');
insert into distritos values('Rancho Redondo','Goicoechea');
insert into distritos values('Purral','Goicoechea');
insert into distritos values('Santa Ana','Santa Ana');
insert into distritos values('Salitral','Santa Ana');
insert into distritos values('Pozos','Santa Ana');
insert into distritos values('Uruca','Santa Ana');
insert into distritos values('Piedades','Santa Ana');
insert into distritos values('Brasil','Santa Ana');
insert into distritos values('Alajuelita','Alajuelita');



insert into usuarios values('001','001',1);

insert into anunciantes values('Fuerza Publica');
insert into anunciantes values('Central Municipal');
insert into anunciantes values('Calidad Policial');
insert into anunciantes values('Denuncia');
insert into anunciantes values('Otro');

insert into organismos values('Bomberos');
insert into organismos values('OIJ');
insert into organismos values('Transito');
insert into organismos values('Otro');


insert into personas values(
	'112345678',
	'Juan',
	'Aguirre',
	'Aguilar',
	'M',
	23,
	'Costarricense',
	'19/dec/1985'
);
insert into personas values(
	'401344356',
	'Maria',
	'Fernandez',
	'Angulo',
	'F',
	43,
	'Costarricense',
	'1/jun/1977'
);

insert into personas values(
	'203451234',
	'Pedro',
	'Arguedas',
	'Esquivel',
	'M',
	32,
	'Costarricense',
	'6/sep/1984'
);

insert into personas values(
	'603456783',
	'Elena',
	'Fonseca',
	'Artavia',
	'F',
	36,
	'Costarricense',
	'16/feb/1980'
);

insert into personas values(
	'8345766',
	'Pablo Emilio',
	'Escobar',
	'Gaviria',
	'M',
	66,
	'Colombiano',
	'1/dec/1949'
);



insert into informes values(
	'1',
	'descrip afasa',
	'no se que va aqui',
	'Denuncia',
	'OIJ',
	'23',
	'Bomberos',
	'232',
	'1',
	'123',
	'11/oct/2016',
	'tipodoc1',
	'1422'
);

insert into sitios values(
	'1',
	to_date('11/oct/2016 11:34:22','DD:MON:YYYY HH24:MI:SS'),
	'Heredia',
	'Flores',
	'San Joaquin',
	'cinco esquinas',
	'a la par de la pulperia',
	'residencia'
);

insert into imputados values(
	'401344356',
	'1',
	'',
	'por alla',
	'54323456',
	'La Mami',
	1,
	to_date('11:55:34','HH24:MI:SS'),
	0,
	'no sabe',
	'fea',
	'ninguna'
);

insert into imputados values(
	'8345766',
	'1',
	'',
	'por alla',
	'76523493',
	'El Patron',
	1,
	to_date('23:55:34','HH24:MI:SS'),
	1,
	'no quiso',
	'gordo y feo',
	'camisa blanca, pantalon verde'
);

insert into ofendidos values(
	'203451234',
	'1',
	'robo agravado',
	'por aqui',
	'22453233',
	'25955432',
	'87323233',
	'panadero',
	'pana_dero@hotmail.com'
);

insert into testigos values(
	'603456783',
	'1',
	'por el palo de mango',
	'ICE',
	'88555324',
	'hello_ele@hotmail.com'
);

insert into actas values(
	'1',
	'1',
	'La vara es que el mae tenia la puya y se la quitamos'
);

--insert into acta_imput values(
--	'1',
--	'8345766',
--	'1'
--);

commit;

--views
--CREATE VIEW V_IMPUTADOS AS SELECT P.ID,P.NOMBRE,P.APELLIDO1,P.APELLIDO2,P.SEXO,P.EDAD,P.NACIONALIDAD,P.NACIMIENTO,I.INFORME,I.DIRECCION,I.TELEFONO,I.ALIAS,I.APREHENDIDO,I.HORA_APREHENSION,I.ENTENDIDOS,I.MOTIVO_NOFIRMA,I.RASGOS,I.VESTIMENTA FROM PERSONAS P, IMPUTADOS I WHERE P.ID = I.ID;

--select im.id,im.informe, direccion, telefono, alias, aprehendido, hora_aprehension, entendidos, motivo_nofirma, rasgos, vestimenta from imputados im,(select imputado,informe from acta_imput where acta='1') i where im.id=i.imputado and im.informe=i.informe;
--select * from imputados im where im.id=(select imputado from acta_imput where acta='1');
--select to_char(fecha_notif,'HH24:MI:SS') from informes;
--select nombre from distritos,(select nombre n from cantones where provincia='San Jose') cant where canton=n;


--SE USA SOLAMENTE PARA ELIMINAR TODAS LAS TABLAS, EL SCHEMA, 
--EL USUARIO Y LOS TABLESPACES DE SGUC.
--PARA QUE SE ELIMINE EL USUARIO, DEBE ESTAR DESCONECTADO.
 /*
 
connect sguc/k9sguc;

DROP TABLE acta_imput cascade constraints PURGE;
DROP TABLE actas cascade constraints PURGE;
DROP TABLE testigos cascade constraints PURGE;
DROP TABLE ofendidos cascade constraints PURGE;
DROP TABLE imputados cascade constraints PURGE;
DROP TABLE oficiales_as cascade constraints PURGE;
DROP TABLE oficiales_ac cascade constraints PURGE;
DROP TABLE sitios cascade constraints PURGE;
DROP TABLE informes cascade constraints PURGE;
DROP TABLE oficiales cascade constraints PURGE;
DROP TABLE personas cascade constraints PURGE;
DROP TABLE anunciantes cascade constraints PURGE;
DROP TABLE organismos cascade constraints PURGE;
DROP TABLE usuarios cascade constraints PURGE;
DROP TABLE distritos cascade constraints PURGE;
DROP TABLE cantones cascade constraints PURGE;
DROP TABLE provincias cascade constraints PURGE;

connect / as sysdba;

drop user sguc cascade;


DROP TABLESPACE sguc_perm_01 
    INCLUDING CONTENTS 
	and datafiles
    CASCADE CONSTRAINTS; 

DROP TABLESPACE sguc_temp_01 
    INCLUDING CONTENTS 
	and datafiles
    CASCADE CONSTRAINTS; 
	
*/