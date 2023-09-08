package org.example.controller;

import org.example.dao.ArticleDao;
import org.example.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomePageController {

    private final ArticleDao articleDao;
    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }


    @GetMapping
    public String home(Model model){
        List<Article> list5Articles = articleDao.findLast5Articles();
        model.addAttribute("articles", list5Articles);
        return "home";
    }
}
