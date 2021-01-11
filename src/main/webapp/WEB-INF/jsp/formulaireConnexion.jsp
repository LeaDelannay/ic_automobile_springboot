<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Connexion</title>
    <meta charset="UTF-8">
</head>
<body>
<div>
    <form:errors/>
</div>
<h1>CONNEXION</h1>

<form:form servletRelativeAction="/connexion" method="post" modelAttribute="connexionDto" acceptCharset="utf-8">
    <p><label>Email : </label><form:input path="email"/> <form:errors path="email"/></p>
    <p><label>Mot de passe : </label><form:input path="token"/> <form:errors path="token"/></p>
    <button type="submit">Se connecter</button>
</form:form>
</body>
</html>
