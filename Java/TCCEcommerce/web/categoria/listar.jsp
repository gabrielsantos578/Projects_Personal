<%-- 
    Document   : listar
    Created on : 20/09/2022, 16:47:09
    Author     : Alunos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>TCC E-commerce</title>       
    </head>
    <body>
        <div><center><font size="5">Lista dos Categorias</font></center></div>
        <hr>
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="categoria/salvar.jsp">Cadastrar Categoria</a>
        <br />
        <br />
        <table align="center" border="1">
            <thead>
                <tr>
                    <th>ID:</th>
                    <th>Nome:</th>
                    <th colspan="2">Editar</th>
                </tr>    
           </thead>
           <tbody>
               <c:forEach var="categoria" items="${categorias}">
                   <tr>
                       <td>${categoria.idCategoria}</td>
                       <td>${categoria.nomeCategoria}</td> 
                       <td><a href="${pageContext.request.contextPath}/CarregarCategoria?idcategoria=${categoria.idCategoria}"><center>Alterar</a></td>
                       <td><a href="${pageContext.request.contextPath}/ExcluirCategoria?idcategoria=${categoria.idCategoria}"><center>Excluir</a></td>
                   </tr>
               </c:forEach>
           </tbody>
        </table>
    </body>
</html>
