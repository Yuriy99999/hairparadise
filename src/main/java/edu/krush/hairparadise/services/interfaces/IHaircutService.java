package edu.krush.hairparadise.services.interfaces;

import edu.krush.hairparadise.model.Haircut;

import java.util.List;

public interface IHaircutService {
    List <Haircut> getAll();
    Haircut get(String id);
    Haircut create(Haircut haircut);
    Haircut update(Haircut haircut);
    Haircut delete(String id);
}
