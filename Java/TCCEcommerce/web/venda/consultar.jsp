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
        <div><center><font size="5">Prequisa Vendas</font></center></div>
        <title>TCC E-commerce</title>
        <hr>
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="venda/salvar.jsp">Cadastrar Venda</a>
        <a href="${pageContext.request.contextPath}/ListarVenda">Listar Vendas</a>
        <br /><br />
        <form name="salvarvenda" action="${pageContext.request.contextPath}/ConsultarVenda" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Condição</td>
                        <td>
                            <select name="condition" id="condition">
                                <option value="">Caso não escolha, será desconsiderado a condição...</option>
                                <option value="codigoVenda">Código da Venda</option>
                                <option value="nomeCliente">Nome do Cliente</option>
                                <option value="cpfCliente">CPF do Cliente</option>
                                <option value="dataVenda">Data da Venda</option>
                                <option value="valorFinal">Valor da Venda</option>
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
                                <option value="codigoVenda">Código da Venda</option>
                                <option value="nomeCliente">Nome do Cliente</option>
                                <option value="cpfCliente">CPF do Cliente</option>
                                <option value="dataVenda">Data da Venda</option>
                                <option value="valorFinal">Valor da Venda</option>
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
                    <th>Código Venda:</th>
                    <th>Nome Cliente:</th>
                    <th>CPF:</th>
                    <th>Data Venda:</th>
                    <th>Total:</th>
                    <th colspan="2">Editar</th>
                </tr>    
            </thead>
            <tbody>
                <c:forEach var="venda" items="${vendas}">
                    <tr>
                        <td>${venda.codigoVenda}</td>
                        <td>${venda.nomeCliente}</td>
                        <td>${venda.cpfCliente}</td> 
                        <td>${venda.dataVenda}</td> 
                        <td>${venda.valorTotal}</td>
                        <td><a href="${pageContext.request.contextPath}/CarregarVenda?idvenda=${venda.codigoVenda}"><center>Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/ExcluirVenda?idvenda=${venda.codigoVenda}"><center>Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br /><br />

        <table align="center" border="1">
            <thead>
                <tr>
                    <th>Código Item:</th>
                    <th>Nome Cliente:</th>
                    <th>Código Venda:</th>
                    <th>Código Produto:</th>
                    <th>Nome Produto:</th>
                    <th>Preço:</th>
                    <th>Quantidade:</th>
                    <th>Valor:</th>
                    <th colspan="2">Editar</th>
                </tr>    
            </thead>
            <tbody>
                <c:forEach var="item" items="${itens}">
                    <tr>
                        <td>${item.codigoItens}</td>
                        <td>${item.venda.nomeCliente}</td>
                        <td>${item.venda.codigoVenda}</td>
                        <td>${item.produto.codigoProduto}</td>
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

        <br /><br />
        <h2>${response}</h2>
    </body>
</html>
