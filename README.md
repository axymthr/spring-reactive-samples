# Spring-reactive-samples

1. **reactor-debugging-demo** dir - sample debugging tools from the talk [Do’s and Don’ts: Avoiding First-Time Reactive Programmer Mines](https://www.youtube.com/watch?v=0rnMIueRKNU)

2. **accesing-data-r2dbc** dir - spring guide demo of r2dbc. Does not entirely run as `schema.sql` requires jdbc drivers not bundled in this starter

3. **reactive-mysql-with-jasync-and-r2dbc** dir - Mysql Jasync r2dbc from the video [Spring Tips: Reactive MySQL with Jasync SQL and R2DBC](https://www.youtube.com/watch?v=DvO4zLVDkMs) [Original code](https://github.com/joshlong/reactive-mysql-with-jasync-and-r2dbc)

   ```
   $ docker run --name=orders-mysqldb -d -p 3306:3306 -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=orders -e MYSQL_PASSWORD=orders -e MYSQL_DATABASE=orders mysql/mysql-server:5.7.24
   $ docker exec -it orders-mysqldb bash
   bash-4.2# mysql -u orders -h 127.0.0.1 -p orders
   mysql> show databases;
   +--------------------+
   | Database           |
   +--------------------+
   | information_schema |
   | orders             |
   +--------------------+
   2 rows in set (0.00 sec)
   mysql> use orders;
   mysql> create table orders (id bigint(20) AUTO_INCREMENT, fn varchar(255) NOT NULL, PRIMARY KEY (id));
   mysql> show tables;
   +------------------+
   | Tables_in_orders |
   +------------------+
   | orders           |
   +------------------+
   1 row in set (0.00 sec)
   mysql> describe orders;
   +-------+--------------+------+-----+---------+----------------+
   | Field | Type         | Null | Key | Default | Extra          |
   +-------+--------------+------+-----+---------+----------------+
   | id    | bigint(20)   | NO   | PRI | NULL    | auto_increment |
   | fn    | varchar(255) | NO   |     | NULL    |                |
   +-------+--------------+------+-----+---------+----------------+
   2 rows in set (0.00 sec)
   mysql> insert into orders values(1, "John");
   mysql> insert into orders values (2, "adam");
   ```

   Failing for now

4. **stock-service** and **stock-client** dirs - [Tutorial: Reactive Spring Boot](https://www.youtube.com/watch?v=229gPlcc5d8) Reactive Kotlin and RSocket

5. 

