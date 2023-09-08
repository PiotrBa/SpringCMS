package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dao.AuthorDao;
import org.example.entity.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorDao authorDao;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("authors", authorDao.findAll());
        return "list-authors";
    }

    @GetMapping("/text")
    public String findAll(){
        return authorDao.findAll()
                .stream()
                .map(Author::toString)
                .collect(Collectors.joining("\n"));
    }

    @GetMapping("add")
    public String showAddForm(Model model){
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping("/add")
    public String create(@RequestParam String firstName, @RequestParam String lastName){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.saveAuthor(author);
        return author.toString();
    }

    @GetMapping("/edit/{id}")
    public String showEditAuthor(@PathVariable Long id, Model model){
        Author author = authorDao.findByid(id);
        model.addAttribute("author", author);
        return "edit-author";
    }

    @PostMapping("/edit")
    public String editAuthor(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName){
        Author author = authorDao.findByid(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.updateAuthor(author);
        return author.toString();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@RequestParam Long id){
        Author author = authorDao.findByid(id);
        authorDao.delete(author);
        return author.toString();
    }
}