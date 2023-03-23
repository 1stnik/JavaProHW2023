package com.hillel.bonus.service;

import com.hillel.bonus.entity.Bonus;

import java.util.List;

public interface BonusService {

    void addBonus(int yearsOfExperience);

    List<Bonus> getEmployeesBonus();
}
