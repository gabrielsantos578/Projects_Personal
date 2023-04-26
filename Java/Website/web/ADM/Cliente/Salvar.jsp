<%-- 
    Document   : salvar
    Created on : 27/01/2023, 00:42:30
    Author     : Sindicato
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Website</title>
    </head>
    <body>
        
        <div><center><font size="5">Dados do Produto</font></center></div>
        <hr>
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
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
                        <td>Preço</td>
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
                        <td>Data Fabricação</td>
                        <td><input type="text" name="data" size="70" value="${produto.dataFabricacao}" required="true" maxlength="8" class="form-control" onkeypress="$(this).mask('00/00/0000')" onkeypress="return onlynumber();"/></td>
                    </tr>
                    <tr>
                        <td>Lote</td>
                        <td><input type="text" name="lote" size="70" value="${produto.loteProduto}" required="true" maxlength="12"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Enviar" name="enviar" />
        </form>
        <h2>${response}</h2>
        
    </body>
</html>
