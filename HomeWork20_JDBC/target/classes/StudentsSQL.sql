drop database if exists Student;
create database if not exists Student /*!40100 default character set utf8 */;
use Student;

create table StudentGroups (
    StudentGroupId int(5) not null auto_increment,
    StudentGroupName varchar(50) null,
    primary key (StudentGroupId)
);

create table Students (
    StudentId int(10) not null auto_increment,
    FullName varchar(100) null,
    StudentGroup int(5) null,
    AdmissionYear int(4) null,
    primary key (StudentId), foreign key (StudentGroup) references StudentGroups (StudentGroupId)
);

create table Faculties (
    FacultyId int(10) not null auto_increment,
    FacultyName varchar(100) null,
    HeadOfFaculty varchar(100) null,
    primary key (FacultyId)
);

create table Professors (
    ProfessorId int(10) not null auto_increment,
    ProfessorFullName varchar(100) null,
    Faculty int(10) null,
    primary key (ProfessorId), foreign key (Faculty) references Faculties (FacultyId)
);

create table Subjects (
    SubjectId int(10) not null auto_increment,
    SubjectName varchar(100) null,
    Professor int(10) null,
    Semester int(5) null,
    YearOfStudy int(4) null,
    primary key (SubjectId), foreign key (Professor) references Professors (ProfessorId)
);

create table Points (
    PointId int(10) not null auto_increment,
    Subject int(10) null,
    Student int(10) null,
    Point int(10) null,
    primary key (PointId), foreign key (Student) references Students (StudentId),
    foreign key (Subject) references Subjects (SubjectId)
);
