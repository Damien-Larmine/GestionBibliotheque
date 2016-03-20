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
    </head>
    <body>
        <a href="logout">Déconnexion</a>
        <br>
        Bonjour <sec:authentication property="principal.username"/>
        <br/>
        Vous êtes authentifiés comme :
        <ul>
            <sec:authorize ifAllGranted="ROLE_USER">
                <li> utilisateur simple  </li>
            </sec:authorize>
            <sec:authorize ifAllGranted="ROLE_ADMIN">
                <li> administrateur </li>
            </sec:authorize>
        </ul>
        
        <sec:authorize ifAllGranted="ROLE_ADMIN">
            <a href="./utilisateurs.xhtml"> Voir les utilisateurs</a><br/>
            <a href="./cUtilisateur.xhtml">Ajouter un utilisateur</a><br/>
            <a href="./cLivre.xhtml">Ajouter un livre</a><br/>
        </sec:authorize>
            
            <a href="./listeLivres.xhtml">Voir les livres</a>
        <br/>
    </body>
</html>
