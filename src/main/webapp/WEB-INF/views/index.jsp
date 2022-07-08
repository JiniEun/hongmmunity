<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>HwaHongMmunity</title>
    <meta charset="utf-8">
    <style type="text/css">
        /*.container{
            min-height: 700px;
        }*/
        .space{
            display: flex;
            /*justify-content: space-between;*/
        }
        .img-hwahong-banner{
            min-width: 1200px;
            max-height:200px;
        }
    </style>
</head>
<body>

<div class="container">
    <div align="center">
        <a href="https://hwahong.hs.kr/" target="_blank">
            <img class="img-hwahong" src="/resources/images/hwahong_title.png" width="500px" height="auto"/>
        </a>
    </div>
    <div align="center" class="my-3">
        <a href="https://hwahong.hs.kr/" target="_blank">
            <img class="img-hwahong-banner" src="/resources/images/hwahong_banner.png"/>
        </a>
    </div>
    <div>
        <div class="row">
            <div class="col">
                <div class="row" style="margin: 10px;">
                    <div class="d-flex">
                        <div class="h4 mb-0 mr-2">COVID-19</div>
                    </div>
                </div>
                <div class="row l-covid" style="margin: 10px;">
                    <div class="d-flex">
                        <div class="h5 mb-0 mr-2" id="covid_region">${covid[0]}</div>

                        <div class='h5 mb-0 mr-2' id="covid_total">누적 ${covid[1]}</div>
                        <div class='h5 mb-0 mr-2' id="covid_today">신규 ${covid[2]}</div>
                    </div>
                </div>
            </div>
            <div class="col space">
                <div class="row" style="margin: 10px;">
                    <div class="d-flex">
                        <div class="h4 mb-0 mr-2" style="min-width: 130px;">오늘 급식</div>
                    </div>
                </div>
                <div class="row l-covid" style="margin: 10px;">
                    <div class="d-flex">
                        <div class="h5 mb-0 mr-2"></div>

                        <div class='h5 mb-0 mr-2'><p style="line-height: 2.2;">
                            크림빵(1.2.5.6.13.) <br>
                            달걀훈제(2구)(1.)<br>
                            비타민c젤리(2.5.13.)<br>
                            아침에주스(오렌지맛)(5.13.)<br>
                            도시락김/추가밥(13.)<br>
                            볶음김치(5.9.13.18.)</p></div>
                        <div class='h5 mb-0 mr-2'></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="row" style="margin: 10px;">
                        <div class="d-flex">
                            <div class="h4 mb-0 mr-2">우리동네 미세먼지</div>
                        </div>
                    </div>
                    <div class="row l-covid" style="margin: 10px;">

                            <div class="h4 mb-0 mr-2">경기도</div>

                            <div class='h5 mb-0 mr-2'>
                                오전  <br>
                                좋음 대기상태가 양호해요. <br>
                                <strong>대기환경 정보</strong> <br>
                                <img class="img-dust" src="/resources/images/dust.png" width="400px" height="auto"/>
                            </div>
                            <div class='h5 mb-0 mr-2'>
                                오후  <br>
                                좋음 대기상태가 양호해요.  <br>
                                <strong>대기환경 정보</strong> <br>
                                <img class="img-dust" src="/resources/images/dust.png" width="400px" height="auto"/>
                            </div>

                    </div>
                </div>
                <div class="col space">
                    <div class="row" style="margin: 10px;">
                        <div class="d-flex">
                            <div class="h4 mb-0 mr-2" style="min-width: 130px;">내일 급식</div>
                        </div>
                    </div>
                    <div class="row l-covid" style="margin: 10px;">
                        <div class="d-flex">
                            <div class="h5 mb-0 mr-2"></div>

                            <div class='h5 mb-0 mr-2'><p style="line-height: 2.2;">
                                콘크러스트불고기피자(1.2.5.6.9.10.12.13.15.16.18.)<br>
                                쥬시쿨에이드(사과맛)(2.) <br>
                                오이피클(13.)<br>
                                솜사탕(5.13.)<br>
                                도시락김/추가밥(13.)<br>
                                볶음김치(5.9.13.18.)<br>
                                </p></div>
                            <div class='h5 mb-0 mr-2'></div>
                        </div>
                    </div>
                </div>
        </div>
        <div>
            <img src="">
        </div>

        <div>


        </div>
    </div>
</div>
</body>
</html>