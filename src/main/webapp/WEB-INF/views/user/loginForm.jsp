<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/resources/css/user_loginForm.css">
</head>
<body>
<div class="container-md">
    <section class="vh-100 gradient-custom">
        <form action="${root}/user/login" method="post">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card bg-secondary text-white" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">

                                <div class="mb-md-5 mt-md-4 pb-5">

                                    <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                                    <p class="text-white-50 mb-5">이메일과 비밀번호를 입력하세요!</p>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userEmail">Email</label>
                                        <input type="email" id="userEmail" name="userEmail" class="form-control form-control-lg" placeholder="example@naver.com" required="required" value=''/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="userPassword">Password</label>
                                        <input type="password" id="userPassword" class="form-control form-control-lg" placeholder="Enter password" name="userPassword"/>
                                    </div>
                                    <div class="checkbox">
                                        <label> <input type="checkbox" name="c_id" value="Y"
                                                       checked="checked"> Remember ID
                                        </label>
                                    </div>
                                    <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot
                                        password?</a>
                                    </p>

                                    <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>

                                    <div class="d-flex justify-content-center text-center mt-4 pt-1">
                                        <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                                        <a href="#!" class="text-white"><i
                                                class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                        <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                                    </div>

                                </div>

                                <div>
                                    <p class="mb-0">Don't have an account? <a href="/user/signup" class="text-white-50 fw-bold">Sign
                                        Up</a>
                                    </p>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </section>
</div>
</body>
</html>