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
        <a href="produto/salvar.jsp">Cadastrar Produto</a>
        <a href="produto/consultar.jsp">Consultar Produto</a>
        <br />
        <br />
        <table align="center" border="1">
            <thead>
                <tr>
                    <th>Código:</th>
                    <th>Nome:</th>
                    <th>Preço:</th>
                    <th>Estoque:</th>
                    <th>Descrição:</th>
                    <th>Data Fabricação:</th>
                    <th>Lote:</th>
                    <th>Marca:</th>
                    <th>Categoria:</th>
                    <th colspan="2">Editar</th>
                </tr>    
            </thead>
            <tbody>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <td>${produto.codigoProduto}</td>
                        <td>${produto.nomeProduto}</td>
                        <td>${produto.precoProduto}</td> 
                        <td>${produto.quantidadeEstoque}</td> 
                        <td>${produto.descricaoProduto}</td>
                        <td>${produto.dataFabricacao}</td>
                        <td>${produto.loteProduto}</td> 
                        <td>${produto.marca.nomeMarca}</td> 
                        <td>${produto.categoria.nomeCategoria}</td> 
                        <td><a href="${pageContext.request.contextPath}/CarregarProduto?idproduto=${produto.codigoProduto}"><center>Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/ExcluirProduto?idproduto=${produto.codigoProduto}"><center>Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
