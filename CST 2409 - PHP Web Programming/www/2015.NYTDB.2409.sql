Create Database Exam1;
Use Exam1;

CREATE TABLE Department
(
	id int not null,  
	departmentName VARCHAR(25),
	CONSTRAINT pkDeptId PRIMARY KEY (id)
);

create Table EmployeeTitle(
	 id int not null, 
	 description VARCHAR(25),
	 salaryRange1  decimal(10,2),
	 salaryRange2  decimal(10,2),
	 CONSTRAINT pkEmployeeTitle PRIMARY KEY (id)
);

CREATE TABLE MarginalTax
(
	 code varchar(05) not null,
	 percentage decimal(5,2),
	 maritalStatusCode varchar(3),
	 maritalStatusDescription varchar(55),	 	
	 startSalary decimal(10,2),
	 endSalary decimal(10,2),	 
	 CONSTRAINT pkMarginalTax PRIMARY KEY (code)	 	 
);

CREATE TABLE Employee
(
	 id int not null, 
	 firstName VARCHAR(25),
	 lastName VARCHAR(25),
	 gender varchar(1),
	 titleId int not null,
	 salary decimal(10,2),
	 departmentID int not null,
	 taxCode varchar(05) not null,
	 CONSTRAINT pkEmployeeId PRIMARY KEY (id),
	 FOREIGN KEY (departmentID) REFERENCES Department(id),
	 FOREIGN KEY (titleId) REFERENCES EmployeeTitle(id),
	 FOREIGN KEY (taxCode) REFERENCES MarginalTax(code)
);


CREATE TABLE ManagerAndEmployee
(
	 id int not null, 
	 managerId int, 
	 employeeId int,
	 CONSTRAINT pkMgrNEmp PRIMARY KEY (id),
	 FOREIGN KEY (managerId) REFERENCES Employee(id),
	 FOREIGN KEY (employeeId) REFERENCES Employee(id)
);

Create table Rating(
	id int not null,
	description varchar(25) not null,
	percentage decimal(4,2) not null,
	CONSTRAINT pkRatingId PRIMARY KEY (id)
);

create table Quarters(
	id int not null,
	code varchar(2) not null,
	yearNumber int not null,
	description varchar(25) not null,	
	CONSTRAINT pkQuarters PRIMARY KEY (id)
);

Create table EmployeeRating(
	id int not null,
	employeeId int not null,
	ratingId int not null,
	quarterId int not null,
	CONSTRAINT pkEmployeeRating PRIMARY KEY (id),
	FOREIGN KEY (quarterId) REFERENCES Quarters(id),
	FOREIGN KEY (ratingId) REFERENCES Rating(id),
	FOREIGN KEY (employeeId) REFERENCES Employee(id)
);

INSERT INTO Rating  values (1001,'Excellent',0.08);
INSERT INTO Rating  values (1002,'Very Good',0.05);
INSERT INTO Rating  values (1003,'Average',0.03);
INSERT INTO Rating  values (1004,'Border Line',0.01);
INSERT INTO Rating  values (1005,'Poor',0);

INSERT INTO Department  values (2001,'Legal IT');
INSERT INTO Department  values (2002,'HR IT');
INSERT INTO Department  values (2003,'Tax IT');
INSERT INTO Department  values (2004,'Finance IT');
INSERT INTO Department  values (2005,'Mortgage IT');

INSERT INTO Quarters  values (4001,'q1',2014,'Quarter 1');
INSERT INTO Quarters  values (4002,'q2',2014,'Quarter 2');
INSERT INTO Quarters  values (4003,'q3',2014,'Quarter 3');
INSERT INTO Quarters  values (4004,'q4',2014,'Quarter 4');



INSERT INTO EmployeeTitle  values (3001,'Programmer I',50000,70000);
INSERT INTO EmployeeTitle  values (3002,'Programmer II',70000,90000);
INSERT INTO EmployeeTitle  values (3003,'Programmer III',90000,110000);
INSERT INTO EmployeeTitle  values (3004,'Programmer IV',110000,130000);
INSERT INTO EmployeeTitle  values (3005,'Manager',150000,200000);


INSERT INTO MarginalTax  values ('T01',0.1,'S','Single',0,8925);
INSERT INTO MarginalTax  values ('T02',0.15,'S','Single',8926,36250);
INSERT INTO MarginalTax  values ('T03',0.25,'S','Single',36251,87850);
INSERT INTO MarginalTax  values ('T04',0.28,'S','Single',87851,183250);
INSERT INTO MarginalTax  values ('T05',0.33,'S','Single',183251,398350);
INSERT INTO MarginalTax  values ('T06',0.35,'S','Single',398351,400000);
INSERT INTO MarginalTax  values ('T07',0.4,'S','Single',400001,99999999);
INSERT INTO MarginalTax  values ('T08',0.1,'MFJ','Married Filing Jointly or Qualified Widower ',0,17850);
INSERT INTO MarginalTax  values ('T09',0.15,'MFJ','Married Filing Jointly or Qualified Widower ',17851,72500);
INSERT INTO MarginalTax  values ('T10',0.25,'MFJ','Married Filing Jointly or Qualified Widower ',72501,146400);
INSERT INTO MarginalTax  values ('T11',0.28,'MFJ','Married Filing Jointly or Qualified Widower ',146401,223050);
INSERT INTO MarginalTax  values ('T12',0.33,'MFJ','Married Filing Jointly or Qualified Widower ',223051,398350);
INSERT INTO MarginalTax  values ('T13',0.35,'MFJ','Married Filing Jointly or Qualified Widower ',398351,450000);
INSERT INTO MarginalTax  values ('T14',0.4,'MFJ','Married Filing Jointly or Qualified Widower ',450001,99999999);
INSERT INTO MarginalTax  values ('T15',0.1,'MFS','Married Filing Separately ',0,8925);
INSERT INTO MarginalTax  values ('T16',0.15,'MFS','Married Filing Separately ',8926,36250);
INSERT INTO MarginalTax  values ('T17',0.25,'MFS','Married Filing Separately ',36251,73200);
INSERT INTO MarginalTax  values ('T18',0.28,'MFS','Married Filing Separately ',73201,111525);
INSERT INTO MarginalTax  values ('T19',0.33,'MFS','Married Filing Separately ',111526,199175);
INSERT INTO MarginalTax  values ('T20',0.35,'MFS','Married Filing Separately ',199176,225000);
INSERT INTO MarginalTax  values ('T21',0.4,'MFS','Married Filing Separately ',225001,99999999);
INSERT INTO MarginalTax  values ('T22',0.1,'HH','Head of Household',0,12750);
INSERT INTO MarginalTax  values ('T23',0.15,'HH','Head of Household',12751,48600);
INSERT INTO MarginalTax  values ('T24',0.25,'HH','Head of Household',48601,125450);
INSERT INTO MarginalTax  values ('T25',0.28,'HH','Head of Household',125451,203150);
INSERT INTO MarginalTax  values ('T26',0.33,'HH','Head of Household',203151,398350);
INSERT INTO MarginalTax  values ('T27',0.35,'HH','Head of Household',398351,425000);
INSERT INTO MarginalTax  values ('T28',0.4,'HH','Head of Household',425001,99999999);




INSERT INTO Employee  values (150,'Jean','Boulet','M',3005,450000,2001,'T07');
INSERT INTO Employee  values (7,'Carrie','Padilla','F',3001,63184,2004,'T03');
INSERT INTO Employee  values (13,'Margie','Logan','F',3001,61188,2004,'T03');
INSERT INTO Employee  values (39,'Regina','Larson','F',3005,176455,2005,'T04');
INSERT INTO Employee  values (16,'Debbie','Malone','F',3001,55942,2004,'T03');
INSERT INTO Employee  values (24,'Christy','Hamilton','F',3004,119379,2005,'T04');
INSERT INTO Employee  values (25,'Wanda','Dunn','F',3004,120963,2005,'T04');
INSERT INTO Employee  values (23,'Lillian','Griffith','F',3001,56003,2004,'T03');
INSERT INTO Employee  values (8,'Tina','Vargas','F',3002,78765,2001,'T03');
INSERT INTO Employee  values (9,'Amber','Christensen','F',3004,127776,2001,'T04');
INSERT INTO Employee  values (96,'Stanley','Mcguire','M',3005,167519,2002,'T04');
INSERT INTO Employee  values (11,'Ana','Cobb','F',3004,126645,2001,'T04');
INSERT INTO Employee  values (26,'Sophia','Garner','F',3001,59066,2004,'T09');
INSERT INTO Employee  values (31,'Velma','Wagner','F',3001,56907,2004,'T09');
INSERT INTO Employee  values (14,'Latoya','Fletcher','F',3003,98548,2001,'T10');
INSERT INTO Employee  values (44,'Barbara','Briggs','F',3004,126699,2002,'T10');
INSERT INTO Employee  values (52,'Randall','Burke','M',3001,67742,2004,'T09');
INSERT INTO Employee  values (17,'Tonya','Clarke','F',3001,58654,2001,'T09');
INSERT INTO Employee  values (68,'Arthur','Copeland','M',3001,60038,2004,'T09');
INSERT INTO Employee  values (19,'Victoria','Morton','F',3004,112746,2001,'T10');
INSERT INTO Employee  values (20,'Virginia','Rhodes','F',3005,185630,2003,'T11');
INSERT INTO Employee  values (79,'Patrick','Parks','M',3001,61547,2004,'T09');
INSERT INTO Employee  values (22,'Janice','Weaver','F',3002,86737,2001,'T10');
INSERT INTO Employee  values (82,'Jeremy','Dean','M',3001,53298,2004,'T09');
INSERT INTO Employee  values (30,'Krystal','Yates','F',3004,111280,2005,'T10');
INSERT INTO Employee  values (64,'Guy','Ray','M',3004,127763,2005,'T10');
INSERT INTO Employee  values (83,'Allan','Woods','M',3001,54677,2004,'T09');
INSERT INTO Employee  values (27,'Erma','Moore','F',3001,58494,2001,'T09');
INSERT INTO Employee  values (28,'Charlene','Reynolds','F',3004,129628,2001,'T10');
INSERT INTO Employee  values (87,'John','Hodges','M',3001,57272,2004,'T09');
INSERT INTO Employee  values (81,'Neil','Carroll','M',3004,111509,2005,'T10');
INSERT INTO Employee  values (95,'Gerard','Wise','M',3001,60142,2004,'T09');
INSERT INTO Employee  values (38,'Lucia','Bush','F',3003,99466,2005,'T10');
INSERT INTO Employee  values (1,'Sadie','Medina','F',3002,79705,2004,'T10');
INSERT INTO Employee  values (50,'Rosemary','Romero','F',3004,111128,2002,'T10');
INSERT INTO Employee  values (35,'Esther','Bass','F',3004,124147,2001,'T19');
INSERT INTO Employee  values (36,'Molly','Webb','F',3001,67541,2001,'T17');
INSERT INTO Employee  values (40,'Doreen','Steele','F',3002,72835,2004,'T17');
INSERT INTO Employee  values (49,'Marion','Pittman','F',3003,97853,2005,'T18');
INSERT INTO Employee  values (71,'Jody','Webster','M',3003,104476,2005,'T18');
INSERT INTO Employee  values (41,'Julie','Snyder','F',3002,80709,2004,'T18');
INSERT INTO Employee  values (53,'Boyd','Webb','M',3002,77787,2004,'T18');
INSERT INTO Employee  values (42,'Tammy','Clark','F',3005,164570,2001,'T19');
INSERT INTO Employee  values (56,'Cody','Mendoza','M',3004,118876,2002,'T19');
INSERT INTO Employee  values (61,'Gordon','Green','M',3004,114261,2002,'T19');
INSERT INTO Employee  values (45,'Leah','Sherman','F',3003,99434,2001,'T18');
INSERT INTO Employee  values (62,'Caleb','Hale','M',3002,74954,2004,'T18');
INSERT INTO Employee  values (72,'Clyde','Schmidt','M',3003,105877,2005,'T18');
INSERT INTO Employee  values (89,'Leland','Jones','M',3003,109451,2005,'T18');
INSERT INTO Employee  values (90,'Terrance','Francis','M',3003,94379,2005,'T18');
INSERT INTO Employee  values (93,'Johnathan','Bass','M',3004,116826,2002,'T19');
INSERT INTO Employee  values (88,'Jake','Benson','M',3002,83090,2004,'T18');
INSERT INTO Employee  values (2,'Rosa','Palmer','F',3003,100426,2004,'T18');
INSERT INTO Employee  values (4,'Gertrude','Hernandez','F',3003,105777,2004,'T18');
INSERT INTO Employee  values (15,'Yolanda','Boone','F',3003,106422,2002,'T18');
INSERT INTO Employee  values (55,'Bradley','Mack','M',3003,94571,2002,'T18');
INSERT INTO Employee  values (54,'Curtis','Patterson','M',3002,80497,2002,'T18');
INSERT INTO Employee  values (58,'Marcos','Pena','M',3002,74576,2002,'T18');
INSERT INTO Employee  values (66,'Ramiro','Ballard','M',3002,74788,2002,'T18');
INSERT INTO Employee  values (12,'Meredith','Bryant','F',3003,96655,2004,'T18');
INSERT INTO Employee  values (60,'Floyd','Murray','M',3002,70591,2003,'T17');
INSERT INTO Employee  values (91,'Gilberto','Flores','M',3002,84310,2002,'T18');
INSERT INTO Employee  values (21,'Deborah','Perry','F',3003,108582,2004,'T18');
INSERT INTO Employee  values (10,'Beatrice','Floyd','F',3001,60254,2002,'T17');
INSERT INTO Employee  values (100,'Roosevelt','Gill','M',3003,91042,2005,'T18');
INSERT INTO Employee  values (65,'Angel','Knight','M',3001,61305,2003,'T17');
INSERT INTO Employee  values (34,'Sue','Walker','F',3001,68178,2002,'T17');
INSERT INTO Employee  values (67,'Omar','Sims','M',3003,98271,2003,'T18');
INSERT INTO Employee  values (33,'Theresa','Harrison','F',3003,104778,2004,'T18');
INSERT INTO Employee  values (69,'Isaac','Becker','M',3001,53309,2003,'T17');
INSERT INTO Employee  values (3,'Marianne','Daniel','F',3002,80207,2005,'T18');
INSERT INTO Employee  values (5,'Allison','Alvarado','F',3002,76382,2005,'T18');
INSERT INTO Employee  values (47,'Myra','Richards','F',3002,72616,2005,'T17');
INSERT INTO Employee  values (46,'Connie','Mason','F',3003,109598,2004,'T18');
INSERT INTO Employee  values (43,'Susie','Andrews','F',3001,65987,2002,'T17');
INSERT INTO Employee  values (75,'Gregory','Hayes','M',3004,111795,2003,'T19');
INSERT INTO Employee  values (76,'Brendan','Newton','M',3002,87108,2003,'T18');
INSERT INTO Employee  values (6,'Melinda','Potter','F',3001,60892,2005,'T17');
INSERT INTO Employee  values (78,'Jacob','Gross','M',3003,106432,2003,'T18');
INSERT INTO Employee  values (73,'Darrel','Moody','M',3003,98315,2004,'T18');
INSERT INTO Employee  values (99,'Ira','Bush','M',3003,108604,2004,'T24');
INSERT INTO Employee  values (32,'Faith','Nunez','F',3001,57717,2005,'T24');
INSERT INTO Employee  values (18,'Marguerite','Lane','F',3004,113146,2004,'T24');
INSERT INTO Employee  values (29,'Sheila','Jacobs','F',3004,110725,2004,'T24');
INSERT INTO Employee  values (84,'Drew','Rogers','M',3003,98301,2003,'T24');
INSERT INTO Employee  values (37,'Freda','Bowers','F',3004,124453,2004,'T24');
INSERT INTO Employee  values (48,'Lora','Hampton','F',3001,62692,2005,'T24');
INSERT INTO Employee  values (51,'George','Spencer','M',3004,123313,2004,'T24');
INSERT INTO Employee  values (80,'Guillermo','Chambers','M',3004,111309,2004,'T24');
INSERT INTO Employee  values (70,'Adam','Moss','M',3001,56807,2005,'T24');
INSERT INTO Employee  values (77,'Juan','Greer','M',3001,64475,2005,'T24');
INSERT INTO Employee  values (57,'Darrell','Reid','M',3001,65755,2002,'T24');
INSERT INTO Employee  values (85,'Courtney','Simon','M',3004,114112,2004,'T24');
INSERT INTO Employee  values (63,'Aaron','Bryant','M',3001,58677,2002,'T24');
INSERT INTO Employee  values (92,'Hubert','Moreno','M',3004,112469,2004,'T24');
INSERT INTO Employee  values (94,'Kevin','Castro','M',3004,111077,2004,'T24');
INSERT INTO Employee  values (74,'Laurence','Frazier','M',3001,61961,2002,'T24');
INSERT INTO Employee  values (97,'Ben','Chavez','M',3004,120171,2004,'T24');
INSERT INTO Employee  values (98,'Gerardo','Barton','M',3004,127783,2004,'T25');
INSERT INTO Employee  values (59,'Everett','Hughes','M',3005,157876,2004,'T25');
INSERT INTO Employee  values (86,'Amos','Brady','M',3001,56546,2005,'T24');




INSERT INTO EmployeeRating  values (8000,150,1001,4003);
INSERT INTO EmployeeRating  values (8001,59,1001,4003);
INSERT INTO EmployeeRating  values (8002,59,1001,4003);
INSERT INTO EmployeeRating  values (8003,150,1003,4004);
INSERT INTO EmployeeRating  values (8004,59,1003,4001);
INSERT INTO EmployeeRating  values (8005,39,1005,4002);
INSERT INTO EmployeeRating  values (8006,39,1001,4003);
INSERT INTO EmployeeRating  values (8007,59,1004,4002);
INSERT INTO EmployeeRating  values (8008,42,1005,4003);
INSERT INTO EmployeeRating  values (8009,42,1001,4004);
INSERT INTO EmployeeRating  values (8010,150,1005,4003);
INSERT INTO EmployeeRating  values (8011,42,1001,4004);
INSERT INTO EmployeeRating  values (8012,59,1003,4003);
INSERT INTO EmployeeRating  values (8013,59,1002,4001);
INSERT INTO EmployeeRating  values (8014,42,1003,4001);
INSERT INTO EmployeeRating  values (8015,96,1001,4003);
INSERT INTO EmployeeRating  values (8016,59,1003,4002);
INSERT INTO EmployeeRating  values (8017,42,1003,4001);
INSERT INTO EmployeeRating  values (8018,59,1001,4002);
INSERT INTO EmployeeRating  values (8019,42,1002,4004);
INSERT INTO EmployeeRating  values (8020,150,1005,4004);
INSERT INTO EmployeeRating  values (8021,59,1005,4001);
INSERT INTO EmployeeRating  values (8022,42,1001,4003);
INSERT INTO EmployeeRating  values (8023,59,1002,4003);
INSERT INTO EmployeeRating  values (8024,39,1001,4004);
INSERT INTO EmployeeRating  values (8025,39,1003,4001);
INSERT INTO EmployeeRating  values (8026,59,1005,4004);
INSERT INTO EmployeeRating  values (8027,42,1001,4003);
INSERT INTO EmployeeRating  values (8028,42,1004,4001);
INSERT INTO EmployeeRating  values (8029,59,1002,4003);
INSERT INTO EmployeeRating  values (8030,39,1003,4002);
INSERT INTO EmployeeRating  values (8031,59,1002,4004);
INSERT INTO EmployeeRating  values (8032,39,1004,4002);
INSERT INTO EmployeeRating  values (8033,59,1005,4004);
INSERT INTO EmployeeRating  values (8034,96,1002,4004);
INSERT INTO EmployeeRating  values (8035,42,1001,4001);
INSERT INTO EmployeeRating  values (8036,42,1001,4003);
INSERT INTO EmployeeRating  values (8037,59,1005,4001);
INSERT INTO EmployeeRating  values (8038,39,1003,4001);
INSERT INTO EmployeeRating  values (8039,39,1002,4002);
INSERT INTO EmployeeRating  values (8040,59,1003,4004);
INSERT INTO EmployeeRating  values (8041,59,1001,4002);
INSERT INTO EmployeeRating  values (8042,150,1005,4003);
INSERT INTO EmployeeRating  values (8043,96,1002,4003);
INSERT INTO EmployeeRating  values (8044,96,1003,4002);
INSERT INTO EmployeeRating  values (8045,42,1004,4003);
INSERT INTO EmployeeRating  values (8046,59,1001,4004);
INSERT INTO EmployeeRating  values (8047,39,1002,4004);
INSERT INTO EmployeeRating  values (8048,39,1004,4004);
INSERT INTO EmployeeRating  values (8049,39,1004,4004);
INSERT INTO EmployeeRating  values (8050,96,1002,4002);
INSERT INTO EmployeeRating  values (8051,59,1003,4004);
INSERT INTO EmployeeRating  values (8052,59,1002,4003);
INSERT INTO EmployeeRating  values (8053,59,1004,4002);
INSERT INTO EmployeeRating  values (8054,96,1005,4002);
INSERT INTO EmployeeRating  values (8055,96,1004,4004);
INSERT INTO EmployeeRating  values (8056,96,1004,4001);
INSERT INTO EmployeeRating  values (8057,96,1005,4001);
INSERT INTO EmployeeRating  values (8058,96,1003,4003);
INSERT INTO EmployeeRating  values (8059,59,1004,4002);
INSERT INTO EmployeeRating  values (8060,20,1004,4003);
INSERT INTO EmployeeRating  values (8061,96,1002,4001);
INSERT INTO EmployeeRating  values (8062,59,1001,4002);
INSERT INTO EmployeeRating  values (8063,96,1002,4004);
INSERT INTO EmployeeRating  values (8064,39,1003,4003);
INSERT INTO EmployeeRating  values (8065,20,1003,4004);
INSERT INTO EmployeeRating  values (8066,96,1002,4001);
INSERT INTO EmployeeRating  values (8067,20,1003,4001);
INSERT INTO EmployeeRating  values (8068,59,1002,4002);
INSERT INTO EmployeeRating  values (8069,20,1001,4001);
INSERT INTO EmployeeRating  values (8070,39,1002,4004);
INSERT INTO EmployeeRating  values (8071,39,1002,4002);
INSERT INTO EmployeeRating  values (8072,39,1002,4004);
INSERT INTO EmployeeRating  values (8073,59,1005,4003);
INSERT INTO EmployeeRating  values (8074,96,1004,4004);
INSERT INTO EmployeeRating  values (8075,20,1005,4004);
INSERT INTO EmployeeRating  values (8076,20,1001,4001);
INSERT INTO EmployeeRating  values (8077,39,1003,4003);
INSERT INTO EmployeeRating  values (8078,20,1005,4003);
INSERT INTO EmployeeRating  values (8079,59,1001,4003);
INSERT INTO EmployeeRating  values (8080,59,1002,4003);
INSERT INTO EmployeeRating  values (8081,39,1003,4004);
INSERT INTO EmployeeRating  values (8082,59,1005,4002);
INSERT INTO EmployeeRating  values (8083,59,1002,4001);
INSERT INTO EmployeeRating  values (8084,20,1002,4002);
INSERT INTO EmployeeRating  values (8085,59,1004,4004);
INSERT INTO EmployeeRating  values (8086,39,1001,4003);
INSERT INTO EmployeeRating  values (8087,59,1003,4004);
INSERT INTO EmployeeRating  values (8088,59,1005,4004);
INSERT INTO EmployeeRating  values (8089,39,1003,4003);
INSERT INTO EmployeeRating  values (8090,39,1004,4003);
INSERT INTO EmployeeRating  values (8091,96,1001,4004);
INSERT INTO EmployeeRating  values (8092,59,1005,4003);
INSERT INTO EmployeeRating  values (8093,96,1005,4003);
INSERT INTO EmployeeRating  values (8094,59,1003,4002);
INSERT INTO EmployeeRating  values (8095,59,1004,4001);
INSERT INTO EmployeeRating  values (8096,96,1005,4001);
INSERT INTO EmployeeRating  values (8097,59,1003,4001);
INSERT INTO EmployeeRating  values (8098,59,1001,4004);
INSERT INTO EmployeeRating  values (8099,150,1003,4001);
INSERT INTO EmployeeRating  values (8100,39,1002,4003);
















