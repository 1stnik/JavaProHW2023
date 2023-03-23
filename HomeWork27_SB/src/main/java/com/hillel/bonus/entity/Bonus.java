package com.hillel.bonus.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@RequiredArgsConstructor
public class Bonus {

    @Id
    private String employeeId;
    private String employeeName;

    @Override
    public String toString() {
        return employeeName;
    }
}
