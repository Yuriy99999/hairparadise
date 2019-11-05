package edu.krush.hairparadise.conrollers.web;

import edu.krush.hairparadise.forms.WorkerForm;
import edu.krush.hairparadise.model.Worker;
import edu.krush.hairparadise.services.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")

@Controller
public class WorkerWebController {

    @Autowired
    WorkerServiceImpl service;

    @RequestMapping ("worker/list")
    public String showAll(Model model){
        List<Worker> list = service.getAll();
        model.addAttribute("workers", list);

        return "worker/workerList";
    }

    @RequestMapping ("admin/worker/list")
    public String showAll1(Model model){
        List<Worker> worker = service.getAll();
        model.addAttribute("workers", worker);

        return "admin/adminWorkerList";
    }

    @RequestMapping(value = "worker/create", method = RequestMethod.GET)
    public String addWorker(Model model){
        WorkerForm workerForm = new WorkerForm();
        model.addAttribute("workerForm", workerForm);

        return "workerAdd";

    }

    @RequestMapping(value = "worker/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("workerForm") WorkerForm form){

        Worker worker = new Worker(
                form.getName(),
                form.getSurname()
                );

        service.create(worker);

        return "redirect:/admin/worker/list";
    }

    @RequestMapping("worker/delete/{id}")
    String delete(Model model, @PathVariable(value = "id") String id) {
        service.delete(id);
        List<Worker> list = service.getAll();
        model.addAttribute("workers", list);
        return "redirect:/worker/list";

    }


    @RequestMapping("admin/worker/delete/{id}")
    String delete1(Model model, @PathVariable(value = "id") String id) {
        service.delete(id);
        List<Worker> list = service.getAll();
        //model.addAttribute("workers", list);
        return "redirect:/admin/worker/list";
    }

    @RequestMapping ("/worker")
    public String main(Model model){
        return "/worker/workerForm";
    }

}
