package edu.krush.hairparadise.repository;

import edu.krush.hairparadise.model.Work;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends MongoRepository <Work, String> {
    Work findTopByOrderByCodeDesc();
}
