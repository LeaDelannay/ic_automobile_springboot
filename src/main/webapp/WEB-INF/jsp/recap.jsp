<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Récapitulatif</title>
</head>
<body>
    <h1>Récapitulatif</h1>
    <br>
    <p>Votre contrat : <c:out value="${contrat.nom}"/></p>
    <p>Votre marge : <c:out value="${contrat.marge}"/>%</p>
    <p>Votre TVA : <c:out value="${tva}"/>%</p>
    <ul>
        <c:forEach var="article" items="${articles}">
            <li>
                <c:out value="${article.nom}"/>&nbsp;
                <c:out value="${article.montant}"/>&nbsp;€.
            </li>
        </c:forEach>
    </ul>
</body>
</html>
