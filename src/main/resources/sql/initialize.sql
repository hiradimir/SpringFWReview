CREATE TABLE PersonalData (
  id   INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  mail VARCHAR(50),
  age  INTEGER
);

INSERT INTO PersonalData (name,mail,age) VALUES 
  ('taro', 'taro@yamada', 34),
  ('hanako', 'hanako@tashiro', 24);

