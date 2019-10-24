package edu.krush.hairparadise.conrollers.rest;

import edu.krush.hairparadise.model.Haircut;
import edu.krush.hairparadise.services.impls.HaircutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/haircut")
@CrossOrigin("*")

@RestController
public class HaircutRestController {

    @Autowired
    HaircutServiceImpl service;

    @RequestMapping ("/list")
    List <Haircut> showAll(){
        return service.getAll();
    }

    @RequestMapping ("/delete/{id}")
    Haircut delete(@PathVariable(value = "id") String id ){
        return service.delete(id);
    }

    @RequestMapping ("/get/{id}")
    Haircut get(@PathVariable(value = "id")String id){
        return service.get(id);
    }

    @PostMapping("/create")
    Haircut create(@Valid @RequestBody Haircut haircut) {
        return service.create(haircut);
    }

    @PostMapping("/update")
    Haircut update(@Valid @RequestBody Haircut haircut) {
        return service.update(haircut);
    }
}
