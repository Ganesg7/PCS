Create Database PCSDB;
use PCSDB;
create table Employee( EmployeeId int identity (1,1)	primary key,
 FirstName char(30),
 LastName char(30),
 UserId numeric,
 Password varchar(10),
 Gender VARCHAR(6) NOT NULL CHECK (Gender IN ('Male', 'Female')),
   Role char(20),
 Active  VARCHAR(10) NOT NULL CHECK (Active IN ('Active', 'InActive')));

 Create table  Skill (SkillId		int identity(1,1)	primary key,
	 SkillName Char(30),
  SkillDescription char(500),
  Active  VARCHAR(10) NOT NULL CHECK (Active IN ('Active', 'InActive')));

  Create table  Job (JobId	int identity(1,1)	primary key,
	JobTitle char(30),
    JobDescription char(500),
    CompanyName char(30),
    Location geography,
	KeySkill char(30),
    Salary numeric,
    Active  VARCHAR(10) NOT NULL CHECK (Active IN ('Active', 'InActive')));
 
	Create table EmpSkill( ESId	int identity(1,1)	primary key,
	EmployeeId int,
	 SkillId int,
	 ExpYear Date,
	  CONSTRAINT FK_EmployeeID FOREIGN KEY (EmployeeId)
    REFERENCES Employee(EmployeeId),
	 CONSTRAINT FK_SkillID FOREIGN KEY (SkillId)
    REFERENCES Skill(SkillId));

	Create table EmpJob (EJId	int identity(1,1)	primary key,
	 EmployeeId int,
	 JobId int,
	 Recruited char(30),
     CONSTRAINT job_EmployeeID FOREIGN KEY (EmployeeId)
     REFERENCES Employee(EmployeeId),
	 CONSTRAINT FK_Jobid FOREIGN KEY (JobID)
    REFERENCES job(JobId));
