<%--
  Created by IntelliJ IDEA.
  User: mfariasfalki
  Date: 2019-04-24
  Time: 13:53
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Lista de Sites</title>
</head>

<body>
<ul>
    <g:each in= "${result}" var="it">
        <li>
                ${it.name}
        </li>
    </g:each>
</ul>
</body>
</html>