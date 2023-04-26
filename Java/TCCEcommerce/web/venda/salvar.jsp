<%-- 
    Document   : salvar
    Created on : 27/09/2022, 09:58:31
    Author     : Sindicato
--%>

<%@page import="br.com.TCC.Ecommerce.dao.ProdutoDAOImpl"%>
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
            GenericDAO produtoDAO = new ProdutoDAOImpl();
            List<Object> listaProduto = produtoDAO.listar();
        %>

        <div><center><font size="5">Dados da Venda</font></center></div>
        <hr>
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <a href="${pageContext.request.contextPath}/ListarVenda">Listar Vendas</a>
        <a href="venda/consultar.jsp">Consultar Venda</a>
        <br /><br />
        <form name="salvarvenda" action="${pageContext.request.contextPath}/SalvarVenda" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Cod. Venda</td>
                        <td><input type="text" name="codigo" value="${venda.codigoVenda}" size="70" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Nome Cliente</td>
                        <td><input type="text" name="nome" value="${venda.nomeCliente}" size="70" /></td>
                    </tr>
                    <tr>
                        <td>CPF Cliente</td>
                        <td><input type="text" name="cpf" value="${venda.cpfCliente}" size="70" required="true" maxlength="11" onkeypress="$(this).mask('000.000.000-00')" class="form-control" onkeypress="return onlynumber();"/></td>
                    </tr>
                    <tr>
                        <td>Data da Venda</td>
                        <td><input type="text" name="data" value="${venda.dataVenda}" size="70" required="true" maxlength="8" class="form-control" onkeypress="$(this).mask('00/00/0000')" onkeypress="return onlynumber();"/></td>
                    </tr>
                    <tr>
                        <td>Valor Total</td>
                        <td><input type="text" name="valor" value="${venda.valorTotal}" size="70" class="form-control" onkeypress="return onlynumber();"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Enviar" name="enviar" />
        </form>
        <h2>${response}</h2>
    </body>
</html>
