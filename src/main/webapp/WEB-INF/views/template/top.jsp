<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<%--<c:choose>--%>
<%--    <c:when--%>
<%--            test="${not empty sessionScope.ID && sessionScope.grade == 'A'}">--%>
<%--        <c:set var="str">관리자로 로그인 하셨습니다. ${sessionScope.regionName} 지역 접속 </c:set>--%>
<%--    </c:when>--%>
<%--    <c:when--%>
<%--            test="${not empty sessionScope.ID && sessionScope.grade != 'A'}">--%>
<%--        <c:set var='str'>안녕하세요  ${sessionScope.ID } 님! ${sessionScope.regionName} 지역 접속</c:set>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        <c:set var="str">안녕하세요 방문자님! ${sessionScope.regionName} 지역 접속 </c:set>--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>
<!DOCTYPE html>
<html>
<head>
    <title>HwaHongMmunity</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
    />
</head>
<body>
<!-- 상단 메뉴 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Hongmmunity</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="#">Community</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">고객센터</a>
                </li>

            </ul>
            <form class="d-flex">
                <input class="form-control me-3" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-secondary" type="submit">Search</button>
            </form>
            <div class="d-flex ms-3">
                <button class="btn btn-outline-secondary" type="button" onclick="location.href='/user/login'">Login</button>
            </div>
            <div class="d-flex ms-3">
                <button class="btn btn-link link-secondary" type="button" onclick="location.href='/user/signup'">SignUp</button>
            </div>
        </div>
    </div>
</nav>
</body>
</html>