<%-- 
    Document   : consultar
    Created on : 13/11/2022, 18:33:40
    Author     : Sindicato
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    </head>
    <body>
        <div><center><font size="5">Prequisa Produtos</font></center></div>
        <title>TCC E-commerce</title>
        <hr>
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="produto/salvar.jsp">Cadastrar Produto</a>
        <a href="${pageContext.request.contextPath}/ListarProduto">Listar Produtos</a>
        <br /><br />
        <form name="salvarproduto" action="${pageContext.request.contextPath}/ConsultarProduto" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Condição</td>
                        <td>
                            <select name="condition" id="condition">
                                <option value="">Caso não escolha, será desconsiderado a condição...</option>
                                <option value="codigoProduto">Código do Produto</option>
                                <option value="nomeProduto">Nome do Produto</option>
                                <option value="descricaoProduto">Descrição do Produto</option>
                                <option value="codigoCategoria">Categoria do Produto</option>
                                <option value="codigoMarca">Marca do Produto</option>
                                <option value="loteProduto">Lote do Produto</option>
                                <option value="precoProduto">Preço do Produto</option>
                                <option value="dataFabricacao">Data da Fabricação do Produto</option>
                                <option value="quantidadeEstoque">Quantidade em Estoque do Produto</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Valor</td>
                        <td><input type="text" name="value" size="70" placeholder="Se não houver condição, não é obrigatório."/></td>
                    </tr>
                    <tr>
                        <td>Ordenar por</td>
                        <td>
                            <select name="atributte" id="atributte">
                                <option value="">Caso não escolha, será desconsiderado a ordenação...</option>
                                <option value="codigoProduto">Código do Produto</option>
                                <option value="nomeProduto">Nome do Produto</option>
                                <option value="descricaoProduto">Descrição do Produto</option>
                                <option value="codigoCategoria">Categoria do Produto</option>
                                <option value="codigoMarca">Marca do Produto</option>
                                <option value="loteProduto">Lote do Produto</option>
                                <option value="precoProduto">Preço do Produto</option>
                                <option value="dataFabricacao">Data da Fabricação do Produto</option>
                                <option value="quantidadeEstoque">Quantidade em Estoque do Produto</option>
                            </select>
                            <select name="order" id="order" >
                                <option value="asc">Crescente</option>
                                <option value="desc">Descrecente</option>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Enviar" name="enviar" />
        </form>

        <br /><br /><br />

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

        <br /><br />
        <h2>${response}</h2>
    </body>
</html>
