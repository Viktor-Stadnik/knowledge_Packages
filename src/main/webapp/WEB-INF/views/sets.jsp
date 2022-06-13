<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Sets List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Title</th><th>Delete</th></tr>
    <c:forEach var="kpacSet" items="${listSet}">
        <tr>
            <td>${kpacSet.id}</td>
            <td>${kpacSet.title}</td>
            <td><a href="deletesets/${kpacSet.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="addsets">Add New Set</a>