package com.hillel.bonus.service.impl;

import com.hillel.bonus.service.BonusService;
import com.hillel.bonus.entity.Bonus;
import com.hillel.bonus.entity.Employee;
import com.hillel.bonus.repository.BonusRepository;
import com.hillel.bonus.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BonusServiceImpl implements BonusService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final EmployeeRepository employeeRepository;
    private final BonusRepository bonusRepository;

    @Override
    public void addBonus(int yearsOfExperience) {
        List<Employee> loyaltyBonusEmployee = employeeRepository.findAll()
                .stream()
                .filter(e -> e.getYearsOfExperience() >= yearsOfExperience)
                .peek(e -> {
                    Bonus bonus = new Bonus();
                    bonus.setEmployeeName(e.getEmployeeName());
                    bonusRepository.save(bonus);
                })
                .sorted(Comparator.comparing(Employee::getYearsOfExperience))
                .toList();

        if (loyaltyBonusEmployee.isEmpty()) {
            LOG.info("No employees to receive bonus");
        }
    }

    @Override
    public List<Bonus> getEmployeesBonus() {
        return bonusRepository.findAll().stream().toList();
    }
}
