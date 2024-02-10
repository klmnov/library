package ru.klmn.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.klmn.library.dao.PersonDAO;

@Controller
public class LibraryController {
    private final PersonDAO personDAO;

    @Autowired
    public LibraryController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @RequestMapping("/")
    public String startPage() {
        return "startPage";
    }

    @RequestMapping("/people")
    public String index(Model model) {
        model.addAttribute("person", personDAO.index());
        return "people/index";
    }

    @RequestMapping("/people/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("people", personDAO.show(id));
        return "people/show";
    }


}
