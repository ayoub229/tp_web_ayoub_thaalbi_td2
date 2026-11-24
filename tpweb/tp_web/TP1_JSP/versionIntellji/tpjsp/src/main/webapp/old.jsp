<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Page Senior</title></head>
<body>
<h1>Bienvenue (Né avant 1990)</h1>
<!-- On récupère le bean depuis la requête -->
<jsp:useBean id="personne" class="isep.lab1.bean.Person" scope="request" />

<p>Prénom : <jsp:getProperty name="personne" property="firstName" /></p>
<p>Nom : <jsp:getProperty name="personne" property="lastName" /></p>
</body>
</html>