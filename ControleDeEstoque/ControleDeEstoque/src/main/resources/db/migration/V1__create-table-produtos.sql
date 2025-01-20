create table produtos(
	id bigint primary key auto_increment not null,
	nome varchar(100) not null,
	quantidade int not null,
	preco float not null,
	categoria varchar(100) not null,
	lote varchar(100) not null,
	validade varchar(100) not null,
	fornecedor varchar(100) not null,
	ativo tinyint not null default 1
);