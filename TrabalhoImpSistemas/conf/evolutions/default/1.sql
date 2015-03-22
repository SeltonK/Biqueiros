# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

