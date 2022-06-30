<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/resources/css/user_createForm.css">
</head>
<body>
<div class="container-md">
    <section class="vh-80 gradient-custom">
        <form action="${root}/user/signup" method="post" name="signupfrm" id="signupfrm">
            <div class="container py-3 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100 card-width">
                    <div class="col-1 col-md-8 col-lg-6 col-xl-5">
                        <div class="card bg-secondary text-white" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">

                                <div class="mb-md-1 mt-md-4 pb-4">

                                    <h2 class="fw-bold mb-2 text-uppercase">회원가입</h2>
                                    <p class="text-white-50 mb-5">빠짐없이 정보를 기입하세요!</p>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userEmail">Email</label>
                                        <input type="email" id="userEmail" name="userEmail"
                                               class="form-control form-control-lg" placeholder="example@naver.com"
                                               required="required" value=''/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userPassword">Password</label>
                                        <input type="password" id="userPassword" class="form-control form-control-lg"
                                               placeholder="Enter password" name="userPassword" required="required"/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userName">이름</label>
                                        <input type="text" id="userName" class="form-control form-control-lg"
                                               placeholder="이름 입력" name="userName" required="required"/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userStudentId">학번</label>
                                        <input type="text" id="userStudentId" class="form-control form-control-lg"
                                               placeholder="학번 입력" name="userStudentId" required="required"/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <div class="form-label">성별 선택</div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="userGender"
                                                   id="userGender1" value="여자">
                                            <label class="form-check-label" for="userGender1">
                                                여자
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="userGender"
                                                   id="userGender2" value="남자">
                                            <label class="form-check-label" for="userGender2">
                                                남자
                                            </label>

                                        </div>
                                    </div>

                                    <button class="btn btn-outline-light btn-lg px-5" id="signup" type="button">SignUp
                                    </button>

                                    <div class="d-flex justify-content-center text-center mt-4 pt-1">
                                        <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                                        <a href="#!" class="text-white"><i
                                                class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                        <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </section>
</div>

<script type="text/javascript">

    $("#signup").on("click", function () {
        if (!$("#userGender1").is(":checked") && !$("#userGender2").is(":checked")) {
            alert("성별을 선택해주세요.");
            $("#userGender1").focus();
            return;
        }

        document.getElementById('signupfrm').submit();
    });

</script>
</body>
</html>