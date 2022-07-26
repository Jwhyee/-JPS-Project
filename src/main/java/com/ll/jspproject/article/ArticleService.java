package com.ll.jspproject.article;

import com.ll.jspproject.article.dto.ArticleDto;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;
    public ArticleService(){
        articleRepository = new ArticleRepository();
    }

    public long write(String title, String body) {
        return articleRepository.write(title, body);
    }

    public List<ArticleDto> findAll() {
        return articleRepository.findAll();
    }

    public ArticleDto findById(long id) {
        return articleRepository.findById(id);
    }
}
