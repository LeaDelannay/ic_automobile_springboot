<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Accueil</title>
  </head>
  <body>
  <h1>ACCUEIL</h1>
    <br>
    <ul>
      <c:forEach var="contrat" items="${listeContrats}">
        <li>
          <c:out value="${contrat.nom}"/>&nbsp;
          <c:out value="${contrat.marge}"/>&nbsp;%.
        </li>
      </c:forEach>
    </ul>
  </body>
</html>
