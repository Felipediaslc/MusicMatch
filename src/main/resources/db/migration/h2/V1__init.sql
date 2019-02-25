 create table solicitacao (
     id bigint auto_increment not null,
     cidade varchar(255) not null,
     lat varchar(255) not null,
     lon varchar(255) not null,
     solicticacao_status integer not null,
     primary key (id)
 );