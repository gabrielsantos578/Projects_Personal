<%-- 
    Document   : login
    Created on : 05/05/2023, 16:29:18
    Author     : Aluno
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ListObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        <form action="login.jsp" method="post">
            
            Usuário:<br/> <input type="text" name="usuario" /><br/>
            Senha:<br/> <input type="password" name="senha" /><br/>
            <input type="submit" value="Logar" />
            
        </form>
        
        <%
            
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            
            if (usuario != null && senha != null && !usuario.isEmpty() && !senha.isEmpty()) {
                session.setAttribute("usuario", usuario);
                session.setMaxInactiveInterval(1800);
                
                ListObject lo1 = new ListObject();
                lo1.setObjectTest("Guilherme");
                ListObject lo2 = new ListObject();
                lo2.setObjectTest("Ana");
                ListObject lo3 = new ListObject();
                lo3.setObjectTest("Thaysa");
                
                List<ListObject> Alunos = new ArrayList();
                Alunos.add(lo1);Alunos.add(lo2);Alunos.add(lo3);
                
                session.setAttribute("alunos", Alunos);
                
                response.sendRedirect("home.jsp");
            }
            
        %>
        
    </body>
</html>