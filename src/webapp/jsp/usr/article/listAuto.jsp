<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>

<script>
    let Articles__listId = 0;
    function Articles__loadMore() {
        $.ajax({
            url : `/usr/article/getArticles/free?fromId=\${Articles__listId}`,
            method: "get",
            dataType: 'json',
            success(responseData) {
                const articles = responseData.data;
                for(const idx in articles){
                    const article = articles[idx];
                    const html = `
                       <li class="flex">
                            <a class="w-[40px] hover:underline hover:text-[red]" href="/usr/article/detail/free/\${article.id}">\${article.id}</a>
                            <a class="flex-grow hover:underline hover:text-[red]" href="/usr/article/detail/free/\${article.id}">\${article.title}</a>
                            <a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="hover:underline hover:text-[red] mr-2" href="/usr/article/delete/free/\${article.id}?_method=DELETE">삭제</a>
                            <a class="hover:underline hover:text-[red]" href="/usr/article/modify/free/\${article.id}">수정</a>
                        </li>
                    `;

                    $('.articles').append(html);
                }
                if (articles.length > 0) {
                    Articles__listId = articles[articles.length - 1].id;
                }

                setTimeout(Articles__loadMore, 3000);
            },
        });
    }
</script>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 리스트(오토)</h1>

        <ul class="articles mt-5">

        </ul>
        <hr>
        <button class="btn btn-sm" onclick="Articles__loadMore();">불러오기</button>
    </div>
</section>
<script>
    Articles__loadMore();
</script>
<%@ include file="../common/foot.jspf"%>