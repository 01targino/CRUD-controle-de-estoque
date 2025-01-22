create table usuarios(
	id bigint primary key auto_increment not null,
	login varchar(100) not null,
	senha varchar(50) not null
);