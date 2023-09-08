package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.dao.CategoryDao;
import org.example.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao categoryDao;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("categories", categoryDao.findAll());
        return "list-categories";
    }

    @GetMapping("/text")
    public String findAll() {
        return categoryDao.findAll()
                .stream()
                .map(Category::toString)
                .collect(Collectors.joining("\n"));
    }
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("category", new Category());
        return "add-category";
    }
    @PostMapping("/add")
    public String create(@RequestParam String name, @RequestParam String description){
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryDao.saveCategory(category);
        return category.toString();

    }
    @GetMapping("/edit/{id}")
    public String showEditCadegory(@PathVariable Long id, Model model){
        Category category = categoryDao.findById(id);
        model.addAttribute("category", category);
        return "edit-category";
    }
    @PostMapping("/edit")
    public String editCategory(@RequestParam Long id, @RequestParam String name, @RequestParam String description){
        Category category = categoryDao.findById(id);
        category.setName(name);
        category.setDescription(description);
        categoryDao.updateCategory(category);
        return category.toString();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
       Category category = categoryDao.findById(id);
       categoryDao.deleteCategory(category);
       return category.toString();
    }
}

