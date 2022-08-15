package ru.zoran.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zoran.library.dao.BookDAO;
import ru.zoran.library.models.Book;
import ru.zoran.library.models.Person;
import ru.zoran.library.util.BookValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/library")
public class BookController {

    private final BookDAO bookDAO;
    private final BookValidator bookValidator;

    @Autowired
    public BookController(BookDAO bookDAO, BookValidator bookValidator) {
        this.bookDAO = bookDAO;
        this.bookValidator = bookValidator;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("library", bookDAO.index());
        return "library/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @ModelAttribute("id") int id){
        model.addAttribute("book", bookDAO.show(id));
        return "library/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookDAO.show(id));
        return "library/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable("id") int id, BindingResult bindingResult){
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) return "library/edit";
        bookDAO.update(id, book);
        return "redirect:/library";
    }

    @GetMapping("/newBook")
    public String newBook(@ModelAttribute("book") Book book){
        return "library/new";
    }

    @PostMapping()
    public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        bookValidator.validate(book, bindingResult);
        if(bindingResult.hasErrors()){
            return "library/new";
        }
        bookDAO.save(book);
        return "redirect:/library";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDAO.delete(id);
        return "redirect:/library";
    }
}
