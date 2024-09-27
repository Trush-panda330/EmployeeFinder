SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS employee_master;
DROP TABLE IF EXISTS DepartmentMaster;




/* Create Tables */

CREATE TABLE DepartmentMaster
(
	department_id char(3) NOT NULL,
	department_name varchar(20) NOT NULL,
	id char(4) NOT NULL,
	PRIMARY KEY (department_id)
);


CREATE TABLE employee_master
(
	id char(4) NOT NULL,
	name varchar(10) NOT NULL,
	enter_date date NOT NULL,
	retire_flag blob NOT NULL,
	department_id char(3) NOT NULL,
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE employee_master
	ADD FOREIGN KEY (department_id)
	REFERENCES DepartmentMaster (department_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



