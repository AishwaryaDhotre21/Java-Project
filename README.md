# Java-Project
## Pharmacy Management System
### Mysql database is used here for backend
### Java swing compements are used in the frontend
### Database structure
mysql> show tables;
+---------------------------------------------------+
| Tables_in_mini_project_pharmacy_management_system |
+---------------------------------------------------+
| bill                                              |
| customer                                          |
| customer_request                                  |
| error                                             |
| login                                             |
| medicines                                         |
| stock                                             |
| stock_request                                     |
| store_response                                    |
| supplier                                          |
| supplier_response                                 |
+---------------------------------------------------+
11 rows in set (0.40 sec)

mysql> desc bill;
+-------------+-------------+------+-----+---------+----------------+
| Field       | Type        | Null | Key | Default | Extra          |
+-------------+-------------+------+-----+---------+----------------+
| Bill_Id     | int(10)     | NO   | PRI | NULL    | auto_increment |
| Bill_Date   | date        | YES  |     | NULL    |                |
| Cust_Name   | varchar(50) | YES  |     | NULL    |                |
| Final_Price | int(10)     | YES  |     | NULL    |                |
+-------------+-------------+------+-----+---------+----------------+
4 rows in set (0.18 sec)

mysql> desc customer;
+---------------+-------------+------+-----+---------+-------+
| Field         | Type        | Null | Key | Default | Extra |
+---------------+-------------+------+-----+---------+-------+
| Cust_Name     | varchar(50) | YES  |     | NULL    |       |
| Phone_no      | int(10)     | YES  |     | NULL    |       |
| Address       | varchar(50) | YES  |     | NULL    |       |
| Med_Name      | varchar(50) | YES  | MUL | NULL    |       |
| Med_Quantity  | int(10)     | YES  |     | NULL    |       |
| Med_Price     | int(10)     | YES  |     | NULL    |       |
| Purchase_Date | date        | YES  |     | NULL    |       |
| Total_Price   | int(10)     | YES  |     | NULL    |       |
+---------------+-------------+------+-----+---------+-------+
8 rows in set (0.01 sec)

mysql> desc customer_request;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| med_name   | varchar(50) | NO   |     | NULL    |       |
| req_date   | date        | YES  |     | NULL    |       |
| req_status | varchar(50) | NO   |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
3 rows in set (0.08 sec)

mysql> show tables;
+---------------------------------------------------+
| Tables_in_mini_project_pharmacy_management_system |
+---------------------------------------------------+
| bill                                              |
| customer                                          |
| customer_request                                  |
| error                                             |
| login                                             |
| medicines                                         |
| stock                                             |
| stock_request                                     |
| store_response                                    |
| supplier                                          |
| supplier_response                                 |
+---------------------------------------------------+
11 rows in set (0.00 sec)

mysql> desc error;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| msg   | varchar(20) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
1 row in set (0.03 sec)

mysql> desc login;
+----------------+-------------+------+-----+---------+-------+
| Field          | Type        | Null | Key | Default | Extra |
+----------------+-------------+------+-----+---------+-------+
| Login_Id       | varchar(10) | NO   | PRI | NULL    |       |
| Login_Name     | varchar(10) | YES  |     | NULL    |       |
| Login_Password | varchar(30) | YES  |     | NULL    |       |
+----------------+-------------+------+-----+---------+-------+
3 rows in set (0.01 sec)

mysql> desc medicines;
+-----------------+-------------+------+-----+---------+-------+
| Field           | Type        | Null | Key | Default | Extra |
+-----------------+-------------+------+-----+---------+-------+
| Med_Name        | varchar(50) | NO   | PRI | NULL    |       |
| med_Expiry_Date | date        | YES  |     | NULL    |       |
| Med_Price       | int(30)     | YES  |     | NULL    |       |
+-----------------+-------------+------+-----+---------+-------+
3 rows in set (0.01 sec)

mysql> show tables;
+---------------------------------------------------+
| Tables_in_mini_project_pharmacy_management_system |
+---------------------------------------------------+
| bill                                              |
| customer                                          |
| customer_request                                  |
| error                                             |
| login                                             |
| medicines                                         |
| stock                                             |
| stock_request                                     |
| store_response                                    |
| supplier                                          |
| supplier_response                                 |
+---------------------------------------------------+
11 rows in set (0.00 sec)

mysql> desc stock;
+------------------+-------------+------+-----+---------+-------+
| Field            | Type        | Null | Key | Default | Extra |
+------------------+-------------+------+-----+---------+-------+
| Med_Name         | varchar(80) | NO   | PRI | NULL    |       |
| Med_Company      | varchar(80) | YES  |     | NULL    |       |
| Quantity         | int(20)     | YES  |     | NULL    |       |
| Exp_Date         | date        | YES  |     | NULL    |       |
| Med_Sell_Price   | int(50)     | YES  |     | NULL    |       |
| Med_Cost_Price   | int(50)     | YES  |     | NULL    |       |
| Total_Sell_Price | int(50)     | YES  |     | NULL    |       |
| Total_Cost_Price | int(5)      | YES  |     | NULL    |       |
+------------------+-------------+------+-----+---------+-------+
8 rows in set (0.01 sec)

mysql> desc stock_request;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| med_name   | varchar(50) | YES  |     | NULL    |       |
| quantity   | int(10)     | YES  |     | NULL    |       |
| req_date   | datetime    | YES  |     | NULL    |       |
| req_status | varchar(50) | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
4 rows in set (0.11 sec)

mysql> desc store_response;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| med_name     | varchar(50) | YES  |     | NULL    |       |
| req_date     | date        | YES  |     | NULL    |       |
| fulfill_date | date        | YES  |     | NULL    |       |
| req_status   | varchar(50) | YES  |     | NULL    |       |
| date_diff    | int(10)     | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
5 rows in set (0.12 sec)

mysql> show tables;
+---------------------------------------------------+
| Tables_in_mini_project_pharmacy_management_system |
+---------------------------------------------------+
| bill                                              |
| customer                                          |
| customer_request                                  |
| error                                             |
| login                                             |
| medicines                                         |
| stock                                             |
| stock_request                                     |
| store_response                                    |
| supplier                                          |
| supplier_response                                 |
+---------------------------------------------------+
11 rows in set (0.00 sec)

mysql> desc supplier;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| Company_Name | varchar(80) | YES  |     | NULL    |       |
| Med_Name     | varchar(50) | NO   | PRI | NULL    |       |
| Address      | varchar(80) | YES  |     | NULL    |       |
| Quantity     | int(100)    | YES  |     | NULL    |       |
| Phone_no     | int(10)     | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
5 rows in set (0.07 sec)

mysql> desc supplier_response;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| med_name    | varchar(50) | YES  |     | NULL    |       |
| quantity    | int(11)     | YES  |     | NULL    |       |
| req_date    | datetime    | YES  |     | NULL    |       |
| fulfil_date | datetime    | YES  |     | NULL    |       |
| date_diff   | int(11)     | YES  |     | NULL    |       |
| req_status  | varchar(20) | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
6 rows in set (0.29 sec)

mysql> show triggers;
+----------------------+--------+-------------------+-----------------------------------------------------------------------------------------------------------------------------+--------+---------+----------------------------------------------------------------+----------------+----------------------+----------------------+--------------------+
| Trigger              | Event  | Table             | Statement                                                                                                                   | Timing | Created | sql_mode                                                       | Definer        | character_set_client | collation_connection | Database Collation |
+----------------------+--------+-------------------+-----------------------------------------------------------------------------------------------------------------------------+--------+---------+----------------------------------------------------------------+----------------+----------------------+----------------------+--------------------+
| trig_delete          | DELETE | customer_request  | insert into store_response values(old.med_name,old.req_date,curdate(),"Available",datediff(curdate(),old.req_date))         | BEFORE | NULL    | STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION | root@localhost | latin1               | latin1_swedish_ci    | latin1_swedish_ci  |
| trig_delete1         | DELETE | stock_request     | insert into supplier_response values(old.med_name,old.quantity,old.req_date,now(),datediff(now(),old.req_date),'Available') | BEFORE | NULL    | STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION | root@localhost | latin1               | latin1_swedish_ci    | latin1_swedish_ci  |
| trig_insert_supplier | INSERT | supplier_response | begin
     insert into supplier(Med_Name,Quantity) values (new.med_name,new.quantity);
     end                             | AFTER  | NULL    | STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION | root@localhost | latin1               | latin1_swedish_ci    | latin1_swedish_ci  |
+----------------------+--------+-------------------+-----------------------------------------------------------------------------------------------------------------------------+--------+---------+----------------------------------------------------------------+----------------+----------------------+----------------------+--------------------+
3 rows in set (0.05 sec)

mysql
