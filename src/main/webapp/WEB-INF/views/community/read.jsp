<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/static/css/market.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<title>조회</title>
<meta charset="utf-8">

<script type="text/javascript">
	function deleteC() {
		var url = "/community/delete";
		url += "?communityId=${dto.communityId}";
		location.href = url;
	}

	function updateC() {
		var url = "/community/update";
		url += "?communityId=${dto.communityId}";
		location.href = url;
	}
</script>

</head>
<body>
	<div class="container-lg my-5 py-4 mx-5">

		<h2 style="margin-bottom: 20px;">Community</h2>

		<div class="card card-default">
			<div class="card-header bg-transparent" style="font-size: 20px;">
				<input type="hidden" id="communityId" name="communityId" value="${dto.communityId}">
			<span>[${dto.category}]</span>&nbsp<span>${dto.title}</span>
			
			</div>

			<ul class="list-group list-group-flush">
				<li class="list-group-item" style="color:#808088">
						<i class="fas fa-user"></i>&nbsp<span class="card-text">${dto.userName}</span>
<%--						<p class="card-text"><small class="text-muted">${dto.rdate}</small>--%>
				</li>
				<li class="list-group-item" style="min-height: 300px;">
					
					<p class="card-text">${dto.content }</p>
				</li>
			</ul>

			<div class="card-footer bg-transparent">				
				<p class="card-text">
					조회수 <small class="text-muted">${dto.viewCnt}</small>
			</div>
		</div>
		<br>

<%--		<!-- reply -->--%>
<%--		<form name="replyForm">--%>
<%--			<section class="reply">--%>
<%--				<input type="hidden" name="communityId" value="${dto.communityId}" /> <input--%>
<%--					type="hidden" name="userNAme" value="${dto.userName}" /> <input--%>
<%--					type="text" class="form-control" id="content" name="content"--%>
<%--					placeholder="내용을 입력하세요.">--%>
<%--				<button class="rebtn" id="rebtn" name="rebtn">댓글 등록</button>--%>
<%--			</section>--%>

<%--			<section class="reshow">--%>
<%--				<div class="replyList"></div>--%>
<%--			</section>--%>

<%--			<section class="repaging">--%>
<%--				<span>${paging}</span>--%>
<%--			</section>--%>
<%--		</form>--%>

<%--		<%@ include file="reply.jsp"%>--%>
		<br>

		<div>
 			<c:choose>
         		<c:when test="${sessionScope.userName==dto.userName}">

					<button type="button" class="btn btn-outline-dark" onclick="updateC()">수정</button>
					<button type="button" class="btn btn-outline-dark" onclick="deleteC()">삭제</button>
					<button type="button" class="btn btn-outline-dark" onclick="location.href='${root}/community/list'">목록</button>
			 	</c:when>
         		<c:otherwise>
         			<button type="button" class="btn btn-color" onclick="location.href='${root}/community/list'">목록</button>
         		</c:otherwise>
       		</c:choose>
         		
         		
		</div>
	</div>
</body>
</html>