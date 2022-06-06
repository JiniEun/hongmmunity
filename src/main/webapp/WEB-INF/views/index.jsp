<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hongmmunity</title>
    <meta charset="utf-8">
    <script>

    </script>
</head>
<body>

<div>Hello, Spring Boot App</div>
<div class="row l-covid" style="margin: 10px;">
    <div class="d-flex">
        <div class="h4 mb-0 mr-2">COVID-19</div>

        <div class="h5 mb-0 mr-2" id="covid_region">${covid[0]}</div>

        <div class='h5 mb-0 mr-2' id="covid_total">누적 ${covid[1]}</div>
        <div class='h5 mb-0 mr-2' id="covid_today">신규 ${covid[2]}</div>
    </div>
</div>
</body>
</html>