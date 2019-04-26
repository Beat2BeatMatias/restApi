<%--
  Created by IntelliJ IDEA.
  User: mfariasfalki
  Date: 2019-04-25
  Time: 14:28
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Error</title>
</head>

<body>
<h1>Mensaje de error: <span style="color: darkred">${flash.message}</span></h1>
<g:form action="index" >
    <g:textField name="limite" value=""/>
    <g:submitButton name="Entrar"/>
</g:form>
<g:form action="borrar">
    <g:submitButton name="Borrar"/>
</g:form>
<script type="text/javascript">
    function volverPagina() {
        window.location.replace("http://localhost:8080/client")
    }
</script>
</body>
</html>