package org.example.viewControllers;

import lombok.RequiredArgsConstructor;
import org.example.dao.ArticleDao;
import org.example.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Controller
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleViewController {


    private final ArticleDao articleDao;

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
        return "add-article";
    }

    @PostMapping("/add")
    public String createPersonNewWay(@RequestParam String title, @RequestParam String articleAuthor, @RequestParam String content){
        Article article = new Article();
        article.setTitle(title);
        article.setArticleAuthor(articleAuthor);
        article.setContent(content);
        article.setCreated(LocalDateTime.now());
        articleDao.save(article);
        return "redirect:/articles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Article article = articleDao.findByid(id);
        model.addAttribute("article", article);
        return "edit-article";
    }

    @PostMapping("/edit")
    public String editArticle(@RequestParam Long id, @RequestParam String title, @RequestParam String articleAuthor, @RequestParam String content){
        Article article = articleDao.findByid(id);
        article.setTitle(title);
        article.setArticleAuthor(articleAuthor);
        article.setContent(content);
        article.setUpdated(LocalDateTime.now());
        articleDao.update(article);
        return "redirect:/articles";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id, Model model){
        Article article = articleDao.findByid(id);
        model.addAttribute("article", article);
        return "redirect:/articles";
    }
}
