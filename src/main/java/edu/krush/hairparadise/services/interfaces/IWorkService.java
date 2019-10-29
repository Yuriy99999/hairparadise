package edu.krush.hairparadise.services.interfaces;

import edu.krush.hairparadise.model.Work;

import java.util.List;

public interface IWorkService {
    List <Work> getAll();
    Work get(String id);
    Work create(Work work);
    Work update(Work work);
    Work delete(String id);

    Work getByMaxCode();
}
