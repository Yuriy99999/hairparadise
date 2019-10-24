package edu.krush.hairparadise.repository;

import edu.krush.hairparadise.model.Work;
import edu.krush.hairparadise.model.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends MongoRepository <Worker, String> {
}
