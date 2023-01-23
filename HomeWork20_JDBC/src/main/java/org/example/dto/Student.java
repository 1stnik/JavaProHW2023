package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class Student {

    private int StudentId;

    private String FullName;

    private int StudentGroup;
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
