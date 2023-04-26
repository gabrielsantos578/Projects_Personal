<%-- 
    Document   : salvar
    Created on : 27/09/2022, 09:58:31
    Author     : Sindicato
--%>

<%@page import="java.text.Normalizer"%>
<%@page import="br.com.TCC.Ecommerce.dao.GenericDAO"%>
<%@page import="br.com.TCC.Ecommerce.dao.VendaDAOImpl"%>
<%@page import="br.com.TCC.Ecommerce.dao.ProdutoDAOImpl"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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

            function Double preco() {
            if (${item.produto.precoProduto} < > null) {
            return ${item.produto.precoProduto};
            } else if (${prod.precoProduto} < > null) {
            return ${prod.precoProduto};
            } else {
            return 0;
            }
            }
        </script>

    </head>
    <body>

        <%
            GenericDAO vendaDAO = new VendaDAOImpl();
            List<Object> listaVenda = vendaDAO.listar();

            GenericDAO produtoDAO = new ProdutoDAOImpl();
            List<Object> listaProduto = produtoDAO.listar();
        %>

        <div><center><font size="5">Dados do Item</font></center></div>
        <hr>
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="${pageContext.request.contextPath}/ListarItem">Listar Itens</a>
        <br /><br />
        <form name="salvaritem" action="${pageContext.request.contextPath}/SalvarItem" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Cod. Item</td>
                        <td><input type="text" name="codigo" value="${item.codigoItens}" size="70" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Venda</td>
                        <td>
                            <select name="venda" id="venda" >
                                <option value="${item.venda.codigoVenda}">${item.venda.codigoVenda}</option>
                                <c:forEach items="<%=listaVenda%>" var="venda">
                                    <option value="${venda.codigoVenda}">Venda ${venda.codigoVenda} para ${venda.nomeCliente}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Produto</td>
                        <td>
                            <select name="produto" id="produto" required="true">
                                <option value="${item.produto.codigoProduto}">${item.produto.nomeProduto}</option>
                                <c:forEach items="<%=listaProduto%>" var="produto">
                                    <option value="${produto.codigoProduto}">${produto.nomeProduto}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Preço do Produto</td>
                        <td><input type="text" name="preco"  value="${item.produto.precoProduto}" size="70" class="form-control" readonly="true" /></td>
                    </tr>
                    <tr>
                        <td>Quantidade Total</td>
                        <td><input type="text" name="quantidade" value="${item.quantidadeProduto}" size="70" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Valor Total</td>
                        <td><input type="text" name="valor" value="${item.valorTotal}" size="70" class="form-control" readonly="true"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Enviar" name="enviar" />
        </form>
        <h2>${response}</h2>
        <h2>${alert}</h2>
    </body>
</html>
