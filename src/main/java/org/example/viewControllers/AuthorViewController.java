package org.example.viewControllers;

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
public class AuthorViewController {

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
    public String create(@RequestParam String name){
        Author author = new Author();
        author.setName(name);
        authorDao.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditAuthorForm(@PathVariable Long id, Model model){
        Author author = authorDao.findByid(id);
        model.addAttribute("author", author);
        return "edit-author";
    }

    @PostMapping("/edit")
    public String editAuthor(@RequestParam Long id, @RequestParam String name){
        Author author = authorDao.findByid(id);
        author.setName(name);
        authorDao.updateAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        Author author = authorDao.findByid(id);
        authorDao.delete(author);
        return "redirect:/authors";
    }
}
