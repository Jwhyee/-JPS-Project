<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.jspproject.article.dto.ArticleDto" %>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>

<h1>게시물 리스트</h1>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
    </tr>
    <% for ( ArticleDto article : articles ) { %>
    <tr>
        <td><%=article.getId()%></td>
        <td><%=article.getTitle()%></td>
        <td><%=article.getBody()%></td>
    </tr>

    <% } %>
</table>