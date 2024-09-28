SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS employee_master;
DROP TABLE IF EXISTS department_master;




/* Create Tables */

CREATE TABLE department_master
(
	department_id char(3) NOT NULL,
	name varchar(20) NOT NULL,
	PRIMARY KEY (department_id)
);


CREATE TABLE employee_master
(
	id char(4) NOT NULL,
	name varchar(10) NOT NULL,
	enter_date date NOT NULL,
	retire_flag boolean NOT NULL,
	department_id char(3) NOT NULL,
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE employee_master
	ADD FOREIGN KEY (department_id)
	REFERENCES department_master (department_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


/* Insert employee_master Data*/
insert into employee_master values('0001','佐藤','2015/04/01',0,'100');
insert into employee_master values('0002','小林','2016/04/01',0,'200');
insert into employee_master values('0003','高橋','2018/06/01',1,'100');
insert into employee_master values('0004','吉田','2019/04/01',0,'100');
insert into employee_master values('0005','元木','2020/04/01',0,'200');

/* Insert department_master Data*/
insert into department_master values('100','技術');
insert into department_master values('200','営業');



