package com.ll.jspproject.article.controller;

import com.ll.jspproject.annotation.Autowired;
import com.ll.jspproject.annotation.Controller;
import com.ll.jspproject.annotation.GetMapping;
import com.ll.jspproject.article.service.ArticleService;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("usr/article/list")
    public void showList() {
        System.out.println("articleService = " + articleService);
    }

    public ArticleService getArticleServiceForTest() {
        return articleService;
    }
}
