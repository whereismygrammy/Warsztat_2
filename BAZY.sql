WORKSHOP

create table user_group (id int(11) auto_increment, name varchar(255), primary key(id));


create table users (
id bigint(20) auto_increment, 
username varchar(255), 
email varchar(255), 
password varchar(245), 
user_group_id int(11), 
primary key(id), 
foreign key(user_group_id) references user_group(id));

desc users;

show tables;