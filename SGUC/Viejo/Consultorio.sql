CREATE DATABASE Consultorio;

use Consultorio;

create table Usuario (
  id varchar(20) not null primary key,
  clave varchar(20),
  tipo integer
);

create table Paciente (
 id  varchar(20) not null primary key,
 nombre varchar(30),
 nacimiento date,
 correo varchar(30),
 direccion varchar(100),
 telefono varchar(10)
);

alter table Paciente
  add constraint foreign key (id) references  Usuario (id);
  
create table Medico (
 id  varchar(20) not null primary key,
 nombre varchar(30),
 correo varchar(30),
 telefono varchar(10)
);

alter table Medico
  add constraint foreign key (id) references  Usuario (id);

create table Cita (
 paciente varchar(20),
 medico varchar(20),
 fecha date,
 hora time,
 descripcion varchar(100),
 id integer auto_increment not null primary key,
 realizada integer
);

alter table Cita
  add constraint foreign key (paciente) references  Paciente (id);
alter table Cita
  add constraint foreign key (medico) references  Medico (id);

create table Observacion (
 fecha date,
 hora time,
 contenido varchar(255),
 cita integer not null
);

alter table Observacion
  add constraint foreign key (cita) references  Cita (id);


insert into Usuario (id,clave,tipo) values ('001','001', 1);
insert into Usuario (id,clave,tipo) values ('002','002', 1);
