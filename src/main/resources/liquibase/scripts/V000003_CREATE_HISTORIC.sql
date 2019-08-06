create table  historic(
    id serial constraint PK_HISTORIC primary key ,
    date timestamp,
    value float,
    operation_type varchar(50),
    account_id integer constraint FK_CRUD_ACCOUNT references account(id)
)