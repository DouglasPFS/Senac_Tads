
CREATE TABLE UNIDADE (
	id_unidade integer not null primary key autoincrement,
	nome varchar(50) not null,
	endereco integer not null,
	foreign key (endereco) references ENDERECO(id_endereco)
);
CREATE TABLE PRODUTO(
	id_produto integer not null primary key autoincrement,
	nome varchar(50) not null,
	fornecedor integer not null,
	categoria integer not null,
	valor_venda double not null,
	valor_custo double not null,
	foreign key (fornecedor) references FORNECEDOR(id_fornecedor),
	foreign key (categoria) references CATEGORIA (id_categoria)
);
CREATE TABLE FUNCIONARIO(
	id_funcionario integer not null primary key autoincrement,
	nome varchar (100) not null,
	telefone
);
CREATE TABLE FORNECEDOR (
	id_fornecedor integer not null primary key autoincrement,
	nome varchar(50) not null
);
CREATE TABLE ESTOQUE(
	id_estoque integer not null primary key autoincrement,
	unidade integer not null,
	produto integer not null,
	quantidade integer not null,
	foreign key (unidade) references UNIDADE (id_unidade),
	foreign key (produto) references PRODUTO(id_produto)
);
CREATE TABLE ENDERECO(
	id_endereco integer not null primary key autoincrement,
	logradouro varchar(50)  not null,
	bairro varchar(50) not null,
	cep varchar(9) not null,
	cidade varchar(50) not null,
	estado varchar(2) not null
);
INSERT INTO `ENDERECO` (id_endereco,logradouro,bairro,cep,cidade,estado) VALUES (1,'Rua teste','Jardom Angela','12457-265','São Paulo','SP');
CREATE TABLE CLIENTE_PJ(
	id_cliente_pj integer not null primary key autoincrement,
	nome varchar(100) not null,
	telefone varchar (10) not null,
	cnpj integer not null,
	pedido integer not null,
	endereco integer not null,
	foreign key (pedido) references PEDIDO(id_pedido),
	foreign key (endereco) references ENREDECO(id_endereco)
);
CREATE TABLE CLIENTE_PF(
	id_cliente_pf integer not null primary key autoincrement,
	nome varchar(100) not null,
	telefone varchar(10) not null,
	cpf integer not null,
	pedido integer not null,
	endereco integer not null,
	foreign key (pedido) references PEDIDO(id_pedido)
	foreign key (endereco) references ENDERECO(id_endereco)
);
CREATE TABLE CATEGORIA(
	id_categoria integer not null primary key autoincrement,
	nome varchar(50) not null
);

