CREATE TABLE IF NOT EXISTS member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    cash INT NOT NULL
);

CREATE TABLE IF NOT EXISTS book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price INT NOT NULL
);

CREATE TABLE IF NOT EXISTS pozajmica (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    datum_pozajmljivanja DATE NOT NULL,
    member_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    CONSTRAINT fk_pozajmica_member FOREIGN KEY (member_id) REFERENCES member(id),
    CONSTRAINT fk_pozajmica_book FOREIGN KEY (book_id) REFERENCES book(id)
);

INSERT INTO member (id, name, surname, cash)
SELECT 1, 'Tajra', 'Tasic', 999
WHERE NOT EXISTS (SELECT 1 FROM member WHERE id = 1);

INSERT INTO member (id, name, surname, cash)
SELECT 2, 'Samer', 'Kolasevic', 200
WHERE NOT EXISTS (SELECT 1 FROM member WHERE id = 2);

INSERT INTO member (id, name, surname, cash)
SELECT 3, 'Amina', 'Hadzic', 500
WHERE NOT EXISTS (SELECT 1 FROM member WHERE id = 3);

INSERT INTO book (id, title, author, price)
SELECT 1, '1984', 'Orwell', 40
WHERE NOT EXISTS (SELECT 1 FROM book WHERE id = 1);

INSERT INTO book (id, title, author, price)
SELECT 2, 'Zivotinjska farma', 'Orwell', 30
WHERE NOT EXISTS (SELECT 1 FROM book WHERE id = 2);

INSERT INTO book (id, title, author, price)
SELECT 3, 'Samom sebi', 'Marko Aurelije', 12
WHERE NOT EXISTS (SELECT 1 FROM book WHERE id = 3);

INSERT INTO pozajmica (id, datum_pozajmljivanja, member_id, book_id)
SELECT 1, '2026-11-01', 1, 1
WHERE NOT EXISTS (SELECT 1 FROM pozajmica WHERE id = 1);

INSERT INTO pozajmica (id, datum_pozajmljivanja, member_id, book_id)
SELECT 2, '2026-11-03', 2, 2
WHERE NOT EXISTS (SELECT 1 FROM pozajmica WHERE id = 2);