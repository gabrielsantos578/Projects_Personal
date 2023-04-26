<%-- 
    Document   : salvar
    Created on : 27/09/2022, 09:58:31
    Author     : Sindicato
--%>

<%@page import="java.text.Normalizer"%>
<%@page import="br.com.TCC.Ecommerce.dao.GenericDAO"%>
<%@page import="br.com.TCC.Ecommerce.dao.MarcaDAOImpl"%>
<%@page import="br.com.TCC.Ecommerce.dao.CategoriaDAOImpl"%>
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
        </script>

    </head>
    <body>

        <%
            GenericDAO marcaDAO = new MarcaDAOImpl();
            List<Object> listaMarca = marcaDAO.listar();

            GenericDAO categoriaDAO = new CategoriaDAOImpl();
            List<Object> listaCategoria = categoriaDAO.listar();
        %>

        <div><center><font size="5">Dados do Produto</font></center></div>
        <hr>
        <a href="${pageContext.request.contextPath}/index.html">P�gina Inicial</a>
        <a href="${pageContext.request.contextPath}/ListarProduto">Listar Produtos</a>
        <a href="produto/consultar.jsp">Consultar Produto</a>
        <br /><br />
        <form name="salvarproduto" action="${pageContext.request.contextPath}/SalvarProduto" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Cod. Produto</td>
                        <td><input type="text" name="codigo" value="${produto.codigoProduto}" size="70" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Nome</td>
                        <td><input type="text" name="nome" value="${produto.nomeProduto}" size="70" required="true"/></td>
                    </tr>
                    <tr>
                        <td>Pre�o</td>
                        <td><input type="text" name="preco" value="${produto.precoProduto}" size="70" required="true" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Quantidade Estoque</td>
                        <td><input type="text" name="quantidade" value="${produto.quantidadeEstoque}" size="70" required="true" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Descricao</td>
                        <td><input type="text" name="descricao" value="${produto.descricaoProduto}" size="70" required="true"/></td>
                    </tr>
                    <tr>
                        <td>Data Fabrica��o</td>
                        <td><input type="text" name="data" size="70" value="${produto.dataFabricacao}" required="true" maxlength="8" class="form-control" onkeypress="$(this).mask('00/00/0000')" onkeypress="return onlynumber();"/></td>
                    </tr>
                    <tr>
                        <td>Lote</td>
                        <td><input type="text" name="lote" size="70" value="${produto.loteProduto}" required="true" maxlength="12"/></td>
                    </tr>
                    <tr>
                        <td>Marca</td>
                        <td>
                            <select name="marca" id="marca" required="true">
                                <option value="${produto.marca.idMarca}">${produto.marca.nomeMarca}</option>
                                <c:forEach items="<%=listaMarca%>" var="marca">
                                    <option value="${marca.idMarca}">${marca.nomeMarca}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Categoria</td>
                        <td>
                            <select name="categoria" id="categoria" required="true">
                                <option value="${produto.categoria.idCategoria}">${produto.categoria.nomeCategoria}</option>
                                <c:forEach items="<%=listaCategoria%>" var="categoria">
                                    <option value="${categoria.idCategoria}">${categoria.nomeCategoria}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Enviar" name="enviar" />
        </form>
        <h2>${response}</h2>
    </body>
</html>
