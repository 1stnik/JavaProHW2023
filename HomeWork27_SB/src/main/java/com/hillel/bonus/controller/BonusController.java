package com.hillel.bonus.controller;

import com.hillel.bonus.entity.Bonus;
import com.hillel.bonus.service.BonusService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bonus")
@RequiredArgsConstructor
public class BonusController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final BonusService bonusService;

    @RequestMapping(value = "/addBonusRate", method = RequestMethod.POST)
    public void addBonus(int yearsOfExperience){
        bonusService.addBonus(yearsOfExperience);
        LOG.info("Add bonus limit as < " + yearsOfExperience + " > year of experience");
    }

    @RequestMapping(value = "/getEmployeesWithBonus", method = RequestMethod.GET)
    public List<Bonus> getAllEmployeeLoyalty(){
        LOG.info("Get all employees with bonus.");
        List<Bonus> employeeWithBonus = bonusService.getEmployeesBonus();
        for (Bonus b: employeeWithBonus) {
            System.out.print(b + "; ");
        }
        return employeeWithBonus;
    }
}
