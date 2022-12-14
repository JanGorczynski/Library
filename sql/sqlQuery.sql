CREATE TABLE AUTHORS(
	id int,
	full_name varchar(20),
	PRIMARY KEY (id)
);
CREATE TABLE BOOKS(
	id int NOT NULL,
	author_id int,
	currently_rented bit,
	title varchar(20),
	PRIMARY KEY (id),
	FOREIGN KEY (author_id) REFERENCES AUTHORS(id)
);
CREATE TABLE USERS(
	id int,
	username varchar(20),
	user_password varchar(20),
	PRIMARY KEY (id)
);
CREATE TABLE RENTS(
	id int,
	users_id int,
	book_id int,
	date_of_return date,
	date_of_renting date,
	PRIMARY KEY (id),
	FOREIGN KEY (book_id) REFERENCES BOOKS(id),
	FOREIGN KEY (users_id) REFERENCES USERS(id)
);