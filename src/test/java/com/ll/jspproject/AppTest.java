package com.ll.jspproject;

import com.ll.jspproject.article.ArticleController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    public void junit_assertThat() {
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }

    @Test
    public void ioc__articleCOntroller() {
        ArticleController articleController = Con.getArticleController();

        assertThat(articleController).isNotNull();
    }
}