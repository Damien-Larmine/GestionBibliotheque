<%-- 
    Document   : indexlog
    Created on : 17 mars 2016, 11:33:32
    Author     : Damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Page Principale</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="./resources/css/cssLayout.css">
        <link rel="stylesheet" type="text/css" href="./resources/css/default.css">
    </head>
    <body>
        <h1>Bonjour <sec:authentication property="principal.username"/></h1>
        <br/>
        <ul>
        <sec:authorize ifAllGranted="ROLE_ADMIN">
            <li><a href="./utilisateurs.xhtml"> Voir les utilisateurs</a></li>
            <li><a href="./cUtilisateur.xhtml">Ajouter un utilisateur</a></li>
            <li><a href="./cLivre.xhtml">Ajouter un livre</a></li>
        </sec:authorize>
            <li><a href="./listeLivres.xhtml">Voir les livres</a></li>
        </ul>
        <br/>
        <a href="logout" id="deco">Déconnexion</a>
    </body>
</html>
