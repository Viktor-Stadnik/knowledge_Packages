<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Sets</h1>
<form:form method="post" action="saveSet">
  <table >
    <tr>
      <td>Title : </td>
      <td><form:input path="title"  /></td>
    </tr>
    <tr>
      <td> </td>
      <td><input type="submit" value="Save" /></td>
    </tr>
  </table>
</form:form>
