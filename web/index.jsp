<%@ page import="vvv.Article" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="vvv.ArticleServlet" %>
<%@ page import="vvv.AddUserServlet" %>
<%@ page import="vvv.SortingServlet" %><%--
<%--
  Created by IntelliJ IDEA.
  User: volodko
  Date: 26.11.18
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/styles/reset.css">
    <link rel="stylesheet" type="text/css" href="/styles/styles.css">
    <title>Nice Blog</title>
</head>
<body>
<div id="header" class="title">
    <div id="problog_title">
        <a href="/index.jsp"><p> Nice BLOG </p></a>
    </div>
    <div id="image_title">
        <img src="/images/java.png" alt="java">
    </div>
</div>
<div id="navi" class="navi">
    <div id="my_cabinet">
        <a href="/my_cabinet"><p>My cabinet</p></a>
    </div>
    <div id="search">
        <a href="/search"><p>Searching articles</p></a>
    </div>
    <div id="sort">
        <a href="/sort"><p>Sorting articles</p></a>
    </div>
    <div id="registration">
        <a href="/registration"><p>Login/Registration</p></a>
    </div>
</div>
<fieldset>
    <div id="content">
        <div id="article">
            <%Article art = new Article();%>
            <%ArticleServlet as = new ArticleServlet();%>
            <%AddUserServlet aus = new AddUserServlet();%>
            <%SortingServlet ss = new SortingServlet();%>
            <%ss.sortByDate();%>
            <%if (as.getArticles().size() == 0) {%>
            <%for (Article temp : as.getArticlesFromFile()) {%>
            <br>
            <h3 class="word"><%=temp.getContent()%>
            </h3><br><%=temp.getUserName()%><br><%=temp.getDate()%><br><br><br>
            <%}%>
            <%} else {%>
            <%for (Article temp : as.getArticles()) {%>
            <br>
            <h3 class="word"><%=temp.getContent()%>
            </h3><br><%=temp.getUserName()%><br><%=temp.getDate()%><br><br><br>
            <%}%>
            <%}%>
            <%if (aus.getUsers().isEmpty()) {%>
            <%aus.getUsersFromFile();%>
            <%}%>
        </div>
    </div>
</fieldset>
</body>
</html>
