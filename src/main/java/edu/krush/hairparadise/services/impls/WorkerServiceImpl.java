package edu.krush.hairparadise.services.impls;

import edu.krush.hairparadise.model.Work;
import edu.krush.hairparadise.model.Worker;
import edu.krush.hairparadise.repository.WorkRepository;
import edu.krush.hairparadise.repository.WorkerRepository;
import edu.krush.hairparadise.services.interfaces.IWorkService;
import edu.krush.hairparadise.services.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class WorkerServiceImpl implements IWorkerService {

    List <Worker> workers = new ArrayList<>();

    @Autowired
    WorkerRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();

        Worker worker1 = new Worker("PJ", "Harvey");
        Worker worker2 = new Worker("Karen", "O");
        Worker worker3 = new Worker("Cat", "Power");

        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);

        repository.saveAll(workers);

    };
    @Override
    public List<Worker> getAll() {
        return repository.findAll();
    }

    @Override
    public Worker get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Worker create(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker update(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker delete(String id) {
        Worker worker = this.get(id);
        repository.deleteById(id);
        return worker;
    }
}
