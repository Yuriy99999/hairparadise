package edu.krush.hairparadise.conrollers.web;

import edu.krush.hairparadise.model.Haircut;
import edu.krush.hairparadise.services.impls.HaircutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/haircut")
@CrossOrigin("*")

@Controller
public class HaircutWebController {

    @Autowired
    HaircutServiceImpl service;

    @RequestMapping ("/list")
    public String showAll(Model model){
        List<Haircut> list = service.getAll();
        model.addAttribute("haircuts", list);

        return "haircutList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable(value = "id") String id) {
        service.delete(id);
        List<Haircut> list = service.getAll();
        //model.addAttribute("workers", list);
        return "redirect:/haircut/list";
    }
}
