<%-- 
    Document   : busca
    Created on : 05/03/2018, 19:49:58
    Author     : Giovani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca empresas</title>
    </head>
    <body>
        
        <h1>Resultado da busca: </h1>
        
        <ul>
            <c:forEach var="empresa" items="${empresas}">
                <h2><li> ${empresa.id}: ${empresa.nome}</li></h2>
            </c:forEach>
        </ul>
        
    </body>
</html>
