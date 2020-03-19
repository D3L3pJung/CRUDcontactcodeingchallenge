Create table contact(
id int not null auto_increment,
email varchar(100),
created_at datetime,
updated_at datetime,
uuid varchar(200),
primary key(id)
);
create table name(
id int not null auto_increment primary key,
first varchar(50),
middle varchar(50),
last varchar(50),
contact_id int,
foreign key(contact_id) references contact(id)
);

create table address(
id int not null auto_increment primary key,
street varchar(50),
city varchar(50),
state varchar(50),
zip varchar(50),
contact_id int,
foreign key(contact_id) references contact(id)
);

create table phone(
id int not null auto_increment primary key,
number varchar(50),
type varchar(50),
contact_id int,
foreign key(contact_id) references contact(id)
);