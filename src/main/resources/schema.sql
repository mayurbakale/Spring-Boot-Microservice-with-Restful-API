create table product
(
   productId BIGINT not null,
   name varchar(255) not null,
   description varchar(255),
   amount DECIMAL(20,2) not null,
   productType varchar(255) not null,
   primary key(productId)
);