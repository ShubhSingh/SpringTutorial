 
 CREATE TABLE TESTSCHEMA.RMUSER ( 
 username VARCHAR(50),
 password VARCHAR(50), 
 enabled VARCHAR(1), 
 user_id INTEGER NOT NULL, 
 CONSTRAINT primary_key PRIMARY KEY (user_id) );

insert into TESTSCHEMA.RMUSER (username,password,enabled,user_id) values('shubh', '1234', 'T', 1);
insert into TESTSCHEMA.RMUSER (username,password,enabled,user_id) values('vijay', '1234', 'F', 2);
insert into TESTSCHEMA.RMUSER (username,password,enabled,user_id) values('ajay', '1234', 'F', 3);
