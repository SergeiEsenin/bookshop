create table book_authors (books_id int8 not null,
  authors varchar(255) not null);
create table book_genre (books_id int8 not null,
 genres varchar(255));
create table books (id int8 not null,
 authors_stringed varchar(255),
  filename varchar(255),
  finalpass varchar(255),
   name varchar(255),
    price float8 not null,
     primary key (id));
create table user_role (
user_id int8 not null,
 roles varchar(255));
create table usr (id int8 not null,
active boolean not null,
 email varchar(255),
 password varchar(255)
 , username varchar(255)
 , primary key (id));
create sequence hibernate_sequence start 1 increment 1;
 alter table if exists book_authors add constraint FKjecbdnbx8a1woip1ouidrd6gf foreign key (books_id) references books;
alter table if exists book_genre add constraint FKhuw18hmqbhnetftgbwdc38wio foreign key (books_id) references books;
 alter table if exists user_role add constraint FKfpm8swft53ulq2hl11yplpr5 foreign key (user_id) references usr;