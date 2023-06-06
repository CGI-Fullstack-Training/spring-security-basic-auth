# springSecurity_basic_auth
Basic auth spring security

Needs to add spring security dependency. 
while hitting the url without password we will get 401 unauthorized. 
needs to specify username and password.
user name by default "user", 
password is generated in spring sts console use basic auth in postman

************************SQL*************
CREATE TABLE
 `users` ( `username` varchar(50) NOT NULL, `password` varchar(50) NOT NULL, `enabled` tinyint NOT NULL, PRIMARY KEY (`username`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 INSERT INTO `users` VALUES ('john','{noop}test123',1), ('mary','{noop}test123',1), ('susan','{noop}test123',1);
 
 CREATE TABLE `authorities` ( `username` varchar(50) NOT NULL, `authority` varchar(50) NOT NULL, UNIQUE KEY `authorities_idx_1` (`username`,`authority`), CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 


INSERT INTO `authorities` VALUES ('john','ROLE_EMPLOYEE'), ('mary','ROLE_EMPLOYEE'), ('mary','ROLE_MANAGER'), ('susan','ROLE_EMPLOYEE'), ('susan','ROLE_MANAGER'), ('susan','ROLE_ADMIN');