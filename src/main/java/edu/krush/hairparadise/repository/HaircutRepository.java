package edu.krush.hairparadise.repository;

import edu.krush.hairparadise.model.Haircut;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaircutRepository extends MongoRepository<Haircut, String> {
}
