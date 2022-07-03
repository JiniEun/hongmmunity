<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>삭제</title>
<meta charset="utf-8">
<style type="text/css">
#red {
  color: red;
}

.form-group button{
	background-color: #5BA6A6;
    color : white;
    border : 3px solid white;
    border-radius: 10%;
    }
    
 h2{
 	color : #5BA6A6;
 }

}
</style>
</head>
<body>
  <div class="container" style="margin-top : 100px;">

    <h2 class="col-sm-offset-2 col-sm-10">작성한 글을 삭제하겠습니까?</h2>
    <form class="form-horizontal" 
    	action="/community/delete" 
    	method="post">
      
      
      <input type="hidden" name="cid" value="${dto.cid}">
	  <input type="hidden" name="id" value="${dto.id}">

      <p id="red" class="col-sm-offset-2 col-sm-6">삭제하면 복구할 수 없습니다</p>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-5">
          <button type="submit" class="btn btn-default" >삭제</button>
          <button type="button" class="btn btn-default" onclick="history.back()">취소</button>
        </div>
      </div>
    </form>

  </div>
</body>
</html>