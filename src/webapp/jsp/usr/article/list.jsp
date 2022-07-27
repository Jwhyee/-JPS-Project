<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.jspproject.article.dto.ArticleDto" %>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>
<%@ include file="../common/head.jspf"%>
<style>
    td{
        text-align: center;
        width : 100px;
    }
</style>
<h1>게시물 리스트</h1>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>삭제</th>
        <th>수정</th>
    </tr>
    <% for ( ArticleDto article : articles ) { %>
    <tr>
        <td><a href="/usr/article/detail/free/<%=article.getId()%>"><%=article.getId()%></a></td>
        <td><a href="/usr/article/detail/free/<%=article.getId()%>"><%=article.getTitle()%></a></td>
        <td><a href="/usr/article/detail/free/<%=article.getId()%>"><%=article.getBody()%></a></td>
        <td style="width: 50px"><a href="/usr/article/delete/free/<%=article.getId()%>">삭제</a></td>
        <td style="width: 50px"><a href="/usr/article/update/free/<%=article.getId()%>">수정</a></td>
    </tr>

    <% } %>
</table>
<%@ include file="../common/foot.jspf"%>