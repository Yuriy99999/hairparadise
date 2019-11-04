package edu.krush.hairparadise.repository;

import edu.krush.hairparadise.model.Work;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkRepository extends MongoRepository <Work, String> {
    Work findTopByOrderByCodeDesc();

    List<Work> findAllByDate(LocalDate date);

}
