create table lancamento
(
	codigo serial
		constraint lancamento_pk
			primary key,
	descricao varchar[50] not null,
	data_vencimento date not null,
	data_pagamento date,
	valor decimal(10,2) not null,
	observacao varchar[100],
	tipo varchar[20] not null,
	codigo_categoria int not null
		constraint codigo_categoria
			references categoria (codigo),
	codigo_pessoa int not null
		constraint codigo_pessoa
			references pessoas (codigo)
);

