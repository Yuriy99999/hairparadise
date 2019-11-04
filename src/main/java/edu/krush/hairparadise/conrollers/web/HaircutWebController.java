package edu.krush.hairparadise.conrollers.web;

import edu.krush.hairparadise.forms.HaircutForm;
import edu.krush.hairparadise.model.Gender;
import edu.krush.hairparadise.model.Haircut;
import edu.krush.hairparadise.services.impls.HaircutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/haircut")
@CrossOrigin("*")

@Controller
public class HaircutWebController {

    @Autowired
    HaircutServiceImpl haircutService;

    @RequestMapping ("/list")
    public String showAll(Model model){
        List<Haircut> list = haircutService.getAll();
        model.addAttribute("haircuts", list);

        return "haircutList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable(value = "id") String id) {
        haircutService.delete(id);
        List<Haircut> list = haircutService.getAll();
        //model.addAttribute("workers", list);
        return "redirect:/haircut/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addHaircut(Model model){
        System.out.println("haircutcreateGET");
        HaircutForm haircutForm = new HaircutForm();

        Map<String, String> genders = Arrays.asList(Gender.values()).
                stream().collect(Collectors.toMap(Gender::getName, Gender::getName));

        model.addAttribute(haircutForm);
        model.addAttribute("genders", genders);
        System.out.println("haircutcreateGET");
        return "/haircutAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)

    String create(Model model, @ModelAttribute("haircutForm") HaircutForm haircutForm) {
        System.out.println("POST");
        int code = haircutService.getByMaxCode().getCode()+1;

        Haircut newHaircut = new Haircut(
                code,
                haircutForm.getName(),
                haircutForm.getGender(),
                haircutForm.getCost()

        );

        haircutService.create(newHaircut);
        return "redirect:/haircut/list";
    }
}
