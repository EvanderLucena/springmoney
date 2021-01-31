create table pessoas
(
	codigo serial
		constraint pessoas_pk
			primary key,
	nome varchar[30] not null,
	ativo boolean not null,
	logradouro varchar[30],
	numero varchar[6],
	complemento varchar[30],
	bairro varchar[30],
	cep varchar[30],
	cidade varchar[30],
	estado varchar[30]
);

