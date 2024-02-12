package ru.klmn.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.klmn.library.dao.BookDAO;
import ru.klmn.library.dao.PersonDAO;
import ru.klmn.library.models.Book;

@Controller
public class BooksController {
    private final BookDAO bookDAO;

    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @RequestMapping("books")
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }
    @RequestMapping("books/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "books/show";
    }

    @RequestMapping("books/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @RequestMapping("books/edit")
    public String edit(@PathVariable("id")int id, Model model) {
       model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }

}
