create database todo_db;

create user 'todo_user'@'localhost' identified by 'Todo@123';
grant all privileges on todo_db.* to 'todo_user'@'localhost';
flush privileges;