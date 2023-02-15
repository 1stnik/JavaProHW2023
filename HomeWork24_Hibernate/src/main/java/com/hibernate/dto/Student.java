package com.hibernate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Setter
@Getter
@Accessors(chain = true)
public class Student {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "StudentId" )
    private int StudentId;

    @Column( name = "FullName" )
    private String FullName;

    @Column( name = "StudentGroup" )
    private int StudentGroup;
    @Column( name = "AdmissionYear" )
    private int AdmissionYear;


    public Student() {
    }


    public Student(String FullName) {
        this.FullName = FullName;
    }


    public Student(int StudentId, String FullName) {
        this.StudentId = StudentId;
        this.FullName = FullName;
    }

    public Student(String fullName, int studentGroup, int admissionYear) {
        FullName = fullName;
        StudentGroup = studentGroup;
        AdmissionYear = admissionYear;
    }

    public Student(int StudentId, String FullName, int StudentGroup, int AdmissionYear) {
        this.StudentId = StudentId;
        this.FullName = FullName;
        this.StudentGroup = StudentGroup;
        this.AdmissionYear = AdmissionYear;
    }

    @Override
    public String toString() {
        return "Student { " +
                "StudentId = " + StudentId +
                ", FullName = '" + FullName + '\'' +
                ", StudentGroup = " + StudentGroup +
                ", AdmissionYear = " + AdmissionYear +
                '}';
    }
}
