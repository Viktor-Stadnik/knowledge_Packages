<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>KPacs List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Title</th><th>Description</th><th>Date</th><th>Delete</th></tr>
    <c:forEach var="kpac" items="${list}">
        <tr>
            <td>${kpac.id} </td>
            <td>${kpac.title}</td>
            <td>${kpac.description}</td>
            <td>${kpac.showDate}</td>
            <td><a href="deletekpac/${kpac.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="addkpac">Add New KPac</a>