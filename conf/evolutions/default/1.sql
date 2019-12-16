# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tours (
  id                            bigint auto_increment not null,
  tourtype_id                   integer not null,
  constraint pk_tours primary key (id)
);

create table tour_types (
  id                            integer auto_increment not null,
  name                          varchar(255) not null,
  description                   varchar(255) not null,
  constraint pk_tour_types primary key (id)
);

create index ix_tours_tourtype_id on tours (tourtype_id);
alter table tours add constraint fk_tours_tourtype_id foreign key (tourtype_id) references tour_types (id) on delete restrict on update restrict;


# --- !Downs

alter table tours drop constraint if exists fk_tours_tourtype_id;
drop index if exists ix_tours_tourtype_id;

drop table if exists tours;

drop table if exists tour_types;

