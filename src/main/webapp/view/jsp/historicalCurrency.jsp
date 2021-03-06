<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
    <link href="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" rel="stylesheet">
    <script href="/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js" ></script>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <h2 class="hello-title">Kantor</h2>
    <script src="/js/main.js"></script>
    <div class="row">
         <div class="col">
        <p>Waluta podstawowa: ${currency.base}</p>
        <p>Przedział czasowy:</p>
        <p>Od dnia: <fmt:formatDate value="${currency.start_at}" pattern="dd-MM-YYYY" /></p>
        <p>Do dnia: <fmt:formatDate value="${currency.end_at}" pattern="dd-MM-YYYY" /></p>
        </div>
        <div class="col">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">Data</th>
                        <th scope="col">Dane</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${currency.rates}">
                        <tr>
                            <td>
                                <fmt:formatDate value="${entry.key}" pattern="dd-MM-YYYY" />
                            </td>
                            <td>
                                <table class="table table-dark">
                                    <thead>
                                        <tr>
                                            <th scope="col">Waluta</th>
                                            <th scope="col">Wymiana</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="exchange" items="${entry.value}">
                                            <tr>
                                                <td><c:out value="${exchange.key}"/></td>
                                                <td><c:out value="${exchange.value}"/></td>
                                            </tr>
                                         </c:forEach>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                     </c:forEach>
                </tbody>
             </table>
        </div>
        <div class="col"></div>
    </div>
</body>
</html>