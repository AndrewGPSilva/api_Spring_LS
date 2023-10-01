create table livros(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    autor varchar(100) not null unique,
    descricao varchar(6) not null unique,


    primary key(id)

);