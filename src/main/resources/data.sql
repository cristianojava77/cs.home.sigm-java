INSERT INTO Country (id, code, title, description)
VALUES
(1, 'BR', 'Brasil', '')
;

INSERT INTO State (id, country, code, title, description)
VALUES
(1, 1, 'SP', 'São Paulo', ''),
(2, 1, 'RJ', 'Rio de Janeiro', ''),
(3, 1, 'SC', 'Santa Catarina', ''),
;