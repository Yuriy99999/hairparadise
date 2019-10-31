package edu.krush.hairparadise.conrollers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@CrossOrigin("*")

@Controller
public class AdminWebController {
    @RequestMapping ("")
    public String showAll(Model model){
        return "admin/adminForm";
    }
}
