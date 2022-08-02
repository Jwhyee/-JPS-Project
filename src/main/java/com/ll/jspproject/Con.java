package com.ll.jspproject;

import com.ll.jspproject.article.ArticleController;

public class Con {
    public static ArticleController getArticleController() {
        return new ArticleController();
    }
}
