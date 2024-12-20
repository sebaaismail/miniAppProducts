CREATE DATABASE IF NOT EXISTS miniapptest_db;
USE miniapptest_db;

DROP TABLE IF EXISTS produits;

CREATE TABLE produits (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(255) NOT NULL,
  prix FLOAT NOT NULL DEFAULT 0,
  quantite INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

INSERT INTO produits (nom, prix, quantite) VALUES
('Product A', 19.99, 100),
('Product B', 29.99, 50),
('Product C', 15.49, 200),
('Product D', 45.00, 30),
('Product E', 9.99, 150),
('Product F', 25.00, 75),
('Product G', 12.50, 120),
('Product H', 30.00, 60),
('Product I', 22.99, 90),
('Product J', 18.00, 110),
('Product K', 5.99, 200),
('Product L', 99.99, 10),
('Product M', 15.00, 80),
('Product N', 45.50, 40),
('Product O', 60.00, 20),
('Product P', 35.00, 55),
('Product Q', 12.00, 150),
('Product R', 8.50, 130),
('Product S', 20.00, 70),
('Product T', 50.00, 25),
('Product U', 14.99, 95),
('Product V', 27.50, 45),
('Product W', 33.00, 35),
('Product X', 11.00, 85),
('Product Y', 7.50, 160),
('Product Z', 17.00, 65),
('Product AA', 29.00, 55),
('Product AB', 39.99, 15),
('Product AC', 23.00, 75),
('Product AD', 10.00, 100),
('Product AE', 28.00, 50),
('Product AF', 16.00, 90),
('Product AG', 24.00, 80),
('Product AH', 13.00, 120),
('Product AI', 21.00, 60),
('Product AJ', 19.50, 110),
('Product AK', 15.75, 130),
('Product AL', 12.25, 140),
('Product AM', 18.75, 150),
('Product AN', 22.50, 70),
('Product AO', 26.00, 55),
('Product AP', 30.50, 45);