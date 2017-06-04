-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.35-community

-- Create schema apu

connect HR/hradmin;

-- Definition of table `users`


DROP TABLE IF EXISTS 'user';

CREATE TABLE "HR"."USER"
(   "USERNAME" VARCHAR2(50) NOT NULL,
    "PASSWORD" VARCHAR2(50) NOT NULL,
    "ENABLED" VARCHAR2(1) NOT NULL,
    "USER_ID" NUMBER CONSTRAINT "USER_ID_NN" NOT NULL,
    CONSTRAINT "USER_ID_PK" PRIMARY KEY ("USER_ID"));
    
-- Dumping data for table `users`


INSERT INTO 'user' ('username','password','enabled','user_id') VALUES 
 ('apurav','apurav','T',3),
 ('apurav','apurav','F',4),
 ('apurav','apurav','F',6),
 ('apurav','apurav','F',7),
 ('apurav','apurav','F',80),
 ('apurav','apurav','F',90);

