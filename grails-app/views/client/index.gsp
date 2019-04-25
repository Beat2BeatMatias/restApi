<%--
  Created by IntelliJ IDEA.
  User: mfariasfalki
  Date: 2019-04-24
  Time: 11:15
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
            <g:link action="categories" id="${it.id}">
                ${it.name}
            </g:link>
        </li>
    </g:each>
</ul>
</body>
</html>