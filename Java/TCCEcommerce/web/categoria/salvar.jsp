<%-- 
    Document   : salvar
    Created on : 20/09/2022, 15:55:02
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
        <div><center><font size="5">Dados do Categoria</font></center></div>
        <hr>
        <br />
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="${pageContext.request.contextPath}/ListarCategoria">Listar Categorias</a>
        <br /><br />

        <form name="cadastrocategoria" action="${pageContext.request.contextPath}/SalvarCategoria" method="POST">
            <label>ID: </label>
            <input type="number" value="${categoria.idCategoria}" id="idcategoria" name="idcategoria" readonly="readonly" />
            <br />
            <label>Nome: </label>
            <input type="text" value="${categoria.nomeCategoria}" id="nomecategoria" name="nomecategoria" required="required" />
            <br /><br />
            <input type="submit" name="salvar" value="Salvar"/>
        </form>
        <br />
        <h3>${response}</h3>
    </body>
</html>