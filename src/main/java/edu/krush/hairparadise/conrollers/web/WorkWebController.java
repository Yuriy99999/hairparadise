package edu.krush.hairparadise.conrollers.web;

import edu.krush.hairparadise.forms.DateForm;
import edu.krush.hairparadise.forms.WorkForm;
import edu.krush.hairparadise.model.*;
import edu.krush.hairparadise.services.impls.CustomerServiceImpl;
import edu.krush.hairparadise.services.impls.HaircutServiceImpl;
import edu.krush.hairparadise.services.impls.WorkServiceImpl;
import edu.krush.hairparadise.services.impls.WorkerServiceImpl;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@RequestMapping("/work")
@CrossOrigin("*")

@Controller
public class WorkWebController {

    @Autowired
    WorkServiceImpl workService;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    HaircutServiceImpl haircutService;
    @Autowired
    WorkerServiceImpl workerService;

    @RequestMapping("/get/{id}")
    public Work get(@PathVariable(value = "id")String id){
        return workService.get(id);
    }


    @RequestMapping ("work/list")
    public String showAll(Model model){
        List<Work> list = workService.getAll();
        model.addAttribute("works", list);

        return "worker/workList";
    }


    @RequestMapping ("admin/work/list")
    public String showAll1(Model model){
        List<Work> list = workService.getAll();
        model.addAttribute("works", list);

        return "admin/adminWorkList";
    }



    @RequestMapping(value = "worker/work/create", method = RequestMethod.GET)
    public String addWork (Model model){
        WorkForm workForm = new WorkForm();

        Map<String, String> mavs = workerService.getAll().stream().
                collect(Collectors.toMap(Worker::getId, Worker::getFullName));
        model.addAttribute("mavs", mavs);

        Map<String, String> mavs1 = customerService.getAll().stream().
                collect(Collectors.toMap(Customer::getId, Customer::getFullName));
        model.addAttribute("mavs1", mavs1);

        Map<String, String> mavs2 = haircutService.getAll().stream().
                collect(Collectors.toMap(Haircut::getId, Haircut::getName));
        model.addAttribute("mavs2", mavs2);

        model.addAttribute("workForm", workForm);
        return "/worker/workerWorkAdd";
    }

    @RequestMapping(value = "worker/work/create", method = RequestMethod.POST)

    String create(Model model, @ModelAttribute("workForm") WorkForm workForm) {
        String workerId = workForm.getWorker().getId();
        Worker worker = workerService.get(workerId);

        String customerId = workForm.getCustomer().getId();
        Customer customer = customerService.get(customerId);

        int code = workService.getByMaxCode().getCode()+1;

        String haircutId = workForm.getHaircut().getId();
        Haircut haircut = haircutService.get(haircutId);

        Work newWork = new Work(
                worker,
                customer,
                code,
                LocalDate.parse(workForm.getDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                workForm.getTime(),
                haircut,
                //workForm.getStatus()
                Status.AWAITING
        );

        workService.create(newWork);
        return "redirect:/work/list";
    }

    @RequestMapping (value = "search1", method = RequestMethod.GET)
    public String datePicker(Model model){
        DateForm dateForm = new DateForm();
        model.addAttribute("dateForm", dateForm);
        System.out.println("search GET");

        return "worker/dateSearch";
    }

    @RequestMapping(value = "/search1", method = RequestMethod.POST)
    String searchBydate(Model model, @ModelAttribute("dateForm") DateForm dateForm){
        System.out.println("search POST");
        LocalDate date1 = LocalDate.parse(dateForm.getDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        System.out.println("search POST");
        System.out.println(date1);

        List<Work> works = workService.searchByDate(date1);

        model.addAttribute("works", works);
        return "worker/workList";

    }

    @RequestMapping(value = "/search2", method = RequestMethod.GET)
    public String searchByWorker (Model model){

        WorkForm workForm = new WorkForm();

        Map<String, String> mavs = workerService.getAll().stream().
                collect(Collectors.toMap(Worker::getId, Worker::getFullName));
        model.addAttribute("mavs", mavs);
        mavs.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey()+ " " + entry.getValue());

        });
        model.addAttribute("workForm", workForm);
        return "/worker/searchWorker";
    }


    @RequestMapping(value = "/search2", method = RequestMethod.POST)
    String searchByWorker(Model model, @ModelAttribute("workForm") WorkForm workForm){

        Worker worker = workForm.getWorker();
        List<Work> works = workService.getAll().stream().filter(work1 -> work1.

                getWorker().equals(worker)).collect(Collectors.toList());
        //List<Work> works = workService.searchByWorkerId(workForm.getWorker().getId());
        List<Work> works2 = workService.getAll();
        works2.stream().forEach(el-> System.out.println(el));
        System.out.println(workForm.getWorker().getId());
        //System.out.println(workForm.getWorker());
        //System.out.println(worker);
        model.addAttribute("works", works);

        return "worker/workList";
    }




    @RequestMapping("worker/work/delete/{id}")
    String delete(Model model, @PathVariable(value = "id") String id) {
        workService.delete(id);
        List<Work> list = workService.getAll();
        //model.addAttribute("workers", list);
        return "redirect:/work/list";
    }

    @RequestMapping(value = "/worker/work/update/{id}")

    String update(Model model, @PathVariable(value = "id") String id) {

        Work work = workService.get(id);
        work.setStatus(Status.DONE);
        workService.update(work);
        return "redirect:/work/list";
    }

}
