<%-- 
    Document   : listar
    Created on : 20/09/2022, 11:16:35
    Author     : Sindicato
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
        <div><center><font size="5">Lista das Marcas</font></center></div>
        <hr>
        <br />
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="marca/salvar.jsp">Cadastrar Marca</a>
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
               <c:forEach var="marca" items="${marcas}">
                   <tr>
                       <td>${marca.idMarca}</td>
                       <td>${marca.nomeMarca}</td> 
                       <td><a href="${pageContext.request.contextPath}/CarregarMarca?idmarca=${marca.idMarca}"><center>Alterar</a></td>
                       <td><a href="${pageContext.request.contextPath}/ExcluirMarca?idmarca=${marca.idMarca}"><center>Excluir</a></td>
                   </tr>
               </c:forEach>
           </tbody>
        </table>
    </body>
</html>
