<%-- 
    Document   : listar
    Created on : 27/01/2023, 00:49:00
    Author     : Sindicato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Website</title>   
    </head>
    <body>
        <div><center><font size="5">Lista dos Usuários</font></center></div>  
        <hr>
        <br />
        <a href="${pageContext.request.contextPath}/ADM/Index.jsp">Página Inicial</a>
        <a href="Salvar.jsp">Cadastrar Usuário</a>
        <a href="Consultar.jsp">Consultar Usuários</a>
        <br />
        <br />
        <table align="center" border="1">
            <thead>
                <tr>
                    <th>Codígo:</th>
                    <th>Nome:</th>
                    <th>E-mail:</th>
                    <th>Senha:</th>
                    <th colspan="2">Editar</th>
                </tr>    
            </thead>
            <tbody>
                <c:forEach var="usuario" items="${usuarios}">
                    <tr>
                        <td>${usuario.codigoUsuario}</td>
                        <td>${usuario.nomeUsuario}</td>
                        <td>${usuario.emailUsuario}</td> 
                        <td>${usuario.senhaEstoque}</td> 
                        <td><a href="${pageContext.request.contextPath}/LoadUser?idusuario=${usuario.codigoUsuario}"><center>Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/DeleteUser?idusuario=${usuario.codigoUsuario}"><center>Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
