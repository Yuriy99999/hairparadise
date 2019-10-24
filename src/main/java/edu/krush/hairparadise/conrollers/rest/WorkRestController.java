package edu.krush.hairparadise.conrollers.rest;

import edu.krush.hairparadise.model.Work;
import edu.krush.hairparadise.services.impls.WorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/work")
@CrossOrigin("*")

@RestController
public class WorkRestController {

    @Autowired
    WorkServiceImpl service;

    @RequestMapping ("/list")
    List <Work> showAll() { return service.getAll(); }

    @RequestMapping ("/delete/{id}")
    Work delete(@PathVariable(value = "id") String id ){
        return service.delete(id);
    }

    @RequestMapping ("/get/{id}")
    Work get(@PathVariable(value = "id")String id){
        return service.get(id);
    }

    @PostMapping("/create")
    Work create(@Valid @RequestBody Work work) {
        return service.create(work);
    }

    @PostMapping("/update")
    Work update(@Valid @RequestBody Work work) {
        return service.update(work);
    }



}
