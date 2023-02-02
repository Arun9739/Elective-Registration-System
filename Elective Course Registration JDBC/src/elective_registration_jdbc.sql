use elective_registration_jdbc;

create table Student(
	susn varchar(15) primary key,
	sname varchar(25) not null,
	sphone varchar(12) not null,
	sdept varchar(5) not null,
	sgender varchar(10) not null,
	spelective varchar(100) not null,
	soelective varchar(100) not null
);

drop table Student;