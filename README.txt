Step 1: Start a MySql server in a container as
docker run -p 3306:3306 --name db -e MYSQL_ROOT_PASSWORD=Welcome1 -d mysql:latest
[Having the name as db is required for the phpmyadmin to work]

Step 2: Start a php-admin in a container
docker run -p 8085:80 -d --link db:mysql phpmyadmin/phpmyadmin

Step 3: Create the DB and user required for the rest application
mysql> create database testdb;  -- Create the new database
mysql> create user 'springuser'@'%' identified by 'Welcome1'; -- Creates the user
mysql> grant all on testdb.* to 'springuser'@'%'; -- Gives all the privileges to the new user on the newly created database

Step 4: Create the docker image of the rest app
docker build -t myrestapp .

Step 5: Run the rest app in a container
docker run -p 8080:8080 -d --link db:mysql myrestapp

