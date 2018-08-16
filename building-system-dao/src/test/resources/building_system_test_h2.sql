--DROP SCHEMA IF EXISTS building_system_test;

--CREATE SCHEMA IF NOT EXISTS building_system_test
--CHARACTER SET 'utf8';

--USE building_system_test;

/*CREATE TABLE FOR spring security*/
CREATE TABLE users (
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  enabled tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE authorities (
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,  
  UNIQUE KEY uni_username_role (authority,username), 
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO  users
VALUES
	('Petrov','dfssf35',1),
	('Sidor','lkljsdf95',1),
	('Gleb','dfsdflj',1),
	('Krivor','df56kl',1);

INSERT INTO  authorities
VALUES 
	(1,'Petrov','ROLE_USER'),
	(2,'Sidor','ROLE_USER'),
	(3,'Gleb','ROLE_USER'),
	(4,'Krivor','ROLE_USER');

/*CREATE TABLE FOR users*/

CREATE TABLE users_(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,  
	login VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	surname_initials VARCHAR(150) NOT NULL,
	role ENUM('заказчик', 'гл.инженер', 'прораб', 'тех.надзор', 'гость') NOT NULL,
	del_status ENUM('активен', 'банн', 'удален') default 'активен'
);

INSERT INTO users_ (login, password, surname_initials, role, del_status) 
VALUES 
	('Petrov','dfssf35','Петров И.И.','заказчик', 'активен'),
	('Sidor','lkljsdf95','Сидоров В.К.','гл.инженер', 'активен'),
	('Gleb','dfsdflj','Глебов М.М.','прораб', 'активен'),
	('Krivor','df56kl','Криворуков И.Г.','прораб', 'активен');


/*CREATE TABLE FOR smeta*/

CREATE TABLE smeta(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,  
	pp INTEGER NOT NULL,
	obosnovanie VARCHAR(30) NOT NULL,
	naimenovanie VARCHAR(500) NOT NULL,
	ed_izm VARCHAR(30) NOT NULL,
	kol_vo DOUBLE NOT NULL
);

INSERT INTO smeta (pp, obosnovanie, naimenovanie, ed_izm, kol_vo) 
VALUES 
	(2,'Е11-2-1','УСТРОЙСТВО УПЛОТНЯЕМЫХ ТРАМБОВКАМИ ПОДСТИЛАЮЩИХ СЛОЕВ ПЕСЧАНЫХ','М3',188.8),
	(3,'Е12-2-122','УСТРОЙСТВО ЛЕНТОЧНЫХ ФУНДАМЕНТОВ ЖЕЛЕЗОБЕТОННЫХ ИЗ БЕТОНА КЛАССА С12/15','М3',444.3),
	(22,'Е11-3-1','УСТРОЙСТВО БЕТОННОЙ ПОДГОТОВКИ ИЗ БЕТОНА КЛАССА С10.12','М3',10.5);

/*CREATE TABLE FOR magazine*/

CREATE TABLE magazine(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_smeta INTEGER default NULL,
	location VARCHAR(100) default NULL,
	date_ DATE NOT NULL,
	smena ENUM('1', '2', '3') default '1',
	weather VARCHAR(100) default NULL,	
	conditions VARCHAR(100) default NULL,	
	volume DOUBLE default NULL,
	controle VARCHAR(150) default NULL,
	id_user INTEGER NOT NULL,
	
	CONSTRAINT smeta_id_fk FOREIGN KEY (id_smeta) REFERENCES smeta (id)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,

	CONSTRAINT users_id_fk FOREIGN KEY (id_user) REFERENCES users_ (id)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT		
);

INSERT INTO magazine (id_smeta, location, date_, weather, volume, controle, id_user, smena) 
VALUES 
	(2, 'в/о А-Б;1-5 на отм. +5.000','2017-03-21', 'ясно 25 С', 50, 'соответствует', 3, '1'),
	(2, 'в/о С-Д;2-3 на отм. 0.000','2017-02-21', 'дождь 5 С', 25, 'соответствует', 4, '1'),
	(3, 'в/о С-Д;6-7 на отм. +2.000','2017-01-19', 'снег -5 С', 5.5, 'соответствует', 4, '1');

/*CREATE TABLE FOR records archive*/

CREATE TABLE records_archive(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_mag INTEGER NOT NULL,
	date_ DATE NOT NULL,
	name_column ENUM('id_smeta', 'location', 'obosnovanie', 'date_', 'smena', 'weather', 'conditions', 'volume', 'controle', 'id_user') NOT NULL,
	old_record VARCHAR(500) default NULL,
	id_user INTEGER NOT NULL,
	
	CONSTRAINT magazine_id_fk FOREIGN KEY (id_mag) REFERENCES magazine (id)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,

	CONSTRAINT user_id_fk FOREIGN KEY (id_user) REFERENCES users_ (id)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT	
);

INSERT INTO records_archive (id_mag, date_, name_column, old_record, id_user) 
VALUES 
	(1, '2017-03-25','location', 'в/о С-Д;2-3 на отм. 0.000', 2),
	(2, '2017-04-05','date_', '2017-01-15', 2),
	(2, '2017-03-30','volume', '15', 2);