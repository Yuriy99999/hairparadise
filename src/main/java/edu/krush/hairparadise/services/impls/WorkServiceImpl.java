package edu.krush.hairparadise.services.impls;

import edu.krush.hairparadise.model.*;
import edu.krush.hairparadise.repository.WorkRepository;
import edu.krush.hairparadise.services.interfaces.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkServiceImpl implements IWorkService {

    List <Work> works = new ArrayList<>();
    List <Worker> workers = new ArrayList<>();

    @Autowired
    WorkRepository repository;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    HaircutServiceImpl haircutService;
    @Autowired
    WorkerServiceImpl workerService;
    @PostConstruct
    void init(){
        repository.deleteAll();

        Work work1 = new Work(workerService.getAll().get(0), customerService.getAll().get(0), 1,
                LocalDate.now(), "18:30", haircutService.getAll().get(0), "status");

        Work work2 = new Work(workerService.getAll().get(1), customerService.getAll().get(1), 2,
                LocalDate.now(), "18:30", haircutService.getAll().get(1), "status");

        Work work3 = new Work(workerService.getAll().get(2), customerService.getAll().get(2), 3,
                LocalDate.now(), "18:30", haircutService.getAll().get(2), "status");



        works.add(work1);
        works.add(work2);
        works.add(work3);

        repository.saveAll(works);

    };
    @Override
    public List<Work> getAll() {
        return repository.findAll();
    }

    @Override
    public Work get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Work create(Work work) {
        return repository.save(work);
    }

    public List<Work> searchByDate(LocalDate date) {
        return this.getAll().stream().filter(item -> item.getDate().equals(date)).
                collect(Collectors.toList());

    }

    public List<Work> searchByWorker(Worker worker) {
        return this.getAll().stream().filter(item -> item.getWorker().equals(worker)).
                collect(Collectors.toList());

    }

    @Override
    public Work update(Work work) {
        return repository.save(work);
    }

    @Override
    public Work getByMaxCode() {
        return repository.findTopByOrderByCodeDesc();
    }

    @Override
    public Work delete(String id) {
        Work work = this.get(id);
        repository.deleteById(id);
        return work;
    }
}
