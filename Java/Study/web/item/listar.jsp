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
        <div><center><font size="5">Lista dos Produtos</font></center></div>
        <title>TCC E-commerce</title>   
        <hr>
        <br />
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="${pageContext.request.contextPath}/ListarProduto">Adicionar Produto</a>
        <br />
        <br />
        <table align="center" border="1">
            <thead>
                <tr>
                    <th>Codígo Compra:</th>
                    <th>Codígo Item:</th>
                    <th>Codígo Produto:</th>
                    <th>Nome Produto:</th>
                    <th>Preço Produto:</th>
                    <th>Quantidade Pedida:</th>
                    <th>Valor Total:</th>
                    <th colspan="2">Editar</th>
                </tr>    
            </thead>
            <tbody name="carrinho">
                <c:forEach var="item" items="${itens}">
                    <tr>
                        <td>${item.compra.codigoCompra}</td>
                        <td>${item.codigoItem}</td>
                        <td>${item.produto.codigoProduto}</td>
                        <td>${item.produto.nomeProduto}</td>
                        <td>${item.produto.precoProduto}</td>
                        <td>${item.quantidadeItem}</td>
                        <td>${item.valorTotal}</td> 
                        <td><a href="${pageContext.request.contextPath}/PegarItem?iditem=${item.codigoItem}"><center>Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/RemoverItem?iditem=${item.codigoItem}"><center>Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <h2>${response}</h2>
        
    </body>
</html>
