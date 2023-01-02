CREATE TABLE IF NOT EXISTS playmaker.playground_user (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`first_name` varchar(50) NOT NULL,
	`last_name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);