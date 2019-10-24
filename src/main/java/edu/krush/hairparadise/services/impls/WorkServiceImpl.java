package edu.krush.hairparadise.services.impls;

import edu.krush.hairparadise.model.Work;
import edu.krush.hairparadise.repository.WorkRepository;
import edu.krush.hairparadise.services.interfaces.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class WorkServiceImpl implements IWorkService {

    List <Work> works = new ArrayList<>();

    @Autowired
    WorkRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();

        Work work1 = new Work("Patti",  1 , LocalDate.of(2019, 10,24),
                "13:30", "bold", "wolker", "123", "status");
        Work work2 = new Work("Patti",  1 , LocalDate.of(2019, 10,24),
                "13:30", "bold", "wolker", "123", "status");
        Work work3 = new Work("Patti",  1 , LocalDate.of(2019, 10,24),
                "13:30", "bold", "wolker", "123", "status");

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

    @Override
    public Work update(Work work) {
        return repository.save(work);
    }

    @Override
    public Work delete(String id) {
        Work work = this.get(id);
        repository.deleteById(id);
        return work;
    }
}
