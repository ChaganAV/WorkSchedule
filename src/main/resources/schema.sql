use workschedules;
create table if not exists person(
	id int primary key auto_increment not null,
    lastname varchar(30) not null,
    firstname varchar(30) not null,
    secondname varchar(30) default '',
    fio varchar(30),
    fullname varchar(50),
    tabnum varchar(20) not null
);

create table if not exists subdiv(
	id int primary key auto_increment not null,
    code varchar(20),
    name varchar(100) not null,
    description varchar(150)
);

create table if not exists tipdol(
	id int primary key auto_increment not null,
    code varchar(20) not null,
    name varchar(50) not null
);

create table if not exists post(
	id int primary key auto_increment not null,
    id_person int not null,
    id_tipdol int not null,
    id_subdiv int not null,
    date_begin date not null,
    date_end date,
    code varchar(10)
);