<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%--    <link rel="stylesheet" href="/webapp/resources/css/bottom.css">--%>
</head>
<style type="text/css">
    footer {
        min-height: 100px;
    }
</style>
<body>
<footer class="container-fluid navbar-fixed-bottom body-bottom-color py-3"
        style="text-align: center;">
    <!--container-fluid navbar-fixed-bottom">  sticky-footer-->
    <hr style="margin-top: 0px;" class=""/>
    <div class="container l-bottom mt-3">
        <div class="m-0 p-0">@ 2022 All Rights Reserved By EunHong</div>
        <div class="l-help-bottom txt-title-help my-3">
            고객센터&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
            <a class="link-help-bottom"
               href="${root}/notice/list">공지사항</a>
            <a class="link-help-bottom" href="${root}/user/privacy">Privacy</a>

        </div>
    </div>
</footer>
</body>
</html>