create table costumer(
    id serial constraint PK_COSTUMER primary key,
    name varchar(100),
    cpf varchar(20) unique
)