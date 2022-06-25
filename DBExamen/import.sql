/* Populate tabla clientes */

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
/* Creamos algunos usuarios con sus roles */
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









