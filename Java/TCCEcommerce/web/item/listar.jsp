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
        <div><center><font size="5">Lista dos Itens</font></center></div>
        <title>TCC E-commerce</title>  
        <hr>
        <br />
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="item/salvar.jsp">Cadastrar Item</a>
        <br />
        <br />
        <table align="center" border="1">
            <thead>
                <tr>
                    <th>Código:</th>
                    <th>Venda:</th>
                    <th>Produto:</th>
                    <th>Preço do Produto:</th>
                    <th>Quantidade:</th>
                    <th>Valor Total:</th>
                    <th colspan="2">Editar</th>
                </tr>    
            </thead>
            <tbody>
                <c:forEach var="item" items="${itens}">
                    <tr>
                        <td>${item.codigoItens}</td>
                        <td>${item.venda.codigoVenda}</td>
                        <td>${item.produto.nomeProduto}</td> 
                        <td>${item.valorProduto}</td> 
                        <td>${item.quantidadeProduto}</td>
                        <td>${item.valorTotal}</td>
                        <td><a href="${pageContext.request.contextPath}/CarregarItem?iditem=${item.codigoItens}"><center>Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/ExcluirItem?iditem=${item.codigoItens}"><center>Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
