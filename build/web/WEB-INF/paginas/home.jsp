<%-- 
    Document   : home
    Created on : 05/03/2018, 19:47:08
    Author     : Giovani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        
        <form action="Controller" method="POST">
            Nome da empresa: <input type="text" name="empresa"/>
            <input type="submit" value="cadastrar empresa!"/>
            <input type="hidden" name="tarefa" value="NovaEmpresa">
        </form>
        
        <br>
        
        <form action="Controller" method="GET">
            Buscar Empresa: <input type="text" name="filtro"/>
            <input type="submit" value="buscar empresa!"/>
            <input type="hidden" name="tarefa" value="BuscaEmpresa">
        </form>
        
        <br>
        <br>
        <hr>
        
        <p>Logado como ${usuarioLogado.email} <a href="Controller?tarefa=Logout">(Clique aqui</a> para deslogar)</p>
        
        
        <a href="Controller?tarefa=Logout&metodo=ChamouMetodo">clique aqui para executar a ação com metodo</a>
        
    </body>
</html>
