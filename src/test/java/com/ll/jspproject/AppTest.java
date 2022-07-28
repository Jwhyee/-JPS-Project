package com.ll.jspproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.jspproject.article.dto.ArticleDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void test_assertThat() {
        int rs = 10;
        assertThat(rs).isEqualTo(10);
    }

    @Test
    public void test_ObjectMapper() throws JsonProcessingException {
        ArticleDto articleDto = new ArticleDto(1, "제목", "내용");
        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(articleDto);

        System.out.println(jsonStr);
    }

}