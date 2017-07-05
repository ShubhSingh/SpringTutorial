drop table TESTSCHEMA.offers;

 CREATE TABLE TESTSCHEMA.offers ( 
 id INTEGER NOT NULL,
 name VARCHAR(50),
 email VARCHAR(50), 
 text VARCHAR(50), 
 CONSTRAINT pkey_id PRIMARY KEY (id) );

insert into TESTSCHEMA.offers (id, name, email, text) values (1, 'Sue', 'sue.free@gmail.com', 'Coding AngularJS');
insert into TESTSCHEMA.offers (id, name, email, text) values (2, 'airtel offer', 'support@airtel.com', 'Customer Support Airtel'); 
insert into TESTSCHEMA.offers (id, name, email, text) values (3, 'bsnl offer', 'support@bsnl.com', 'Customer Support BSNL');
insert into TESTSCHEMA.offers (id, name, email, text) values (4, 'act offer', 'support@act.com', 'Customer Support ACT');
