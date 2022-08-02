package com.ll.jspproject.article.controller;

import com.ll.jspproject.annotation.Controller;
import com.ll.jspproject.annotation.GetMapping;

@Controller
public class ArticleController {

    @GetMapping("usr/article/list")
    public void showList() {

    }
}
