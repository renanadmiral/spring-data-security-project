# spring-data-security-project
This project was made for Let's Code programming school. It was made a REST API with Spring Data JPA for data persistence and Spring Security for authentication.

ROUTES (only using basic authentication):

GET /product -> Return a list of products avaiable.

POST /product -> Register a new product (check ProductDTO to make the request object.)

GET /purchase -> Return a list of purchases made.

POST /purchase -> Make a new purchase (check RequestPurchaseDTO to make the request object.)

DDL -

CREATE TABLE customer (
    id serial PRIMARY KEY,
    birth_date date NOT NULL,
    "name" varchar(255) NOT NULL,
    registration_number char(11) UNIQUE NOT NULL CHECK(length(registration_number) = 11)
);

CREATE TABLE purchase (
    id serial PRIMARY KEY,
    purchase_date timestamp NOT NULL,
    value float NOT NULL check(value > 0),
    id_customer int references customer(id)
);

CREATE TABLE product (
    id serial PRIMARY KEY,
    code_number varchar(13) UNIQUE NOT NULL CHECK(length(code_number) = 13),
    price float NOT NULL CHECK(price > (0)::double precision),
    quantity int NOT null CHECK(quantity >= 0)
);

create TABLE purchase_product (
    id_purchase int references purchase(id),
    id_product int references product(id),
    ammount_sold int not null check(ammount_sold > 0),
    primary key(id_purchase, id_product)
);

create table users(
	username varchar(50) not null primary key,
	password varchar(500) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

----------DML:

insert into users values ('renan', '$2a$12$ql6WcMNO8Utv6mJZK2aHq.0hIeYoBrDgw794NGaQuU2bFW3Bzb1uO', true);

insert into authorities values('renan', 'ADMIN');
