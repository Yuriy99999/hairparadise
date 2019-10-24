package edu.krush.hairparadise.conrollers.web;

import edu.krush.hairparadise.forms.WorkerForm;
import edu.krush.hairparadise.model.Work;
import edu.krush.hairparadise.model.Worker;
import edu.krush.hairparadise.services.impls.WorkServiceImpl;
import edu.krush.hairparadise.services.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/worker")
@CrossOrigin("*")

@Controller
public class WorkerWebController {

    @Autowired
    WorkerServiceImpl service;

    @RequestMapping ("/list")
    public String showAll(Model model){
        List<Worker> list = service.getAll();
        model.addAttribute("workers", list);

        return "workerList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addWorker(Model model){
        WorkerForm workerForm = new WorkerForm();
        model.addAttribute("workerForm", workerForm);

        return "workerAdd";

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("workerForm") WorkerForm form){

        Worker worker = new Worker(
                form.getName(),
                form.getSurname()
                );

        service.create(worker);

        return "redirect:/worker/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable(value = "id") String id) {
        service.delete(id);
        List<Worker> list = service.getAll();
        //model.addAttribute("workers", list);
        return "redirect:/worker/list";
    }

}
