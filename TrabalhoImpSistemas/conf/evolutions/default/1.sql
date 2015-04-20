# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table projeto (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  descricao                 varchar(255),
  tipo                      varchar(255),
  user_id                   bigint,
  constraint pk_projeto primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  sobre_nome                varchar(255),
  login                     varchar(255),
  senha                     varchar(255),
  email                     varchar(255),
  data_nascimento           datetime,
  cpf                       varchar(255),
  constraint pk_user primary key (id))
;

alter table projeto add constraint fk_projeto_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_projeto_user_1 on projeto (user_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table projeto;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

