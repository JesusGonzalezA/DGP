CREATE DATABASE vale;

USE vale;
-- *****************************************************************************
CREATE TABLE users(
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50)
);



CREATE TABLE objetivos(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50),
    imagen VARCHAR(50)
);  


-- *****************************************************************************
INSERT INTO users(username,password) VALUES ('ana','0123');

INSERT INTO objetivos(nombre,descripcion) VALUES ('Lavarse las manos', 'Debes lavarte las manos que está el coronavirus');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Hacerse la cama', 'Debes hacerte la cama todos los días al levantarte');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Sacar a pasear al perro', 'Debes sacar a pasear al perro todos los días');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Ir a comprar', 'Debes hacer la compra de tu casa');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Beber 2 litros de agua', 'Debes beber agua para estar hidratado');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Leer un libro', 'Debes leer todos los días 30 minutos el libro que te guste');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Hacer un dibujo de tu familia', 'Debes pintar y colorear en una cartulina a tu familia');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Hacer una foto de tu lugar favorito', 'Debes sacar una foto, por ejemplo con el móvil');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Ver una película en inglés', 'Debes seleccionar el idioma: inglés/English. Puedes activar los subtítulos si lo necesitas');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Hacer una videollamada con tu mejor amigo', 'Debes llamar a tu mejor amigo porque hay que cuidarlo');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Hacer un dibujo con el programa: paint', 'Debes abrir tu ordenador y usar el programa ');
