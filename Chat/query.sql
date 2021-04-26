CREATE TABLE Usuarios (
usuario varchar(20),
contraseña varchar(20)
);

alter table Usuarios add constraint usuarios_pk primary key (usuario);

INSERT INTO Usuarios (usuario, contraseña) VALUES ('Nahuel', 'Volpe');
INSERT INTO Usuarios (usuario, contraseña) VALUES ('Daniel', 'Suarez');
INSERT INTO Usuarios (usuario, contraseña) VALUES ('Jorge', 'Ledo');
INSERT INTO Usuarios (usuario, contraseña) VALUES ('Damian', 'Casafuz');


