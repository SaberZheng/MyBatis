--自增长生成主键
DROP TABLE IF EXISTS t_role;

CREATE TABLE t_role(
	id INT(5) NOT NULL AUTO_INCREMENT COMMENT '角色id',
	role_name VARCHAR(150) COMMENT '角色姓名',
	note VARCHAR(150) COMMENT '角色备注',
	comic_id INT(5) NOT NULL COMMENT'动漫id',
	PRIMARY KEY (id),
	FOREIGN KEY(comic_id) REFERENCES t_comic(id)	
);


INSERT INTO t_role( role_name, note, comic_id) VALUES ("Saber","fate stay night",1);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("鸣人","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("佐助","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("赤丸","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("兜","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("鹿丸","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("萨博","海贼王",3);


--uuid生成主键
DROP TABLE IF EXISTS t_role;

CREATE TABLE t_role(
	id VARCHAR(36) NOT NULL COMMENT '角色id' ,
	role_name VARCHAR(150) COMMENT '角色姓名',
	note VARCHAR(150) COMMENT '角色备注',
	comic_id INT(5) NOT NULL COMMENT'动漫id',
	PRIMARY KEY (id),
	FOREIGN KEY(comic_id) REFERENCES t_comic(id)	
);



INSERT INTO t_role( role_name, note, comic_id) VALUES ("Saber","fate stay night",1);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("鸣人","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("佐助","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("赤丸","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("兜","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("鹿丸","火影忍者",2);
INSERT INTO t_role( role_name, note, comic_id) VALUES ("萨博","海贼王",3);


--comic表

DROP TABLE IF EXISTS t_comic;

CREATE TABLE t_comic(
	id INT(5) NOT NULL AUTO_INCREMENT COMMENT '动漫id',
	comic_name VARCHAR(150) COMMENT '动漫名称' ,
	remark VARCHAR(150) COMMENT '动漫备注',
	PRIMARY KEY (id)
);

INSERT  INTO  t_comic(comic_name)  VALUES ( 'fate stay night');
INSERT  INTO  t_comic(comic_name)  VALUES ( '火影忍者');
INSERT  INTO  t_comic(comic_name)  VALUES ( '海贼王');

--dubber表
DROP TABLE IF EXISTS t_dubber;

CREATE TABLE t_dubber(
	id INT(5) NOT NULL AUTO_INCREMENT COMMENT '配音演员id',
	dubber_name VARCHAR(150) COMMENT '配音演员姓名',
	role_id INT(5) NOT NULL COMMENT'角色id',
	PRIMARY KEY (id),
	FOREIGN KEY(role_id) REFERENCES t_role(id)	
);

INSERT INTO t_dubber( dubber_name, role_id) VALUES ("川澄绫子",1);
INSERT INTO t_dubber( dubber_name, role_id) VALUES ("竹内顺子",2);
INSERT INTO t_dubber( dubber_name, role_id) VALUES ("杉山纪彰",3);
INSERT INTO t_dubber( dubber_name, role_id) VALUES ("竹内顺子",4);
INSERT INTO t_dubber( dubber_name, role_id) VALUES ("神奈延年",5);
INSERT INTO t_dubber( dubber_name, role_id) VALUES ("神奈延年",6);
INSERT INTO t_dubber( dubber_name, role_id) VALUES ("竹内顺子",7);
