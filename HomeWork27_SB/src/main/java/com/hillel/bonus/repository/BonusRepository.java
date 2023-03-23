package com.hillel.bonus.repository;

import com.hillel.bonus.entity.Bonus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends MongoRepository<Bonus, String> {
}
