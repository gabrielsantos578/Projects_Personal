<%-- 
    Document   : Index
    Created on : 27/01/2023, 00:42:10
    Author     : Sindicato
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Website</title>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><center><font size="100">Website Administration:</font></center></div>
        <hr>
        
        <div><center><font size="4">Menu de Opções</font></center></div>
        
        <h3>Página de Testes</h3>
        <a href="">DEFAULT</a>
        <br />
        
        <h3>Usuário</h3>
        <a href="Usuario/Salvar.jsp">Cadastrar</a>
        <a href="${pageContext.request.contextPath}/ListUser">Listar Usuários</a>
        <a href="Usuario/Consultar.jsp">Consultar</a>
        <br />
        
        <h3>Cliente</h3>
        <a href="Cliente/Salvar.jsp">Cadastrar</a>
        <a href="${pageContext.request.contextPath}/ListUser">Listar Usuários</a>
        <a href="Cliente/Consultar.jsp">Consultar</a>
        <br />
        
    </body>
</html>
