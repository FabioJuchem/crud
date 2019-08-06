create table  account(
    id serial constraint PK_ACCOUNT primary key ,
    account_number varchar(20),
    agency varchar(100),
    balance float,
    account_type varchar(50),
    costumer_id integer constraint FK_CRUD_COSTUMER references costumer(id)
)