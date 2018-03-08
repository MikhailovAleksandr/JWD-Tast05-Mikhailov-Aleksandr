<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Book_ID</th>
            <th>Author</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Price</th>
        </tr>
 
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td>${book.getID()}</td>
                <td>${book.getAuthor()}</td>
                <td>${book.getTitle()}</td>
                <td>${book.getGenre()}</td>
                <td>${book.getPrice()}</td>
            </tr>
        </c:forEach>
    </table>
 
    <c:if test="${currentPage != 1}">
        <td><a href="Controller?page=${currentPage - 1}">Previous</a></td>
    </c:if>
      
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="Controller?page=${currentPage + 1}">Next</a></td>
    </c:if>
</body>
</html>