<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Résultat du formulaire</title>
</head>
<body>
<h1>Informations reçues</h1>

<!-- 1. On instancie le bean Person (ou on le récupère) -->
<jsp:useBean id="personne" class="isep.lab1.bean.Person" scope="request" />

<!-- 2. On associe automatiquement les paramètres du formulaire aux attributs du bean -->
<jsp:setProperty name="personne" property="*" />

<!-- 3. On affiche les valeurs depuis le bean -->
<table border="1" cellpadding="8" style="border-collapse: collapse;">
    <tr>
        <th>Prénom</th>
        <td><jsp:getProperty name="personne" property="firstName" /></td>
    </tr>
    <tr>
        <th>Nom</th>
        <td><jsp:getProperty name="personne" property="lastName" /></td>
    </tr>
    <tr>
        <th>Date de naissance</th>
        <td><jsp:getProperty name="personne" property="birthDay" /></td>
    </tr>
    <tr>
        <th>Sexe</th>
        <td><jsp:getProperty name="personne" property="sex" /></td>
    </tr>
</table>

<br>
<a href="form-jsp.html">Retour au formulaire</a>
</body>
</html>