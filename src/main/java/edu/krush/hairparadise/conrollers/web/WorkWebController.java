package edu.krush.hairparadise.conrollers.web;

import edu.krush.hairparadise.forms.WorkForm;
import edu.krush.hairparadise.model.Work;
import edu.krush.hairparadise.services.impls.WorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RequestMapping("/work")
@CrossOrigin("*")

@Controller
public class WorkWebController {

    @Autowired
    WorkServiceImpl service;

    @RequestMapping ("/list")
    public String showAll(Model model){
        List<Work> list = service.getAll();
        model.addAttribute("works", list);

        return "workList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addWork (Model model){
        WorkForm workForm = new WorkForm();
        model.addAttribute("workerForm", workForm);
        return "workAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)

    String create(Model model, @ModelAttribute("workform") WorkForm workForm) {
        Work newWork = new Work(
                workForm.getCustomerName(),
                workForm.getCode(),
                LocalDate.parse(workForm.getDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                workForm.getTime(),
                workForm.getHaircutName(),
                workForm.getWorkerName(),
                workForm.getPrice(),
                workForm.getStatus()
        );
        service.create(newWork);
        return "redirect:/work/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable(value = "id") String id) {
        service.delete(id);
        List<Work> list = service.getAll();
        //model.addAttribute("workers", list);
        return "redirect:/work/list";
    }

}
