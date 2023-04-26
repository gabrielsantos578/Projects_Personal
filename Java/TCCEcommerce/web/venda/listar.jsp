<%-- 
    Document   : listar
    Created on : 27/09/2022, 09:58:39
    Author     : Sindicato
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div><center><font size="5">Lista das Vendas</font></center></div>
        <title>TCC E-commerce</title>   
        <hr>
        <br />
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="venda/salvar.jsp">Cadastrar Venda</a>
        <a href="venda/consultar.jsp">Consultar Venda</a>
        <br />
        <br />
        <table align="center" border="1">
            <thead>
                <tr>
                    <th>Código:</th>
                    <th>Nome do Cliente:</th>
                    <th>CPF:</th>
                    <th>Valor Total:</th>
                    <th>Data da Venda:</th>
                    <th colspan="2">Editar</th>
                </tr>    
            </thead>
            <tbody>
                <c:forEach var="venda" items="${vendas}">
                    <tr>
                        <td>${venda.codigoVenda}</td>
                        <td>${venda.nomeCliente}</td>
                        <td>${venda.cpfCliente}</td> 
                        <td>${venda.valorTotal}</td> 
                        <td>${venda.dataVenda}</td>
                        <td><a href="${pageContext.request.contextPath}/CarregarVenda?idvenda=${venda.codigoVenda}"><center>Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/ExcluirVenda?idvenda=${venda.codigoVenda}"><center>Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
