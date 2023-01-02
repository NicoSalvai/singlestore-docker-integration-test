CREATE TABLE playground_user (
	id int8 NOT NULL GENERATED ALWAYS AS IDENTITY,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	email varchar NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);
