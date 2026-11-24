<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Page Junior</title></head>
<body>
<h1>Bienvenue (Né après 1990)</h1>
<jsp:useBean id="personne" class="isep.lab1.bean.Person" scope="request" />

<p>Prénom : <jsp:getProperty name="personne" property="firstName" /></p>
<p>Nom : <jsp:getProperty name="personne" property="lastName" /></p>
</body>
</html>