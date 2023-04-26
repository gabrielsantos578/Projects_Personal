<%-- 
    Document   : salvar
    Created on : 13/09/2022, 14:34:06
    Author     : Alunos
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>TCC E-commerce</title>      
    </head>
    <body>
        <div><center><font size="5">Dados da Marca</font></center></div>
        <hr>
        <br />
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="${pageContext.request.contextPath}/ListarMarca">Listar Marcas</a>
        <br /><br />

        <form name="cadastromarca" action="${pageContext.request.contextPath}/SalvarMarca" method="POST">
            <label>ID: </label>
            <input type="number" value="${marca.idMarca}" id="idmarca" name="idmarca" readonly="readonly" />
            <br />
            <label>Nome: </label>
            <input type="text" value="${marca.nomeMarca}" id="nomemarca" name="nomemarca" required="required" />
            <br /><br />
            <input type="submit" name="salvar" value="Salvar"/>
        </form>
        <br />
        <h3>${response}</h3>
    </body>
</html>
