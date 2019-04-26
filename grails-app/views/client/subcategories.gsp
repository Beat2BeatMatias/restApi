<%--
  Created by IntelliJ IDEA.
  User: mfariasfalki
  Date: 2019-04-25
  Time: 09:32
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Lista de subcategorias</title>
</head>

<body>

<ul>
    <g:if test="${result.children_categories==[]}">
        <script>
           window.onload=function () {prompt("No existen subcategorias","${parametro}")}
        </script>
    </g:if>
    <g:each in= "${result.children_categories}" var="it">
            <li>
                <g:link action="subcategories" id="${it.id}">
                    ${it.name}
                </g:link>
            </li>
    </g:each>
</ul>
</body>
</html>