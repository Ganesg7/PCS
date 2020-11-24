Create Database PCSDB;
use PCSDB;
create table Employee( EmployeeId int auto_increment 	primary key not null,
 FirstName varchar(30) not null,
 LastName varchar(30) not null,
 UserId varchar(30) not null,
 Password varchar(10) not null,
 Gender VARCHAR(6) NOT NULL ,
   Role char(20),
 Active  VARCHAR(10) NOT NULL );
 select * From employee;
 
  Create table  Skill (SkillId		int auto_increment 	 primary key not null,
	 SkillName Char(30) not null,
  SkillDescription char(250) not null,
  Active  VARCHAR(10) NOT NULL );
  select * From Skill;
  Create table  Job (JobId	int	auto_increment 	primary key not null,
	JobTitle char(30) not null, 
    JobDescription char(250) not null,
    CompanyName char(30) not null,
    Location varchar (30) not null,
	KeySkill char(30) not null,
    Salary int not null,
    Active  VARCHAR(10) NOT NULL );
    select * From Job;
    	Create table EmpSkill( ESId	int auto_increment 	 not null	primary key,
	EmployeeId int not null, 
	 SkillId int not null,
	 ExpYear int not null,
	  CONSTRAINT FK_EmployeeID FOREIGN KEY (EmployeeId)
    REFERENCES Employee(EmployeeId),
	 CONSTRAINT FK_SkillID FOREIGN KEY (SkillId)
    REFERENCES Skill(SkillId));
    select * From  EmpSkill;
    	Create table EmpJob (EJId	int auto_increment 	not null	primary key,
	 EmployeeId int not null, 
	 JobId int not null,
	 Recruited char(30) not null,
     CONSTRAINT job_EmployeeID FOREIGN KEY (EmployeeId)
     REFERENCES Employee(EmployeeId),
	 CONSTRAINT FK_Jobid FOREIGN KEY (JobID)
    REFERENCES job(JobId));
    select * From Empjob;

select * From Employee;
Delete from Employee where Active='deactive';
insert into Employee values(1,'ganesh','Pandi',100,'GAnesh','HRA','Male','Active');



