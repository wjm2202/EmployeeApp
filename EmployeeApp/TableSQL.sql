create table APP.EMPLOYEE
(empID INT not Null Generated ALWAYS AS IDENTITY, 
name varchar(26),
address varchar(100),
city varchar(30),
phone varchar(20),
cell varchar(20),
email varchar(30),
D_O_B DATE,
age int,
marital varchar(10),
gender varchar(10),
dep varchar(20));

create table APP.CERT
(certID INT not Null Generated ALWAYS AS IDENTITY,
empID int,
certNum varchar(30),
certProv varchar(50),
certType varchar(20),
certDesc varchar(20),
certStart DATE,
certExpire DATE,
rebook DATE);