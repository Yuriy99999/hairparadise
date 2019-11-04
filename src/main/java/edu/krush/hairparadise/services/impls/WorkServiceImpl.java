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
    WorkRepository workRepository;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    HaircutServiceImpl haircutService;
    @Autowired
    WorkerServiceImpl workerService;
    @PostConstruct
    void init(){
        workRepository.deleteAll();

        Work work1 = new Work(workerService.getAll().get(0), customerService.getAll().get(0), 1,
                LocalDate.now(), "18:30", haircutService.getAll().get(0), Status.AWAITING);

        Work work2 = new Work(workerService.getAll().get(1), customerService.getAll().get(1), 2,
                LocalDate.now(), "18:30", haircutService.getAll().get(1), Status.AWAITING);

        Work work3 = new Work(workerService.getAll().get(2), customerService.getAll().get(2), 3,
                LocalDate.now(), "18:30", haircutService.getAll().get(2), Status.AWAITING);



        works.add(work1);
        works.add(work2);
        works.add(work3);

        workRepository.saveAll(works);

    };
    @Override
    public List<Work> getAll() {
        return workRepository.findAll();
    }

    @Override
    public Work get(String id) {
        return workRepository.findById(id).orElse(null);
    }

    @Override
    public Work create(Work work) {
        return workRepository.save(work);
    }

    public List<Work> searchByDate(LocalDate date) {
        return this.getAll().stream().filter(item -> item.getDate().equals(date)).
                collect(Collectors.toList());

    }

    public List<Work> searchByWorkerId(String workerId) {
        return this.getAll().stream().filter(worker1 -> worker1.getId().
                equals(workerId)).collect(Collectors.toList());

        /*return this.getAll().stream().filter(item -> item.getWorker().equals(worker)).
                collect(Collectors.toList());*/

    }


    @Override
    public Work update(Work work) {
        return workRepository.save(work);
    }

    @Override
    public Work getByMaxCode() {
        return workRepository.findTopByOrderByCodeDesc();
    }

    @Override
    public Work delete(String id) {
        Work work = this.get(id);
        workRepository.deleteById(id);
        return work;
    }


}
