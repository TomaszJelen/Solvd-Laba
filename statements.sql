INSERT INTO readers (name, surname) 
VALUES ('John',  'Smith'),
('Elisabeth',  'Smith'),
('Irene',  'Smith'),
('Error',  'Error');
UPDATE readers
SET name = 'Alfred', surname = 'Schmidt'
WHERE name = 'Error';
SELECT * FROM readers;
SELECT surname, COUNT(*) FROM readers
GROUP BY surname;
SELECT surname, COUNT(*) FROM readers
GROUP BY surname
HAVING COUNT(*) > 1;

INSERT INTO librarians (name, surname)
VALUES ('Arthur',  'Jones'),
('Error',  'Gaul');
UPDATE readers
SET name = 'Philip'
WHERE name = 'Error';
SELECT * FROM librarians;

INSERT INTO shifts (librarians_id, `from`, `to`)
values (1, '01:00', '18:00'),
(2, '12:00', '20:00');
UPDATE shifts
SET `from` = '10:00'
WHERE `from` = '01:00';
SELECT * FROM shifts;
SELECT * from shifts s
RIGHT JOIN librarians l
ON s.librarians_id = l.id;
SELECT `from`, MAX(`to`) FROM shifts
GROUP BY `from`;
SELECT `from`, MAX(`to`) FROM shifts
GROUP BY `from`
HAVING MAX(`to`) = '18:00';

INSERT INTO rooms (purpose)
values ('Main room'),
('Reading room'),
('Error');
UPDATE rooms
SET purpose = 'Reading room'
WHERE purpose = 'Error';
SELECT * FROM rooms;
SELECT purpose, COUNT(*) FROM rooms
GROUP BY purpose;
SELECT purpose, COUNT(*) FROM rooms
GROUP BY purpose
HAVING COUNT(*) > 1;

INSERT INTO computers (rooms_id, operating_system)
values (1, 'Windows'),
(1, 'Windows'),
(1, 'Error');
UPDATE computers
SET operating_system = 'Linux'
WHERE operating_system = 'Error';
SELECT * FROM computers;
SELECT * FROM computers c
LEFT JOIN rooms r
ON c.rooms_id = r.id;
SELECT operating_system, COUNT(*) FROM computers
GROUP BY operating_system;
SELECT operating_system, COUNT(*) FROM computers
GROUP BY operating_system
HAVING COUNT(*) > 1;

INSERT INTO bookshelves (rooms_id, avg_capacity)
values (1, 0),
(1, 1000),
(2, 500);
UPDATE bookshelves
SET avg_capacity = 1000
WHERE avg_capacity = 0;
SELECT * FROM bookshelves;
SELECT avg_capacity, COUNT(*) FROM bookshelves
GROUP BY avg_capacity;
SELECT avg_capacity, COUNT(*) FROM bookshelves
GROUP BY avg_capacity
HAVING COUNT(*) > 1;
SELECT rooms_id, SUM(avg_capacity) FROM bookshelves
GROUP BY rooms_id;
SELECT rooms_id, SUM(avg_capacity) FROM bookshelves
GROUP BY rooms_id
HAVING SUM(avg_capacity) > 1000;

INSERT INTO authors (name, surname)
VALUES ('Error',  'Alighieri');
UPDATE authors
SET name = 'Etnad'
WHERE name = 'Error';
UPDATE authors
SET name = 'Dante'
WHERE name = 'Etnad';
SELECT * FROM authors;

INSERT INTO books (bookshelves_id, title)
values (1,  'Error');
UPDATE books
SET title = 'Divine comedy'
WHERE title = 'Error';
SELECT * FROM books;
SELECT * FROM books b
INNER JOIN bookshelves bs
ON b.bookshelves_id = bs.id;

INSERT INTO books_has_authors (books_id, authors_id)
values (1,  1);
SELECT * FROM books_has_authors;

INSERT INTO genres (name)
values ('Error');
UPDATE genres
SET name = 'Fiction'
WHERE name = 'Error';
SELECT * FROM genres;

INSERT INTO books_has_genres (books_id, genres_id)
values (1,  1);
SELECT * FROM books_has_genres;
SELECT * FROM books_has_genres bg
INNER JOIN books b
ON bg.books_id = b.id
INNER JOIN genres g
ON bg.genres_id = g.id; 

INSERT INTO `borrowings&reservations` (readers_id, books_id, librarians_id, `from`)
values (1, 1,  2, '2025-01-01');
SELECT * FROM `borrowings&reservations`;
SELECT readers_id, COUNT(*) FROM `borrowings&reservations`
GROUP BY readers_id;
SELECT books_id, COUNT(*) FROM `borrowings&reservations`
GROUP BY books_id
HAVING COUNT(*) > 1;

-----------------------------------------------
SELECT g.name, a.name, a.surname, c.operating_system, s.`from`, s.`to`  FROM readers r
INNER JOIN `borrowings&reservations` br
ON r.id = br.readers_id
INNER JOIN librarians l
ON br.librarians_id = l.id
INNER JOIN shifts s
ON l.id = s.librarians_id
INNER JOIN books b
ON br.books_id = b.id
INNER JOIN books_has_genres bg
ON b.id = bg.books_id
INNER JOIN genres g
ON bg.genres_id = g.id
INNER JOIN books_has_authors ba
ON b.id = ba.books_id
INNER JOIN authors a
ON ba.authors_id = a.id
INNER JOIN bookshelves bs
ON b.bookshelves_id = bs.id
INNER JOIN rooms ro
ON bs.rooms_id = ro.id
INNER JOIN computers c
ON ro.id = c.rooms_id
WHERE r.name = 'John' AND r.surname = 'Smith';
--------------------------------------------------


DELETE FROM `borrowings&reservations`
WHERE id > 0;
ALTER TABLE `borrowings&reservations` AUTO_INCREMENT = 1;

TRUNCATE table books_has_genres;

DELETE FROM genres
WHERE id > 0;
ALTER TABLE genres AUTO_INCREMENT = 1;

TRUNCATE table books_has_authors;

DELETE FROM books
WHERE id > 0;
ALTER TABLE books AUTO_INCREMENT = 1;

DELETE FROM authors
WHERE id > 0;
ALTER TABLE authors AUTO_INCREMENT = 1;

DELETE FROM bookshelves
WHERE id > 0;
ALTER TABLE bookshelves AUTO_INCREMENT = 1;

DELETE FROM computers
WHERE id > 0;
ALTER TABLE computers AUTO_INCREMENT = 1;

DELETE FROM rooms
WHERE id > 0;
ALTER TABLE rooms AUTO_INCREMENT = 1;

DELETE FROM shifts
WHERE id > 0;
ALTER TABLE shifts AUTO_INCREMENT = 1;

DELETE FROM librarians
WHERE id > 0;
ALTER TABLE librarians AUTO_INCREMENT = 1;

DELETE FROM readers
WHERE id > 0;
ALTER TABLE readers AUTO_INCREMENT = 1;