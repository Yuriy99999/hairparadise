package edu.krush.hairparadise.conrollers.web;

import edu.krush.hairparadise.forms.WorkForm;
import edu.krush.hairparadise.model.Customer;
import edu.krush.hairparadise.model.Haircut;
import edu.krush.hairparadise.model.Work;
import edu.krush.hairparadise.model.Worker;
import edu.krush.hairparadise.services.impls.CustomerServiceImpl;
import edu.krush.hairparadise.services.impls.HaircutServiceImpl;
import edu.krush.hairparadise.services.impls.WorkServiceImpl;
import edu.krush.hairparadise.services.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        return "/worker/workerW" +
                " orkAdd";
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
                workForm.getStatus()
        );

        workService.create(newWork);
        return "redirect:/work/list";
    }

    @RequestMapping(value = "/search/{date}")
    String searchBydate(Model model, @PathVariable(value = "date") LocalDate  date){
         List<Work> works = workService.searchByDate(date);
         model.addAttribute("works", works);
         return "workList";
    }

    @RequestMapping(value = "/search/{worker}")
    String searchByWorker(Model model, @PathVariable(value = "worker") Worker worker){
        List<Work> works = workService.searchByWorker(worker);
        model.addAttribute("works", works);
        return "workList";
    }




    @RequestMapping("worker/work/delete/{id}")
    String delete(Model model, @PathVariable(value = "id") String id) {
        workService.delete(id);
        List<Work> list = workService.getAll();
        //model.addAttribute("workers", list);
        return "redirect:/work/list";
    }

}
