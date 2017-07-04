 
 CREATE TABLE TESTSCHEMA.RMUSER ( 
 username VARCHAR(50),
 password VARCHAR(50), 
 enabled VARCHAR(1), 
 userid INTEGER NOT NULL, 
 CONSTRAINT pkey_userid PRIMARY KEY (userid) );

insert into TESTSCHEMA.RMUSER (username,password,enabled,userid) values('shubh', '1234', 'T', 1);
insert into TESTSCHEMA.RMUSER (username,password,enabled,userid) values('vijay', '1234', 'F', 2);
insert into TESTSCHEMA.RMUSER (username,password,enabled,userid) values('ajay', '1234', 'F', 3);