--Tabela Cliente
CREATE TABLE Cliente(
	id_cli serial,
	nome_cli VARCHAR(50),
	cidade_cli VARCHAR(30),
	tel_cli VARCHAR(14),
	email_cli VARCHAR(40),
	CONSTRAINT pk_id_cli PRIMARY KEY (id_cli)
);
--Tabela Proprierade
CREATE TABLE Propriedade(
	id_prop serial,
	nome_prop VARCHAR(50),
	estado_prop VARCHAR(3),
	cidade_prop VARCHAR(30),
	rua_prop VARCHAR(30),
	num_prop int,
	data_prop VARCHAR(10),
	valor_prop FLOAT,
	situacao_prop VARCHAR(10),
	proprietario_prop VARCHAR(50),
	complemento_prop VARCHAR(500),
	matricula_prop VARCHAR(50),
	coordenada_prop VARCHAR(25),
	fonte_prop VARCHAR(30),
	benfeitoria_prop VARCHAR(1500),
	area_prop int,
	area_reserva_prop int,
	tipo_prop VARCHAR(10),
	atividade_prop VARCHAR(50),
	pasta_prop VARCHAR(500),
	unidade_prop VARCHAR(15),
	CONSTRAINT pk_id_prop PRIMARY KEY (id_prop)
);

--Tabela Corretor
CREATE TABLE Corretor(
	id_cor serial,
	nome_cor VARCHAR(50),
	tel_cor VARCHAR(14),
	cidade_cor VARCHAR(50),
	cresci_cor VARCHAR(10),
	email_cor VARCHAR(40),
	CONSTRAINT pk_id_cor PRIMARY KEY (id_cor)
);

--Tabela Administrador
CREATE TABLE Administrador(
	id_adm serial,
	nome_adm VARCHAR(50),
	tel_adm VARCHAR(14),
	email_adm VARCHAR(40),
	senha_adm VARCHAR(20),
	CONSTRAINT pk_id_adm PRIMARY KEY (id_adm)
);

--Tabela Negocio com Chaves Estrangeiras
CREATE TABLE Negocio (
	id_neg serial,
	modo_neg VARCHAR(30),
	data_neg VARCHAR(10),
	situacao_neg VARCHAR(30),
	id_cli_neg int,
	id_prop_neg int,
	id_cor_neg int,
	CONSTRAINT pk_id_neg PRIMARY KEY (id_neg),
	CONSTRAINT fk_id_cli_neg FOREIGN KEY (id_cli_neg) REFERENCES Cliente(id_cli),
	CONSTRAINT fk_id_prop_neg FOREIGN KEY (id_prop_neg) REFERENCES Propriedade(id_prop)
);

--tabela N*N - Negocio_CLiente
create table Negocio_Cliente(
	id_neg int,
	id_cli int,
	constraint pk_id_neg_cli PRIMARY KEY (id_neg, id_cli),
	CONSTRAINT fk_id_neg_cli_cli FOREIGN KEY (id_cli) REFERENCES Cliente(id_cli),
	CONSTRAINT fk_id_neg_cli_neg FOREIGN KEY (id_neg) REFERENCES Negocio(id_neg)
);

--tabela N*N - Negocio_Propriedade
create table Negocio_Propriedade(
	id_neg int,
	id_prop int,
	constraint pk_id_neg_prop PRIMARY KEY (id_neg, id_prop),
	CONSTRAINT fk_id_neg_prop_prop FOREIGN KEY (id_prop) REFERENCES Propriedade(id_prop),
	CONSTRAINT fk_id_neg_prop_neg FOREIGN KEY (id_neg) REFERENCES Negocio(id_neg)
);

--tabela N*N - Negocio_Corretor
create table Negocio_Corretor(
	id_neg int,
	id_cor int,
	constraint pk_id_neg_cor PRIMARY KEY (id_neg, id_cor),
	CONSTRAINT fk_id_neg_cor_cor FOREIGN KEY (id_cor) REFERENCES Corretor(id_cor),
	CONSTRAINT fk_id_neg_cor_neg FOREIGN KEY (id_neg) REFERENCES Negocio(id_neg)
);



---Valores da inicialmente Inseridos
insert into Administrador(nome_adm, tel_adm, email_adm, senha_adm) values('Luiz Carlos','(17)99771-3825', 'luiz.carlos_oliver@hotmail.com', '123456' );

insert into Propriedade(nome_prop, estado_prop, cidade_prop, valor_prop, situacao_prop, proprietario_prop, complemento_prop, matricula_prop, coordenada_prop,
fonte_prop, benfeitoria_prop, area_prop, area_reserva_prop, tipo_prop, atividade_prop) 
values('TRES IRMAOS','SP', 'NOVA LUZITANIA', '200.000', 'v', 'Mauricio', 'nda', '17504', '-20.857650, -50.264599', 
'Familia', 'Sede, Curral,', '40','0','RURAL', 'Pasto' );


--Selects

select * from Cliente;
select * from Propriedade;
select * from Corretor;
select * from Administrador;
select * from Negocio;
select * from Negocio_Cliente;
select * from Negocio_Propriedade;
select * from Negocio_Corretor;
--Drop
drop table Negocio_Cliente;
drop table Negocio_Propriedade;
drop table Negocio_Corretor;
drop table Negocio;
drop table propriedade;

delete from Negocio_Cliente where  id_neg= 5;	

