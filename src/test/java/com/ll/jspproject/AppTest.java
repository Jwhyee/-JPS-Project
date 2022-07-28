package com.ll.jspproject;

import com.ll.jspproject.article.dto.ArticleDto;
import com.ll.jspproject.util.Ut;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    public void test_assertThat() {
        int rs = 10;
        assertThat(rs).isEqualTo(10);
    }

    @Test
    public void test_ObjectMapper() {
        ArticleDto articleDto = new ArticleDto(1, "제목", "내용");

        String jsonStr = Ut.json.toStr(articleDto, "");
        assertThat(jsonStr).isNotBlank();
        assertThat(jsonStr).isEqualTo("""
                {"id":1,"title":"제목","body":"내용"}
                """.trim());
    }

    @Test
    public void test_ObjectMapper__jsonStrToObj() {
        ArticleDto articleDtoOrigin = new ArticleDto(1, "제목", "내용");
        String jsonStr = Ut.json.toStr(articleDtoOrigin, "");
        ArticleDto articleDtoFromJson = Ut.json.toObj(jsonStr, ArticleDto.class, null);
        assertThat(articleDtoOrigin).isEqualTo(articleDtoFromJson);
    }

}