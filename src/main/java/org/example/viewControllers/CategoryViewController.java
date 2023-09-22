package org.example.viewControllers;

import lombok.RequiredArgsConstructor;
import org.example.dao.CategoryDao;
import org.example.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryViewController {

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
    public String create(@RequestParam String name){
        Category category = new Category();
        category.setName(name);
        categoryDao.saveCategory(category);
        return "redirect:/categories";

    }
    @GetMapping("/edit/{id}")
    public String showEditCadegoryForm(@PathVariable Long id, Model model){
        Category category = categoryDao.findById(id);
        model.addAttribute("category", category);
        return "edit-category";
    }
    @PostMapping("/edit")
    public String editCategory(@RequestParam Long id, @RequestParam String name){
        Category category = categoryDao.findById(id);
        category.setName(name);
        categoryDao.updateCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
       Category category = categoryDao.findById(id);
       categoryDao.deleteCategory(category);
       return "redirect:/categories";
    }
}

