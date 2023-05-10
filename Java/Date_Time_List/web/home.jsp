<%-- 
    Document   : home
    Created on : 05/05/2023, 16:29:04
    Author     : Aluno
--%>

<%@page import="model.ListObject"%>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <%

            String usuario = (String) session.getAttribute("usuario");

            if (usuario == null) {
                response.sendRedirect("login.jsp");
            } else {
                out.print("Bem-vindo " + usuario + ".<br/>");

                long toS = session.getMaxInactiveInterval() - (System.currentTimeMillis() - session.getLastAccessedTime()) / 1000;
                long toM = TimeUnit.SECONDS.toMinutes(toS);
                out.print("Tempo: " + toM + ". <br/><br/>");

                List<ListObject> Alunos = (ArrayList) session.getAttribute("alunos");
                for (int i = 0; i < 3; i++) {
                    out.println("Objecto " + i + ": " + Alunos.get(i).getObjectTest() + ".<br/>");
                }
                out.println("<br/><br/>");

                LocalDateTime ldt = LocalDateTime.now();
                out.println("LocalDateTime: " + ldt + ".<br/>");
                Date d = new Date();
                out.println("Date: " + d + ".<br/>");

                out.println("<br/>");

                String testldt = String.valueOf(ldt);
                out.println("String: " + testldt + ".<br/>");
                String testd = String.valueOf(d);
                out.println("String: " + testd + ".<br/>");

                out.println("<br/>");

                String date = String.valueOf(ldt);
                date = date.substring(0, 10);
                
                String ano = date.substring(0, 4);
                String mes = date.substring(5, 7);
                String dia = date.substring(8, 10);
                date = dia + "/" + mes + "/" + ano;
                
                String time = String.valueOf(ldt);
                time = time.substring(11, 19);

                out.println("Data: " + date + ".<br/>");
                out.println("Horário: " + time + ".<br/>");

            }

        %>

        <br/><br/><br/>
        <form name="teste" action="${pageContext.request.contextPath}/Salvar" method="POST">
            <input type="submit" name="salvar" value="Testar"/>
        </form>

        <br/> <h2>${responseDT}</h2>
        <br/> <h2>${responseLO}</h2>
        <br/>
        <br/> <a href="logout.jsp">Deslogar</a>

    </body>
</html>
