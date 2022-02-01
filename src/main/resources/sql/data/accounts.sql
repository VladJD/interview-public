create table accounts (
    ID int8 NOT NULL,
    FIRST_NAME varchar(25) NOT NULL,
    LAST_NAME varchar(25) NOT NULL,
    BALANCE double precision NOT NULL,
    constraint ACCOUNTS_PKEY primary key (ID)
);