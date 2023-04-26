<%-- 
    Document   : listar
    Created on : 27/09/2022, 09:58:39
    Author     : Sindicato
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <title>TCC E-commerce</title>   

        <script>
            function onlynumber(evt) {
                var theEvent = evt || window.event;
                var key = theEvent.keyCode || theEvent.which;
                key = String.fromCharCode(key);
                //var regex = /^[0-9.,]+$/;
                var regex = /^[0-9.]+$/;
                if (!regex.test(key)) {
                    theEvent.returnValue = false;
                    if (theEvent.preventDefault) {
                        theEvent.preventDefault();
                    }
                }
            }
        </script>

    </head>
    <body>
        <div><center><font size="5">Lista dos Produtos</font></center></div>
        <title>TCC E-commerce</title>   
        <hr>
        <br />
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="produto/salvar.jsp">Cadastrar Produto</a>
        <br />
        <br />

        <table align="center" border="1">
            <thead>
                <tr>
                    <th>Codígo:</th>
                    <th>Nome:</th>
                    <th>Preço:</th>
                    <th>Estoque:</th>
                    <th colspan="3">Editar</th>
                </tr>    
            </thead>
            <tbody>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <td>${produto.codigoProduto}</td>
                        <td>${produto.nomeProduto}</td>
                        <td>${produto.precoProduto}</td> 
                        <td>${produto.quantidadeEstoque}</td> 
                        <td><a href="${pageContext.request.contextPath}/CarregarProduto?idproduto=${produto.codigoProduto}"><center>Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/ExcluirProduto?idproduto=${produto.codigoProduto}"><center>Excluir</a></td>
                        <td><a href="${pageContext.request.contextPath}/CarregarProdutoItem?idproduto=${produto.codigoProduto}"><center>Adicionar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br />
        <br />
        <br />

        <form name="inseriritem" action="${pageContext.request.contextPath}/InserirItem" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Cod. Compra</td>
                        <td><input type="text" name="codigoC" value="${item.codigoCompra}" size="70" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Cod. Item</td>
                        <td><input type="text" name="codigoI" value="${item.codigoItem}" size="70" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Cod. Produto</td>
                        <td><input type="text" name="codigoP" value="${produto.codigoProduto}" size="70" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Nome Produto</td>
                        <td><input type="text" name="nomeP" value="${produto.nomeProduto}" size="70" required="true" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Preço Produto</td>
                        <td><input type="text" name="precoP" value="${produto.precoProduto}" size="70" required="true" class="form-control" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Quantidade Desejada</td>
                        <td><input type="text" name="quantidadeI" value="${item.quantidadeItem}" size="70" required="true" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Valor Total</td>
                        <td><input type="text" name="valortotal" value="${item.valorTotal}" size="70" required="true" class="form-control" readonly="true"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Enviar" name="enviar" />
        </form>

        <br />
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
