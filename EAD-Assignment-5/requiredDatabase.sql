create database advertise;

use advertise;

create table category
(   id int auto_increment,
    category_name varchar(30) unique not null,
    constraint PK_id primary key(id)
);

create table advertisement
(   id int auto_increment,
    title varchar(30),
    description varchar(500),
    category_id int,
    constraint PK_id primary key(id),
    constraint FK_id_category_id foreign key(category_id) references category(id)
);
