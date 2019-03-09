--自增长生成主键
DROP TABLE IF EXISTS t_role;

CREATE TABLE t_role(
	id INT(5) NOT NULL AUTO_INCREMENT,
	role_name VARCHAR(150),
	note VARCHAR(150),
	PRIMARY KEY (id)
);


INSERT INTO t_role( role_name, note) VALUES ("Saber","fate stay night");
INSERT INTO t_role( role_name, note) VALUES ("鸣人","火影忍者");
INSERT INTO t_role( role_name, note) VALUES ("佐助","火影忍者");

--uuid生成主键
DROP TABLE IF EXISTS t_role;

CREATE TABLE t_role(
	id VARCHAR(36) NOT NULL ,
	role_name VARCHAR(150),
	note VARCHAR(150),
	PRIMARY KEY (id)
);

INSERT INTO t_role( id,role_name, note) VALUES (UUID(),"Saber","fate stay night");
INSERT INTO t_role( id,role_name, note) VALUES (UUID(),"鸣人","火影忍者");
INSERT INTO t_role( id,role_name, note) VALUES (UUID(),"佐助","火影忍者");

