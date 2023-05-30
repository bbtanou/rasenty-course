create user if not exists biblio identified by 'biblio123';
create database if not exists library default character set utf8;
grant all privileges on library.* to biblio;


create table if not exists category(
    id bigInt primary key autoincrement,
    nom varchar(50) not null
);

create table if not exists author(
    id bigInt primary key autoincrement,
    name varchar(50) not null,
    email varchar(50),
    telephone varchar(9) not null,
    publishingHouse varchar(50) not null
);

create table if not exists user(
    id bigInt primary key autoincrement,
    name varchar(50) not null,
    email varchar(50),
    telephone varchar(9) not null,
    username varchar(50) not null,
    password varchar(255) not null,
    status varchar(10) not null
);

create table if not exists reader(
    id bigInt primary key autoincrement,
    name varchar(50) not null,
    email varchar(50),
    telephone varchar(9) not null
);

create table if not exists subscription_type(
    id bigInt primary key autoincrement,
    name varchar(50) not null,
    amount decimal not null
);

create table if not exists book(
    id bigInt primary key autoincrement,
    title varchar(255) not null,
    publicationDate date not null,
    isbn varchar(50) not null,
    description text not null,
    status varchar(20) not null,
    quantity int not null,
    category_id bigInt not null,
        foreign key (category_id) references category(id)
);

create table if not exists subscription (
    id bigInt primary key autoincrement,
    subscription_date date not null,
    expiration_date date not null,
    status varchar(20) not null,
    subscription_type_id bigInt not null,
        foreign key (subscription_type_id) references subscription_type(id),
    reader_id bigInt not null,
        foreign key (reader_id) references reader(id),
    user_id bigInt not null,
        foreign key (user_id) references user(id)
)

create table if not exists loan(
    id bigInt primary key autoincrement,
    loaned_at date not null,
    return_date date not null,
    returned_date date not null,
    status varchar(20) not null,
    book_id bigInt not null,
        foreign key (book_id) references book(id),
    subscription_id bigInt not null,
    foreign key (subscription_id) references subscription(id),
    user_id bigInt not null,
        foreign key (user_id) references user(id),
)


