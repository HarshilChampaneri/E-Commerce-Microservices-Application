-- Category Table
create table if not exists categories
(
    id bigint not null primary key generated always as identity,
    description varchar(255),
    name varchar(255) unique not null
);

-- Products Table
create table if not exists products
(
    id bigint not null primary key generated always as identity,
    description varchar(255) not null,
    name varchar(255) not null,
    available_quantity double precision,
    price numeric(38, 2),
    category_id bigint
    constraint category_fk references categories(id)
);