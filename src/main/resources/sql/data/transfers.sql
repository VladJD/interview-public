create table transfers (
    ID int8 NOT NULL,
    SOURCE_ID int8 NOT NULL,
    TARGET_ID int8 NOT NULL,
    AMOUNT double precision NOT NULL,
    TRANSFER_TIME date NOT NULL,
    constraint TRANSFERS_PKEY primary key (ID)
);