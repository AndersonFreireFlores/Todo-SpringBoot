CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE table tb_user (
    id  UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100) not null ,
    email varchar(100) not null
);