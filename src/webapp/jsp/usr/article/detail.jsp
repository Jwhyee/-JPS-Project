<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ll.jspproject.article.dto.ArticleDto" %>

<%
    ArticleDto article = (ArticleDto)request.getAttribute("articles");
%>
<%@ include file="../common/head.jspf"%>
<h1>게시물 상세페이지</h1>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
    </tr>
    <% if(article != null) { %>
    <tr>
        <td><%=article.getId()%></td>
        <td><%=article.getTitle()%></td>
        <td><%=article.getBody()%></td>
    </tr>

    <% } %>
</table>

<%@ include file="../common/foot.jspf"%>