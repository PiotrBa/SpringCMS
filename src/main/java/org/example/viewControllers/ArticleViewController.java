package org.example.viewControllers;

import lombok.RequiredArgsConstructor;
import org.example.dao.ArticleDao;
import org.example.dao.AuthorDao;
import org.example.dao.CategoryDao;
import org.example.entity.Article;
import org.example.entity.Author;
import org.example.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleViewController {


    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("articles", articleDao.findAll());
        return "list-articles";
    }

    @GetMapping
    public String showlastFive(Model model){
        model.addAttribute("articles", articleDao.findLast5Articles());
        return "list-articles";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("article", new Article());
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("categories", categoryDao.findAll());
        return "add-article";
    }

    @PostMapping("/add")
    public String create(@RequestParam String title, @RequestParam String content,
                         @RequestParam Long authorId, @RequestParam List<Long> categoryIds){
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreated(LocalDateTime.now());
        Author author = authorDao.findByid(authorId);
        article.setAuthor(author);
       for (Long categoryId :categoryIds){
           Category category = categoryDao.findById(categoryId);
           article.getCategories().add(category);
       }

        authorDao.saveAuthor(author);
        articleDao.save(article);
        return "redirect:/articles";
    }

    @GetMapping("/edit/{id}")
    public String showEditArticleForm(@PathVariable Long id, Model model){
        Article article = articleDao.findByid(id);
        model.addAttribute("article", article);
        return "edit-article";
    }

    @PostMapping("/edit")
    public String editArticle(@RequestParam Long id, @RequestParam String title, @RequestParam String content, @RequestParam String name){
        Article article = articleDao.findByid(id);
        article.setTitle(title);
        article.setContent(content);
        Category category = categoryDao.findById(id);
        category.setName(name);
        article.setUpdated(LocalDateTime.now());
        articleDao.update(article);
        return "redirect:/articles";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id){
        Article article = articleDao.findByid(id);
       articleDao.delete(article);
        return "redirect:/articles";
    }
}
