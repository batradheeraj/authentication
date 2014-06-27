CREATE TABLE user
(id int primary key AUTO_INCREMENT,
api_key varchar(32),
email varchar(64) UNIQUE,
password varchar(32),
first_name varchar(32),
last_name varchar(32),
date_joine TIMESTAMP NOT NULL DEFAULT 0,
last_login TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
is_superus boolean,
is_active boolean);

INSERT INTO user (email,password,first_name,last_name,date_joine,last_login,is_superus,is_active)
values('codedhrj@gmail.com',MD5('codedhrj'),'Dheeraj','Batra',now(),now(),true,true);