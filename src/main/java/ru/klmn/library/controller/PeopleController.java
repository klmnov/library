package ru.klmn.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.klmn.library.dao.PersonDAO;
import ru.klmn.library.models.Person;

@Controller
public class PeopleController {
    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @RequestMapping("/")
    public String startPage() {
        return "startPage";
    }

    @RequestMapping("/people")
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @RequestMapping("/people/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @RequestMapping("/people/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping("/people")
    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/";
    }

    @GetMapping("/people/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/people/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id")int id) {
        personDAO.update(id, person);
        return "redirect:/people";
    }
}
