create table posts
(
    id          serial primary key,
    name        varchar(2000),
    description text,
    created     timestamp without time zone not null default now()
);

-- create table users
-- (
--     id       serial primary key,
--     name     varchar(64),
--     sureName varchar(64),
--     email    varchar(64)
-- );
--
-- drop table users;


CREATE TABLE authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users
(
    id           serial primary key,
    name         varchar(64) not null,
    sureName     varchar(64),
    email        varchar(128) unique,
    enabled      boolean default true,
    password     text,
    authority_id int         not null references authorities (id)
);

insert into authorities (authority)
values ('ROLE_USER');
insert into authorities (authority)
values ('ROLE_ADMIN');

insert into users (name, sureName, email, enabled, password, authority_id)
values
('Andrey', 'Polegaev', 'andrey@yandex.ru', true, '$2a$10$wY1twJhMQjGVxv4y5dBC5ucCBlzkzT4FIGa4FNB/pS9GaXC2wm9/W',
(select id from authorities where authority = 'ROLE_ADMIN'));



-- insert into users (name, sureName, email)
-- VALUES ('Andrey', 'Polegaev', 'andrey@yandex.ru'),
--        ('Nikolay', 'Matveev', 'nik@yandex.ru'),
--        ('Stanislav', 'Plotkin', 'stas@yandex.ru');


insert into posts (name)
values ('О чем этот форум?');
insert into posts (name)
values ('Правила форума.');

