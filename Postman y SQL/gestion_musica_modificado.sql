-- Crear la base de datos
DROP DATABASE IF EXISTS gestionmusica;
CREATE DATABASE IF NOT EXISTS gestionmusica;
USE gestionmusica;

-- Tabla de listas de reproducción
CREATE TABLE listareproduccion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);

-- Tabla de canciones
CREATE TABLE canciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    artista VARCHAR(255) NOT NULL
);

-- Tabla intermedia para la relación muchos a muchos
CREATE TABLE listacancion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    listaid BIGINT NOT NULL,
    cancionid BIGINT NOT NULL,
    FOREIGN KEY (listaid) REFERENCES listareproduccion(id) ON DELETE CASCADE,
    FOREIGN KEY (cancionid) REFERENCES canciones(id) ON DELETE CASCADE
);

-- Insertar datos iniciales en ListasDeReproduccion
INSERT INTO listareproduccion (nombre, descripcion)
VALUES
('Rock Clásico', 'Las mejores canciones de rock clásico'),
('Pop Hits', 'Éxitos pop de los 80 y 90'),
('Indie Chill', 'Canciones relajantes de la escena indie'),
('Latino Fiesta', 'Éxitos latinos para bailar');

-- Insertar datos iniciales en Canciones
INSERT INTO canciones (titulo, artista)
VALUES
('Bohemian Rhapsody', 'Queen'),
('Stairway to Heaven', 'Led Zeppelin'),
('Hotel California', 'Eagles'),
('Sweet Child O\' Mine', 'Guns N\' Roses'),
('Smells Like Teen Spirit', 'Nirvana'),
('Imagine', 'John Lennon'),
('Yesterday', 'The Beatles'),
('Comfortably Numb', 'Pink Floyd'),
('Billie Jean', 'Michael Jackson'),
('Like a Virgin', 'Madonna'),
('Material Girl', 'Madonna'),
('Thriller', 'Michael Jackson'),
('I Want to Break Free', 'Queen'),
('With or Without You', 'U2'),
('Livin\' on a Prayer', 'Bon Jovi'),
('Every Breath You Take', 'The Police'),
('Africa', 'Toto'),
('Take On Me', 'A-ha'),
('Girls Just Want to Have Fun', 'Cyndi Lauper'),
('Time After Time', 'Cyndi Lauper'),
('Careless Whisper', 'George Michael'),
('Don’t Stop Believin\'', 'Journey'),
('November Rain', 'Guns N\' Roses'),
('Paradise City', 'Guns N\' Roses'),
('Enter Sandman', 'Metallica'),
('Nothing Else Matters', 'Metallica'),
('The Unforgiven', 'Metallica'),
('Wonderwall', 'Oasis'),
('Champagne Supernova', 'Oasis'),
('Zombie', 'The Cranberries'),
('Linger', 'The Cranberries'),
('Losing My Religion', 'R.E.M.'),
('Shiny Happy People', 'R.E.M.'),
('Black Hole Sun', 'Soundgarden'),
('Creep', 'Radiohead'),
('High and Dry', 'Radiohead'),
('Karma Police', 'Radiohead'),
('Clocks', 'Coldplay'),
('Yellow', 'Coldplay'),
('Viva La Vida', 'Coldplay'),
('Fix You', 'Coldplay'),
('Despacito', 'Luis Fonsi'),
('Bailando', 'Enrique Iglesias'),
('Mi Gente', 'J Balvin'),
('Tusa', 'Karol G'),
('Con Calma', 'Daddy Yankee'),
('Danza Kuduro', 'Don Omar'),
('Gasolina', 'Daddy Yankee'),
('Shape of You', 'Ed Sheeran'),
('Perfect', 'Ed Sheeran');

-- Insertar datos iniciales en Lista_Cancion (relaciones con las listas)
INSERT INTO listacancion (listaid, cancionid)
VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8),
(2, 9), (2, 10), (2, 11), (2, 12), (2, 13), (2, 14), (2, 15), (2, 16),
(3, 17), (3, 18), (3, 19), (3, 20), (3, 21), (3, 22), (3, 23), (3, 24),
(4, 25), (4, 26), (4, 27), (4, 28), (4, 29), (4, 30), (4, 31), (4, 32),
(4, 33), (4, 34), (4, 35), (4, 36), (4, 37), (4, 38), (4, 39), (4, 40),
(4, 41), (4, 42), (4, 43), (4, 44), (4, 45), (4, 46), (4, 47), (4, 48),
(4, 49), (4, 50);
