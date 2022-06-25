/* Populate tabla pruebaapp */


create database pruebaapp;

/* Creamos algunos usuarios  */
create table empleados (id bigint not null auto_increment, apellido varchar(255) not null, fecha_nacimiento datetime not null, nombre varchar(255) not null, genero_id bigint, trabajo_id bigint, primary key (id)) engine=InnoDB;
create table genero (id bigint not null auto_increment, nombre_genero varchar(255), primary key (id)) engine=InnoDB;
create table horas_trabajadas_empleado (id bigint not null auto_increment, fecha_fin datetime, fecha_inicio datetime, fecha_trabajada datetime not null, horas_trabajadas integer not null, empleado_id bigint, primary key (id)) engine=InnoDB;
create table trabajos (id bigint not null auto_increment, nombre varchar(255), salario integer, primary key (id)) engine=InnoDB;
alter table empleados add constraint UK_hrfkpwtx1utho5rhbtsk033mg unique (apellido);
alter table empleados add constraint UK_2gtnln88efafg8bjid1tkvvat unique (fecha_nacimiento);
alter table empleados add constraint UK_rk8dny0co9iojg17tfvv9t1ku unique (nombre);
alter table horas_trabajadas_empleado add constraint UK_q7oe5q2l8mjldardnlqvnyu5l unique (fecha_trabajada);
 alter table horas_trabajadas_empleado add constraint UK_hrxmxwpdn5xxmsqamwa9ddsri unique (horas_trabajadas);
 alter table empleados add constraint FKgg8h2wwlajt1rxc4442fw563n foreign key (genero_id) references genero (id);
 alter table empleados add constraint FKqy74f144197q55nd2nfbeves7 foreign key (trabajo_id) references trabajos (id);
 alter table horas_trabajadas_empleado add constraint FKh19wyj4mui4a53ummnilsmbim foreign key (empleado_id) references empleados (id);

INSERT INTO genero (nombre_genero) VALUES ('hombre');
INSERT INTO genero (nombre_genero) VALUES ('mujer');
INSERT INTO trabajos (nombre, salario) VALUES ('gerente', 100);
INSERT INTO trabajos (nombre, salario) VALUES ('programador', 800);
INSERT INTO trabajos (nombre, salario) VALUES ('enfermera', 100);
INSERT INTO trabajos (nombre, salario) VALUES ('contador', 800);
INSERT INTO trabajos (nombre, salario) VALUES ('gestion', 100);
INSERT INTO trabajos (nombre, salario) VALUES ('doctora', 800);
INSERT INTO trabajos (nombre, salario) VALUES ('enfermera', 100);
INSERT INTO trabajos (nombre, salario) VALUES ('contador', 800);
INSERT INTO empleados (  apellido, fecha_nacimiento, nombre, genero_id, trabajo_id ) VALUES('hernandez','1996-01-01', 'andres',1,1);
INSERT INTO empleados (  apellido, fecha_nacimiento, nombre, genero_id, trabajo_id ) VALUES('quinto','1997-01-01', 'rafael',1,2);
INSERT INTO empleados (  apellido, fecha_nacimiento, nombre, genero_id, trabajo_id ) VALUES('flores','1998-01-01', 'joel',1,4);
INSERT INTO empleados (  apellido, fecha_nacimiento, nombre, genero_id, trabajo_id ) VALUES('garcia','1999-01-01', 'alejandro',1,5);
INSERT INTO empleados (  apellido, fecha_nacimiento, nombre, genero_id, trabajo_id ) VALUES('patiño','1994-01-01', 'luis',1,2);
INSERT INTO empleados (  apellido, fecha_nacimiento, nombre, genero_id, trabajo_id ) VALUES('salgado','1993-01-01', 'jose',1,8);
INSERT INTO empleados (  apellido, fecha_nacimiento, nombre, genero_id, trabajo_id ) VALUES('martines','1992-01-01', 'maria',2,3);
INSERT INTO empleados (  apellido, fecha_nacimiento, nombre, genero_id, trabajo_id ) VALUES('lopez','1991-01-01', 'lupita',2,6);


INSERT INTO horas_Trabajadas_Empleado(fecha_trabajada,fecha_fin,fecha_inicio,horas_trabajadas,empleado_id) VALUES ( '2022-06-01','2022-01-01','2020-01-01',11,1);
INSERT INTO horas_Trabajadas_Empleado(fecha_trabajada,fecha_fin,fecha_inicio,horas_trabajadas,empleado_id) VALUES ( '2022-06-02','2022-01-02','2021-01-02',19,2);
INSERT INTO horas_Trabajadas_Empleado(fecha_trabajada,fecha_fin,fecha_inicio,horas_trabajadas,empleado_id) VALUES ( '2022-06-03','2022-01-01','2020-01-03',10,3);
INSERT INTO horas_Trabajadas_Empleado(fecha_trabajada,fecha_fin,fecha_inicio,horas_trabajadas,empleado_id) VALUES ( '2022-06-04','2022-01-02','2021-01-04',9,4);
INSERT INTO horas_Trabajadas_Empleado(fecha_trabajada,fecha_fin,fecha_inicio,horas_trabajadas,empleado_id) VALUES ( '2022-06-05','2022-01-01','2020-01-05',18,5);
INSERT INTO horas_Trabajadas_Empleado(fecha_trabajada,fecha_fin,fecha_inicio,horas_trabajadas,empleado_id) VALUES ( '2022-06-06','2022-01-02','2021-01-06',12,6);
INSERT INTO horas_Trabajadas_Empleado(fecha_trabajada,fecha_fin,fecha_inicio,horas_trabajadas,empleado_id) VALUES ( '2022-06-07','2022-01-01','2020-01-07',14,7);
INSERT INTO horas_Trabajadas_Empleado(fecha_trabajada,fecha_fin,fecha_inicio,horas_trabajadas,empleado_id) VALUES ( '2022-06-08','2022-01-02','2021-01-08',16,8);









