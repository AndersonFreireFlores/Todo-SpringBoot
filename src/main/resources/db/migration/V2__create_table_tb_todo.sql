CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE table tb_todo(
    id      UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    title   VARCHAR(100) NOT NULL,
    description    VARCHAR(250) NOT NULL,
    user_id uuid,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

