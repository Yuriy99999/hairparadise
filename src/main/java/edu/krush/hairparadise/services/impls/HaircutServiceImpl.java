package edu.krush.hairparadise.services.impls;

import edu.krush.hairparadise.model.Gender;
import edu.krush.hairparadise.model.Haircut;
import edu.krush.hairparadise.repository.HaircutRepository;
import edu.krush.hairparadise.services.interfaces.IHaircutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class HaircutServiceImpl implements IHaircutService {

    List <Haircut> haircuts = new ArrayList<>();

    @Autowired
    HaircutRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();

        Haircut kare = new Haircut(1, "Kare", Gender.FEMALE, 200);
        Haircut bold = new Haircut(2, "Bold", Gender.MALE, 10);
        Haircut afro = new Haircut(1, "Afro", Gender.FEMALE, 500);

        haircuts.add(kare);
        haircuts.add(bold);
        haircuts.add(afro);

        repository.saveAll(haircuts);

    };
    @Override
    public List<Haircut> getAll() {
        return repository.findAll();
    }

    @Override
    public Haircut get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Haircut create(Haircut haircut) {
        return repository.save(haircut);
    }

    @Override
    public Haircut update(Haircut haircut) {
        return repository.save(haircut);
    }

    @Override
    public Haircut delete(String id) {
        Haircut haircut = this.get(id);
        repository.deleteById(id);
        return haircut;
    }
}
