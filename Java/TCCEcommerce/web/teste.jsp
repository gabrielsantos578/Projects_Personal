<%-- 
    Document   : teste
    Created on : 12/10/2022, 16:30:01
    Author     : Sindicato
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <title>Página para Testes</title>   
        
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
        <div><center><font size="5">Dados a Validar</font></center></div>
        <hr>
        <br />
        <a href="${pageContext.request.contextPath}/index.html">Página Inicial</a>
        <br /><br />

        <form name="valida" action="${pageContext.request.contextPath}/TesteController" method="POST">
            <label>Data: </label>
            <input type="text" name="dadoData" size="50" required="true" maxlength="8" class="form-control" onkeypress="$(this).mask('00/00/0000')" onkeypress="return onlynumber();"/>
            <br />
            <label>Preço: </label>
            <input type="text" name="dadoPreco" size="50" required="true" maxlength="8" class="form-control" onkeypress="$(this).mask('99.990,00', {reverse: true})" onkeypress="return onlynumber();"/>
            <br />
            <label>Quantidade: </label>
            <input type="text" name="dadoQuantidade" size="50" required="true" maxlength="8" class="form-control" onkeypress="$(this).mask('99.990,00', {reverse: true})" onkeypress="return onlynumber();"/>
            <br /><br />
            <input type="submit" name="salvar" value="Salvar"/>
        </form>
        <br />
        <h3>${responseData}</h3>
    </body>
</html>
