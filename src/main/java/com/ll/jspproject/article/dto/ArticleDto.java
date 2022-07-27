package com.ll.jspproject.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ArticleDto {
    private long id;
    private String title;
    private String body;
}