package com.ll.jspproject;

import com.ll.jspproject.article.controller.ArticleController;

public class Container {
    public static ArticleController getArticleController() {
        return new ArticleController();
    }
}
