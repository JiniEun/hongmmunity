<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script>

    </script>

</head>
<body>
<div class="container my-5">
    <h3>Community</h3>
    <br>
    <form class="form-inline" action="./list">
        <div class="form-group row mx-5 px-5">
            <div class="col col-3">
                <select class="form-control" name="col">
                    <option value="userName"
                            <c:if test="${col=='userName'}"> selected </c:if>
                    >작성자
                    </option>
                    <option value="title"
                            <c:if test="${col=='title'}"> selected </c:if>
                    >제목
                    </option>
                    <option value="content"
                            <c:if test="${col=='content'}"> selected </c:if>
                    >내용
                    </option>
                    <option value="category"
                            <c:if test="${col=='category'}"> selected </c:if>
                    >카테고리
                    </option>
                    <option value="title_content"
                            <c:if test="${col=='title_content'}"> selected</c:if>
                    >제목+내용
                    </option>
                    <option value="total"
                            <c:if test="${col=='total'}"> selected </c:if>
                    >전체출력
                    </option>
                </select>
            </div>
            <div class="col-6">
                <input type="text" class="form-control" placeholder="검색어를 입력하세요" name="word" value="${word}"
                       style="margin-right:10px;">
            </div>
            <div class="col">
                <button type="submit" class="btn btn-outline-dark me-3">검색
                </button>
                <c:choose>
                <c:when test="${not empty sessionScope.userName }">
                <button type="button" class="btn btn-outline-dark"
                        onclick="location.href='../community/create'">등록
                </button>
                </c:when>
                </c:choose>
            </div>
        </div>
    </form>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>번호</th>
            <th>카테고리</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록날짜</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${list}">
            <tr>
                <td>${dto.communityId}</td>
                <td>${dto.category}</td>
                <td>
                    <a href="/community/read/${dto.communityId}" class="text-dark">${dto.title}</a>
                </td>
                <td>${dto.userName}</td>
                <td>${dto.modifiedDate}</td>
                <td>${dto.viewCnt}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div>
        ${paging}
    </div>
</div>
</body>
</html>