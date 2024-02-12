package ru.klmn.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.klmn.library.dao.BookDAO;
import ru.klmn.library.dao.PersonDAO;

@Controller
public class BooksController {
    private final BookDAO bookDAO;

    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @RequestMapping("/books")
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }
}
