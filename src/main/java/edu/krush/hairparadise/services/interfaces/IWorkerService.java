package edu.krush.hairparadise.services.interfaces;

import edu.krush.hairparadise.model.Worker;

import java.util.List;

public interface IWorkerService {
    List<Worker> getAll();
    Worker get(String id);
    Worker create(Worker work);
    Worker update(Worker work);
    Worker delete(String id);
}
