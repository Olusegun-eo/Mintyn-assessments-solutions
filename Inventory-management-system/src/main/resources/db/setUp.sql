create database minty_db;

create user 'minty_user'@'localhost' identified by 'Minty@123';
grant all privileges on minty_db.* to 'minty_user'@'localhost';
flush privileges;