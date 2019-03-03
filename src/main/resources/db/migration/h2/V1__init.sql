create table solicitacao
(
  id                  bigint auto_increment not null,
  cidade              varchar(255)          not null,
  lat                 varchar(255)          not null,
  lon                 varchar(255)          not null,
  solicticacao_status integer               not null,
  primary key (id)
);

create table categoria
(
  id    bigint auto_increment not null,
  chave varchar(255)          not null,
  nome  varchar(255)          not null,
  primary key (id)
);

ALTER TABLE categoria
  ADD CONSTRAINT CHAVE_UNIQUE UNIQUE (chave);

create table music_match
(
  id           bigint auto_increment not null,
  categoria_id bigint                not null,
  temperatura  integer               not null,
  is_ativo     integer               not null,
  primary key (id)
);

alter table music_match
  add constraint FK_CATEGORIA foreign key (categoria_id) references CATEGORIA;
ALTER TABLE music_match
  ADD CONSTRAINT TEMPERATURA_UNIQUE UNIQUE (temperatura);