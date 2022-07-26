package com.ll.jspproject.article;

public class ArticleService {
    public long write(String title, String body) {
        private ArticleRepository memberRepository;
        public ArticleService(){
            memberRepository = new ArticleRepository();
        }
        memberRepository.wirte(title, body);
    }
}
