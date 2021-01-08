-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS aaa;

CREATE TABLE aaa (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL
);

INSERT INTO aaa (email, password) VALUES
  ('mtolley@synopsys.com', 'password123'),
  ('tmangenot@synopsys.com', 'password123');