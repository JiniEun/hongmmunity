<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/resources/css/community_createForm.css">
    <script type="text/JavaScript">


        function checkIn(f) {
            if (f.title.value == "") {
                alert("제목을 입력하세요");
                f.title.focus()
                return false;
            }

            if (f.content.value == '') {
                alert('내용을 입력해 주세요.');
                f.content.focus();
                return false;
            }

        }
    </script>
</head>
<body>
<div class="container px-3 mx-3 mb-5 py-5 ps-5">
    <h3 class="col-sm-offset-2 col-sm-10">게시글 작성</h3>
    <br>
    <form class="form-horizontal" action="/community/create" method="post" enctype="multipart/form-data"
          onsubmit="return checkIn(this)">

        <div class="form-group my-2">
            <label class="control-label col-sm-2" for="category">카테고리</label>
            <div class="col-sm-2">
                <select class="form-control" name="category" id="category">
                    <option value="수업">수업</option>
                    <option value="진로">진로</option>
                    <option value="분실물">분실물</option>
                </select>
            </div>
        </div>
        <div class="form-group my-1">

            <input type="hidden" name="userEmail" id="userEmail" class="form-control" value="${userEmail}">

            <div class="form-group">
                <label class="control-label col-sm-2" for="title">작성자</label>
                <div class="col-sm-8">
                    <div>${userName}</div>
                    <%--                    <input type="text" name="nickname" id="nickname" class="form-control" value="${nickname}">--%>
                </div>

            </div>
        </div>
        <div class="form-group my-1">
            <label class="control-label col-sm-2" for="title">제목</label>
            <div class="col-sm-8">
                <input type="text" name="title" id="title" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="content">내용</label>
            <div class="col-sm-8">
                <textarea rows="12" cols="7" id="content" name="content" class="form-control"></textarea>
            </div>
        </div>


        <div class="form-group my-3">
            <div class="col-sm-offset-2 col-sm-5">
                <button class="btn btn-outline-dark">등록</button>
                <button type="button" class="btn btn-outline-dark" onclick="history.back()">취소</button>
            </div>
        </div>

    </form>
</div>
</body>
</html>