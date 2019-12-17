# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table prize (
  id                            bigint auto_increment not null,
  money                         integer not null,
  xp                            integer not null,
  type                          varchar(255) not null,
  name                          varchar(255) not null,
  value                         integer not null,
  constraint pk_prize primary key (id)
);

create table tournament (
  id                            bigint auto_increment not null,
  first_id                      bigint not null,
  second_id                     bigint not null,
  third_id                      bigint not null,
  constraint uq_tournament_first_id unique (first_id),
  constraint uq_tournament_second_id unique (second_id),
  constraint uq_tournament_third_id unique (third_id),
  constraint pk_tournament primary key (id)
);

alter table tournament add constraint fk_tournament_first_id foreign key (first_id) references prize (id) on delete restrict on update restrict;

alter table tournament add constraint fk_tournament_second_id foreign key (second_id) references prize (id) on delete restrict on update restrict;

alter table tournament add constraint fk_tournament_third_id foreign key (third_id) references prize (id) on delete restrict on update restrict;


# --- !Downs

alter table tournament drop constraint if exists fk_tournament_first_id;

alter table tournament drop constraint if exists fk_tournament_second_id;

alter table tournament drop constraint if exists fk_tournament_third_id;

drop table if exists prize;

drop table if exists tournament;

