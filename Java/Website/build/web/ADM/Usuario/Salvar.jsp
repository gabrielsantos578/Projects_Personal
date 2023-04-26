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
        
        <div><center><font size="5">Registro de Usuário</font></center></div>
        <hr>
        <a href="${pageContext.request.contextPath}/ADM/Index.jsp">Página Inicial</a>
        <a href="${pageContext.request.contextPath}/ListUser">Listar Usuários</a>
        <a href="Consultar.jsp">Consultar Usuários</a>
        <br /><br />
        <form name="saveuser" action="${pageContext.request.contextPath}/SaveUser" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Cod. Usuário</td>
                        <td><input type="text" name="codigo" value="${usuario.idUsuario}" size="70" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Nome Usuário</td>
                        <td><input type="text" name="nome" value="${usuario.nomeUsuario}" size="70" required="true"/></td>
                    </tr>
                    <tr>
                        <td>E-mail Usuário</td>
                        <td><input type="text" name="email" value="${usuario.emailUsuario}" size="70" required="true" /></td>
                    </tr>
                    <tr>
                        <td>Senha Usuário</td>
                        <td><input type="password" name="senha" value="${usuario.senhaUsuario}" size="70" required="true" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Registrar" name="registrar" />
        </form>
        <h2>${response}</h2>
        
    </body>
</html>
