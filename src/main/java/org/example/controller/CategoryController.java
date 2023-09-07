package org.example.controller;

import org.example.dao.CategoryDao;
import org.example.entity.Category;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao categoryDao;
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    @GetMapping
    public String findAll(Model model){
        model.addAttribute("categories", categoryDao.findAll());
        return "list-categories";
    }





    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("category", new Category());
        return "add-category";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute Category category){
        categoryDao.saveCategory(category);
        return "redirect:/categories";

    }





    @GetMapping("/edit/{id}")
    public String showEditCadegory(@PathVariable Long id, Model model){
        Category category = categoryDao.findById(id);
        model.addAttribute("category", category);
        return "edit-category";
    }
    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category){
        categoryDao.updateCategory(category);
        return "redirect:/categories";
    }


}
