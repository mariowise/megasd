
drop table if exists files;

drop table if exists users;

drop table if exists users_types;

create table users
(
	id 				int not null auto_increment,
	username 		varchar(40),
	password		varchar(128),
	usertype_id 	int not null,
	primary key (id)
);

create table users_types
(
	id 				int not null auto_increment,
	type_name 		varchar(40),
	primary key (id)
);

create table files
(
	id 				int not null auto_increment,
	user_id			int not null,
	path 			varchar(256),
	filename 		varchar(40),
	serverno 		int not null,
	primary key (id)
);

alter table users add constraint fk_01 foreign key (usertype_id)
	references users_types (id) on delete restrict on update restrict;

alter table files add constraint fk_02 foreign key (user_id)
	references users (id) on delete restrict on update restrict;

drop view if exists usersByType;

create view usersByType as
select users.id, users.username, users_types.type_name
from users inner join users_types on (users.usertype_id = users_types.id);