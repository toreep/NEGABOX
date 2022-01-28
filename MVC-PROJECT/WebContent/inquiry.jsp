<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ page import="java.util.Date" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
    <%
String likeId = request.getParameter("id");
String loginId = (String)(session.getAttribute("member_id"));
String name = (String)(session.getAttribute("name"));
Date today = new Date();
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
String todate = format.format(today);
%>
<!DOCTYPE html>
<html>

<head>
	<link rel="shortcut icon" href="./image/megabox_logo.ico">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MEET PLAY SHARE, 메가박스</title>
	<link href='css/header_footer.css?aa' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="./css/inquiry.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(function(){
		$('#exitButton').on("click",function(){
			$(this).parents(".background").toggleClass('on');
		});
		
		$('#loginBox').on("click",function(){
			$(".background").toggleClass('on');
		});
		
		$('#movelogin').on("click",function(){
			$(".layer-mynega").removeClass("on");
			$(".background").addClass('on');
			$(".mymegabox").removeClass('on');
		});
		
		$('.mymegabox').click(function(){
			$(this).toggleClass("on");
			$(".layer-mynega").toggleClass("on");
		});
		
		$('#sitemap').click(function(){
			$(this).toggleClass("on");
			$('.layer-sitemap').toggleClass("on");
		});
		
		$('.gnb-txt-movie, .gnb-depth2').mouseenter(function(){
			$('#gnb').addClass("on");
			$(this).parent('li').addClass("on");
		});
		
		$('.gnb-txt-movie, .gnb-depth2').mouseleave(function(){
			$('#gnb').removeClass("on");
			$(this).parent('li').removeClass("on");
		});

		$('.gnb-txt-reserve, .gnb-depth2').mouseenter(function(){
			$('#gnb').addClass("on");
			$(this).parent('li').addClass("on");
		});
		
		$('.gnb-txt-reserve, .gnb-depth2').mouseleave(function(){
			$('#gnb').removeClass("on");
			$(this).parent('li').removeClass("on");
		});
		
		$('.gnb-txt-theater, .gnb-depth2').mouseenter(function(){
			$('#gnb').addClass("on");
			$(this).parent('li').addClass("on");
		});
		
		$('.gnb-txt-theater, .gnb-depth2').mouseleave(function(){
			$('#gnb').removeClass("on");
			$(this).parent('li').removeClass("on");
		});
		
		$('.gnb-txt-event, .gnb-depth2').mouseenter(function(){
			$('#gnb').addClass("on");
			$(this).parent('li').addClass("on");
		});
		
		$('.gnb-txt-event, .gnb-depth2').mouseleave(function(){
			$('#gnb').removeClass("on");
			$(this).parent('li').removeClass("on");
		});
		
		$('.gnb-txt-benefit, .gnb-depth2').mouseover(function(){
			$('#gnb').addClass("on");
			$(this).parent('li').addClass("on");
		});
		
		$('.gnb-txt-benefit, .gnb-depth2').mouseout(function(){
			$('#gnb').removeClass("on");
			$(this).parent('li').removeClass("on");
		});
		
	});
	</script>
</head>

<body>
    <header id="header" class="main-header no-bg">
		<div class="ci">
		<a href="main_page.jsp" title="내가박스 메인으로 가기"></a>
		</div>
		<div class="util-area">
			<div class="left-link">
				<a href="#" title="VIP LOUNGE">VIP LOUNGE</a>
				<a href="#" title="맴버십">맴버십</a>
				<a href="centerhome.jsp" title="고객센터">고객센터</a>
			</div>
			<div class="right-link">
				<%if(loginId == null) { %>
				<a href="#" title="로그인" id="loginBox">로그인</a>
				<%} else { %>
				<a href="logout.jsp" title="로그아웃" id="loginBox">로그아웃</a>
				<% } %> 
				<%if (loginId == null) { %>
				<a href="information.jsp" title="회원가입">회원가입</a>
				<%} else { %>
				<!-- <a href="#" title="알림">알림</a> -->
				<% } %>
				<a href="fast_rev_before_map.jsp" title="빠른예매">빠른예매</a>
			</div>
		</div>
		<div class="link-area">
			<a href="#" id="sitemap" class="menu-open-btn" title="사이트맵">사이트맵</a>
			<!-- <a href="#" id="search" class="search-btn" title="검색">검색</a>  미구현   -->
			<a href="#" class="mymegabox" title="나의내가박스">나의내가박스</a>
			<a href="movie-theater-table.jsp" class="link-ticket" title="상영시간표">상영시간표</a>
		</div>
		<nav id="gnb" class="">
			<ul class="gnb-depth1">
				<li class=""> <!-- <<<<< on으로 메뉴조정 -->
					<a href="all_movie.jsp" class="gnb-txt-movie" title="영화"></a>
					<div class="gnb-depth2">
						<ul>
							<li><a href="all_movie.jsp" title="전체영화">전체영화</a></li>
							<li><a href="#" title="N스크린">N스크린</a></li>
							<li><a href="#" title="큐레이션">큐레이션</a></li>
							<li><a href="movie_post.jsp" title="무비포스트">무비포스트</a></li>
						</ul>
					</div>
				</li>
				<li class="">	<!-- <<<<< on으로 메뉴조정 -->
					<a href="fast_rev_before_map.jsp" class="gnb-txt-reserve" title="예매"></a>
					<div class="gnb-depth2">
						<ul>
							<li><a href="fast_rev_before_map.jsp" title="빠른예매">빠른예매</a></li>
							<li><a href="movie-theater-table.jsp" title="상영시간표">상영시간표</a></li>
						</ul>
					</div>
				</li>
				<li class="">	<!-- <<<<< on으로 메뉴조정 -->
					<a href="AllTheater.jsp" class="gnb-txt-theater" title="극장"></a>
					<div class="gnb-depth2">
						<ul>
							<li><a href="AllTheater.jsp" title="전체극장">전체극장</a></li>
							<li><a href="N스크린" title="특별관">특별관</a></li>
						</ul>
					</div>
				</li>
				<li class=""> 	<!-- <<<<< on으로 메뉴조정 -->
					<a href="#" class="gnb-txt-event" title="이벤트"></a>
					<div class="gnb-depth2">
						<ul>
							<li><a href="#" title="진행중 이벤트">진행중 이벤트</a></li>
							<li><a href="#" title="지난 이벤트">지난 이벤트</a></li>
							<li><a href="#" title="당첨자 발표">당첨자 발표</a></li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="gnb-txt-store" title="스토어"></a>
				</li>
				<li class="">	<!-- <<<<< on으로 메뉴조정 -->
					<a href="#" class="gnb-txt-benefit" title="혜택"></a>
					<div class="gnb-depth2">
						<ul>
							<li><a href="#" title="내가박스 맴버십">내가박스 맴버십</a></li>
							<li><a href="#" title="제휴/할인">제휴/할인</a></li>
						</ul>
					</div>
				</li>
			</ul>
		</nav>
		<!--  on off 사이트맵  -->
		<div id='layer_sitemap' class='layer-sitemap'> <!-- on을 놓으면 켜지고, 빼면 꺼짐 display:none으로 조정함 -->
		<div class='layer_sitemap_wrap'>
			<a href="" class="link-acc" title="사이트맵 레이어 입니다.">사이트맵 레이어 입니다.</a>
			<p class="tit">SITEMAP</p>
			<div class="list position-1">
				<p class="tit-depth">영화</p>
				<ul class="list-depth">
					<li><a href="all_movie.jsp" title="전체영화">전체영화</a></li>
					<li><a href="/curation/specialcontent" title="큐레이션">큐레이션</a></li>
					<li><a href="javascript:void(0)" onclick="javascript:MegaboxUtil.Common.moveMovieFilmCheck();"
							title="영화제">영화제</a></li>
					<li><a href="movie_post.jsp" title="무비포스트">무비포스트</a></li>
				</ul>
			</div>
			<div class="list position-2">
				<p class="tit-depth">예매</p>
				<ul class="list-depth">
					<li><a href="fast_rev_before_map.jsp" title="빠른예매">빠른예매</a></li>
					<li><a href="movie-theater-table.jsp" title="상영시간표">상영시간표</a></li>
					<li><a href="javascript:void(0);" title="더 부티크 프라빗 예매">더 부티크 프라이빗 예매</a></li>
				</ul>
			</div>

			<div class="list position-3">
				<p class="tit-depth">극장</p>

				<ul class="list-depth">
					<li><a href="AllTheater.jsp" title="전체극장">전체극장</a></li>
					<li><a href="javascript:void(0);" title="특별관">특별관</a></li>
				</ul>
			</div>

			<div class="list position-4">
				<p class="tit-depth">이벤트</p>

				<ul class="list-depth">
					<li><a href="javascript:void(0)" onclick="NetfunnelChk.aTag('EVENT_LIST','/event');return false;"
							title="진행중 이벤트">진행중 이벤트</a></li>
					<li><a href="javascript:void(0)"
							onclick="NetfunnelChk.aTag('EVENT_LIST','/event/end');return false;" title="지난 이벤트">지난
							이벤트</a></li>
					<li><a href="javascript:void(0)"
							onclick="NetfunnelChk.aTag('EVENT_LIST','/event/winner/list');return false;"
							title="당첨자발표">당첨자발표</a></li>
				</ul>
			</div>

			<div class="list position-5">
				<p class="tit-depth">스토어</p>

				<ul class="list-depth">
					<li><a href="javascript:void(0)" onclick="NetfunnelChk.aTag('STORE_LIST','/store');return false;"
							title="새로운 상품">새로운 상품</a></li>
					<li><a href="javascript:void(0)"
							onclick="NetfunnelChk.aTag('STORE_LIST','/store/megaticket');return false;"
							title="메가티켓">메가티켓</a></li>
					<li><a href="javascript:void(0)"
							onclick="NetfunnelChk.aTag('STORE_LIST','/store/megachance');return false;"
							title="메가찬스">메가찬스</a></li>
					<li><a href="javascript:void(0)"
							onclick="NetfunnelChk.aTag('STORE_LIST','/store/popcorn');return false;"
							title="팝콘/음료/굿즈">팝콘/음료/굿즈</a></li>
					<li><a href="javascript:void(0)" onclick="NetfunnelChk.aTag('STORE_LIST','/store/e-giftcard');return false;" title="기프트카드">기프트카드</a></li>
				</ul>
			</div>

			<div class="list position-6">
				<p class="tit-depth">나의 내가박스</p>
				<ul class="list-depth mymage">


					<li><a href="javascript:void(0);"
							title="나의 내가박스 홈">나의 내가박스 홈</a></li>
					<li><a href="javascript:void(0);"
							title="예매/구매내역">예매/구매내역</a></li>
					<li><a href="javascript:void(0);"
							title="영화관람권">영화관람권</a></li>
					<li><a href="javascript:void(0);"
							title="스토어교환권">스토어교환권</a></li>
					<li><a href="javascript:void(0);"
							title="할인/제휴쿠폰">할인/제휴쿠폰</a></li>

					<li><a href="javascript:void(0);"
							title="멤버십포인트">멤버십포인트</a></li>
					<li><a href="javascript:void(0);"
							title="나의 무비스토리">나의 무비스토리</a></li>
					<li><a href="javascript:void(0);"
							title="나의 이벤트 응모내역">나의 이벤트 응모내역</a></li>
					<li><a href="javascript:void(0);"
							title="나의 문의내역">나의 문의내역</a></li>
					<li><a href="javascript:void(0);" title="자주쓰는 할인 카드">자주쓰는 할인 카드</a></li>
					<li><a href="javascript:void(0);"
							title="회원정보">회원정보</a></li>
				</ul>
			</div>

			<div class="list position-7">
				<p class="tit-depth">혜택</p>

				<ul class="list-depth">
					<li><a href="javascript:void(0);" title="멤버십 안내">멤버십 안내</a></li>
					<li><a href="javascript:void(0);" title="VIP LOUNGE">VIP LOUNGE</a></li>
					<li><a href="javascript:void(0);" title="제휴/할인">제휴/할인</a></li>
				</ul>
			</div>

			<div class="list position-8">
				<p class="tit-depth">고객센터</p>

				<ul class="list-depth">
					<li><a href="centerhome.jsp" title="고객센터 홈">고객센터 홈</a></li>
					<li><a href="javascript:void(0);" title="자주묻는질문">자주묻는질문</a></li>
					<li><a href="javascript:void(0);" title="공지사항">공지사항</a></li>
					<li><a href="inquiry.jsp" title="1:1문의">1:1문의</a></li>
					<li><a href="javascript:void(0);" title="단체/대관문의">단체/대관문의</a></li>
					<li><a href="javascript:void(0);" title="분실물문의">분실물문의</a></li>
				</ul>
			</div>

			<div class="list position-9">
				<p class="tit-depth">회사소개</p>

				<ul class="list-depth">
					<li><a href="mymegabox.jsp" target="_blank" title="내가박스소개">내가박스소개</a></li>
					<li><a href="javascript:void(0);" target="_blank" title="사회공헌">사회공헌</a></li>
					<li><a href="javascript:void(0);" target="_blank" title="홍보자료">홍보자료</a></li>
					<li><a href="javascript:void(0);" target="_blank" title="제휴/부대사업문의">제휴/부대사업문의</a></li>
					<li><a href="javascript:void(0);" target="_blank" title="온라인제보센터">온라인제보센터</a></li>
					<li><a href="javascript:void(0);" target="_blank" title="자료">IR자료</a></li>
					<li><a href="javascript:void(0);" target="_blank" title="인재채용림">인재채용</a></li>
					<li><a href="javascript:void(0);" target="_blank" title="윤리경영">윤리경영</a></li>
				</ul>
			</div>


			<div class="list position-10">
				<p class="tit-depth">이용정책</p>

				<ul class="list-depth">
					<li><a href="javascript:void(0);" title="이용약관">이용약관</a></li>
					<li><a href="javascript:void(0);" title="개인정보처리방침">개인정보처리방침</a></li>
					<li><a href="javascript:void(0);" title="스크린수배정에관한기준">스크린수배정에관한기준</a></li>
				</ul>
			</div>

			<div class="ir">
				<a href="" class="layer-close" title="레이어닫기">레이어닫기</a>
			</div>


		</div>
	</div>
		<!-- layer-mynega on off -->
		<div id="header-layer-mynega" class="layer-mynega">
			<a class="ir" title="나의 내가박스 레이어 입니다."></a>
			<div class="wrap">
				<%if(loginId == null) { %>
				<!--  로그인 전  -->
				<div class="login-before">
					<p class="txt">
						로그인 하시면 나의 내가박스를 만날 수 있어요.
						<br/>
						영화를 사랑하는 당신을 위한 꼭 맞는 혜택까지 확인해 보세요!
					</p>
					<div class="mb50">
						<a href="#" id="movelogin" title="로그인" class="button" style="width:120px;">로그인</a>
					</div>
					<a href="information.jsp" class="link" title="혹시 아직 회원이 아니신가요?">혹시 아직 회원이 아니신가요?</a>
				</div>
				<%} else { %>
				<!--  로그인 후    -->
				<div class="login-after" >
					<div class="user-info">
						<p class="txt">안녕하세요!</p>
						<p class="info">
							<em><%=name %></em>
							<span>회원님</span>
						</p>
						<div class="last-date">
							마지막 접속일 : 
							<em><%=todate%></em>
						</div>
						<div class="btn-fixed">
							<a href="mymegabox.jsp" class="button" title="나의 내가박스">나의 내가박스</a>
						</div>
					</div>
					<div class="box">
						<div class="point">
							<p class="tit">Point</p>
							<p class="count">0</p>
							<div class="btn-fixed">
								<a href="javascript:void(0);" class="button" title="맴버십 포인트">맴버십포인트</a>
							</div>
						</div>
					</div>
					<div class="box">
						<div class="coupon">
							<p class="tit">쿠폰/관람권</p>
							<p class="count">
								<em title="쿠폰 수" class="cpon">0</em>
								<span title="관람권수" class="movie">0</span>
							
							<div class="btn-fixed">
								<a href="javascript:void(0);" class="button" title="쿠폰">쿠폰</a>
								<a href="javascript:void(0);" class="button" title="관람권">관람권</a>
							</div>
						</div>
					</div>
					<div class="box">
						<div class="reserve">
							<p class="tit">예매</p>
							<p class="txt">예매내역이 없어요!</p>
							<div class="btn-fixed">
								<a href="javascript:void(0);" class="button" title="예매내역">예매내역</a>
							</div>
						</div>
					</div>
					<div class="box">
						<div class="buy">
							<p class="tit">구매</p>
							<p class="count">
								<em>0</em>
								<span>건</span>
							</p>
						</div>
						<div class="btn-fixed">
							<a href="javascript:void(0);" class="button" title="구매내역">구매내역</a>
						</div>
					</div>
				</div>
				<% } %>
			</div>
		</div>
	</header>
	<div class="page-util">
		<div class="inner-wrap">
			<div class="location">
				<span>Home</span>
				<a href="#" title="페이지 이동" style="letter-spacing:-2px;">
					고객센터
				</a>
				<a href="#" title="페이지 이동" style="letter-spacing:-2px;">
					1:1 문의
				</a>
			</div>
		</div>
	</div>
	<!-- ▽로그인 창 -->
	<!-- on으로 조정함 -->
	<div class="background ">
		<!-- 	<div style="height:100px;"></div>
		 --><div class="wrap1">
				<div class="wrap-login">
					<h3 class="tit fl">로그인</h3>
						<a id="exitButton" href="#" class="fr"><img src="image/btn-layer-close.png"/></a>
					<div style="clear:both;"></div>
				</div>
				<form action="login_action.jsp">
				<div class="layer-login">
					<div class="login-input-area">
						<input type="text" placeholder="아이디" id="id" name="id"/> <br/>
						<input type="password" placeholder="비밀번호" id="pw" name="pw"/> <br/>
					</div>
					<div class="chk">
						<div>
							<input id="chkbox" type="checkbox" style="font-size:14px; color:#444444;">
							아이디 저장
								<div class="ad">
									<a href=""></a>
										<span>휴대폰 간편로그인 </span>
										<span style="border:1px solid #3d7db7; font-size:14px; border: 1px solid #3d7db7; font-size: 14px; padding-left: 7px; padding-right: 7px;">광고</span>
								</div>
						</div>

					</div>
						<input type='submit' value='로그인' class="but">
					<div class="link">
						<a href="javascript:void(0);" style="text-decoration: none; color:#666666">ID/PW 찾기</a>
						<img src="image/I.png" style="margin: -9px; margin-left: -20px; margin-right: -25px;"/>
						<a href="information.jsp" style="text-decoration: none; color:#666666">회원가입</a>
						<img src="image/I.png" style="margin: -9px; margin-right: -25px; margin-left: -20px;"/>
						<a href="javascript:void(0);" style="text-decoration: none; color:#666666">비회원 예매확인</a>
					</div>
					<div class="sns-login">
						<a href="javascript:void(0);">
						<img src="image/ico-facebook.png">
						</a>
						<a href="javascript:void(0);">
						<img src="image/ico-naver.png">
						</a>
						<a href="javascript:void(0);">
						<img src="image/ico-kakao.png">
						</a>
						<a href="javascript:void(0);">
						<img src="image/ico-payco.png">
						</a>
					</div>
					<div class="col-right">
					</div>
				</div>
				</form>
				<div class="right-login">
					<div class="login-ad">
						<a href="javascript:void(0);">
							<img src="image/fecf1f96c23d2dfc4deaeba5b8c33828.jpg">
						</a>
					</div>
				</div>
			</div>
		</div>
	<!-- △로그인 창 -->
	<!--  header 종료 -->
	<!-- ▽main  -->
	
    <div class="inner-wrap">
		<div class="lnb-area addchat">
			<nav id="lnb">
				<p class="tit">
					<a href="" title="고객센터">고객센터</a>
				</p>
				<ul style="padding:0; margin:0;">
					<li>
						<a href="https://www.megabox.co.kr/support" title="고객센터 홈">고객센터 홈</a>
					</li>
					<li>
						<a href="" title="자주묻는질문">자주 묻는 질문</a>
					</li>
					<li>
						<a href="https://www.megabox.co.kr/support/notice" title="공지사항">공지사항</a>
					</li>
					<li class="on">
						<a href="" title="1:1문의">1:1문의</a>
					</li>
					<li>
						<a href="" title="단체관람 및 대관문의">단체관람 및 대관문의</a>
					</li>
					<li>
						<a href="" title="분실물 문의">분실물 문의</a>
					</li>
					<li>
						<a href="" title="이용약관">이용약관</a>
					</li>
					<li>
						<a href="" title="개인정보처리방침">개인정보처리방침</a>
					</li>
					<li>
						<a href="" title="스크린배정수에관한기준">스크린배정수에관한기준</a>
					</li>
				</ul>
				<div class="left-customer-info">
					<p class="tit">
						메가박스 고객센터
						<span>Dream center</span>
					</p>
					<p class="time"><i class="iconset ico-clock"></i> 10:30~18:30</p>
				</div>
			</nav>
		</div>

        <div id="contents">
			<h2 class="tit" style="margin:0; letter-spacing:-2px;">1:1 문의</h2>
            <div class="mypage-information mb30">
                <span>&#149; 문의하시기 전 FAQ를 확인하시면 궁금증을 더욱 빠르게 해결하실 수 있습니다.</span>
                <div class="btn-group right">
                    <a href="#" class="button purple" title="나의 문의내역 페이지로 이동"><b style="letter-spacing:-2px;">나의 문의내역</b></a>
                </div>
            </div>
            <div class="agree-box">
                <dl>
                    <dt>
                        <span class="bg-chk mr10">
                            <input type="checkbox" style="display:none;" id="chk">
                            <label for="chk">
                                <strong style="font-size:17px;">개인정보 수집에 대한 동의</strong>
                            </label>
                        </span>
                        <span class="font-orange">[필수]</span>
                    </dt>
                    <dd style="font-size:13px;">
                    	귀하께서 문의하신 다음의 내역은 법률에 의거 개인정보 수집·이용에 대한 본인동의가 필요한 항목입니다.
                    	<br/>
                    	<br/>
                    	[개인정보의 수집 및 이용목적]
                    	<br/>
                    	회사는 단체관람/대관 문의 내역의 확인, 요청사항 처리 또는 완료 시 원활한 의사소통 경로 확보를 위해 수집하고 있습니다.
                    	<br/>
                    	<br/>
                   		[수집하는 개인정보의 항목]
                   		<br/>
                   		이름, 연락처, 이메일 주소
                   		<br/>
                   		<br/>
                   		[개인정보의 보유기간 및 이용기간]
                   		<br/>
                   		<span class="ismsimp">
                   		문의 접수 ~ 처리 완료 후 6개월
                   		<br/>
                   		(단, 관계법령의 규정에 의하여 보존 할 필요성이 있는 경우에는 관계 법령에 따라 보존)
                   		<br/>
                   		자세한 내용은 '개인정보 처리방침'을 확인하시기 바랍니다.
                   		</span>
                    </dd>
                </dl>
            </div>
            <p class="reset mt10">* 원활한 서비스 이용을 위한 최소한의 개인정보이므로 동의하지 않을 경우 서비스를 이용하실 수 없습니다</p>
            <p class="reset mt30 a-r font-orange">* 필수</p>
            <form name="regFrm" method="post">
            	<input type="hidden" name="inqLclCd" value="INQD01">
            	<input type="hidden" name="custInqStatCd" value="INQST1">
            	<input type="hidden" name="cdLvl" value="3">
            	<input type="hidden" name="fileNo" value="">
            	<div class="table-wrap mt10">
            		<table class="board-form va-m">
            			<colgroup>
            				<col style="width:150px;">
            				<col>
            				<col style="width:150px;">
            				<col>
            			</colgroup>
            			<tbody>
            				<tr>
            					<th scope="row">
            					문의지점
            					<em class="font-orange">*</em>
            					</th>
            					<td colspan="3">
            						<input type="radio" id="aq1" name="inqMclCd" value="QD01M01" data-cd="QD_BRCH_DIV_CD" checked>
            						<label for="aq1">지점문의</label>
            						<select class="ml10 select" id="region" title="지역선택">
            							<option value>지역선택</option>
            							<option value="10">서울</option>
            							<option value="20">경기</option>
            							<option value="30">인천</option>
            							<option value="40">대전/충청/세종</option>
            							<option value="50">부산/대구/경상</option>
            							<option value="60">광주/전라</option>
            							<option value="70">강원</option>
            							<option value="80">제주</option>
            						</select>
            						<select class="ml10 select" id="theater" title="극장선택">
            							<option value>극장선택</option>
            						</select>
            						<input type="radio" id="aq2" name="inqMclCd" class="ml20" value="QD01M02" data-cd="QD_ETC_DIV_CD">
            						<label for="aq2">기타문의</label>
            					</td>
            				</tr>
            				<tr>
            					<th scope="row">
            						<label for="ask-type">문의유형</label>
            						<em class="font-orange">*</em>
            					</th>
            					<td colspan="3">
            						<select class="select2" id="ask-type" name="inqSclCd">
            							<option value>문의유형 선택</option>
            							<option value="QDBR01">일반문의</option>
            							<option value="QDBR02">칭찬</option>
            							<option value="QDBR03">불만</option>
            							<option value="QDBR04">제안</option>
            						</select>
            					</td>
            				</tr>
            				<tr>
            					<th scope="row">
            						<label for="name">이름</label>
            						<em class="font-orange">*</em>
            					</th>
            					<td>
            						<input type="text" id="name" name="inqurNm" class="input-text w150px" value="" maxlength="15">
            					</td>
            					<th scope="row">
            						<label for="qnaRpstEmail">이메일</label> 
            						<em class="font-orange">*</em>
            					</th>
            					<td>
            						<input type="text" name="rpstEmail" id="qnaRpstEmail" class="input-text" value="" maxlength="50">
            					</td>
            				</tr>
            				<tr>
            					<th scope="row">
            						<label for="hpNum1">휴대전화</label>
            						<em class="font-orange">*</em>
            					</th>
            					<td colspan="3">
            						<input type="text" name="hpNum1" id="hpNum1" class="input-text w60px" maxlength="3" title="핸드폰번호 첫자리 입력">
            						<span>-</span>
            						<input type="text" name="hpNum2" id="hpNum2" class="input-text w70px numType" maxlength="4" title="핸드폰번호 중간자리 입력">
            						<span>-</span>
            						<input type="text" name="hpNum3" id="hpNum3" class="input-text w70px numType" maxlength="4" title="핸드폰번호 마지막자리 입력">
            						<button id="btnQnaMblpCertNoSend" type="button" disabled="disabled" class="button gray w100px ml08 disabled">인증요청</button>
            					</td>
            				</tr>
            				<tr id="qnaMblpCertRow" style="display:none;">
            					<th scope="row">
            						<label for="ibxQnaMblpCharCertNo">인증번호</label>
            						<em class="font-orange">*</em>
            					</th>
            					<td colspan="3">
            						<div class="chk-num">
            							<div class="line">
            								<input maxlength="4" type="text" id="ibxQnaMblpCharCertNo" class="input-text w180px numType" title="인증번호 입력" disabled="disabled">
            								<div id="qnaTimer" class="time-limit" style="letter-spacing:0">3:00</div>
            							</div>
            						</div>
            						<button id="btnQnaMblpCharCert" type="button" class="button purple w100px ml08 disabled" disabled="disabled">인증확인</button>
            					</td>
            				</tr>
            				<tr>
            					<th scope="row">
            						<label for="qnaCustInqTitle">제목</label>
            						<em class="font-orange">*</em>
            					</th>
            					<td colspan="3">
            						<input type="text" name="custInqTitle" id="qnaCustInqTitle" class="input-text" maxlength="100">
            					</td>
            				</tr>
            				<tr>
            					<th scope="row">
            						<label for="textarea">내용</label> 
            						<em class="font-orange">*</em>
            					</th>
            					<td colspan="3" style="box-sizing:border-box;">
            						<div class="textarea">
            							<textarea id="textarea" name="custInqCn" rows="5" cols="30" title="내용입력" placeholder="※ 불편사항이나 문의사항을 남겨주시면 최대한 신속하게 답변 드리겠습니다. 
 ※ 문의 내용에 개인정보(이름, 연락처, 카드번호 등)가 포함되지 않도록 유의하시기 바랍니다." class="input-textarea"></textarea>
 										<div class="util">
												<p class="count">
													<span id="textareaCnt">0</span> / 2000
												</p>
										</div>
            						</div>
            						
            					</td>
            				</tr>
            				<tr>
            					<th scope="row">사진첨부</th>
            					<td colspan="3">
            						<div class="upload-image-box">

											<div class="info-txt">
												<p>* JPEG, PNG 형식의 5M 이하의 파일만 첨부 가능합니다. (최대 5개)</p>

												<!-- to 개발 : 이미지 추가가 5개가 되면 버튼 숨김 -->
												<button type="button" id="uploadBtn" class="btn-image-add"><span>파일선택</span></button>
												<!--// to 개발 : 이미지 추가가 5개가 되면 버튼 숨김 -->
												<p>* 개인정보가 포함된 이미지 등록은 자제하여 주시기 바랍니다.</p>
											</div>

											<div id="imgList"></div>

										</div>
            					</td>
            				</tr>
            			</tbody>
            		</table>
            	</div>
            	<div class="btn-group pt40">
						<button type="submit" class="button purple large">등록</button>
					</div>
            </form>
        </div>
	</div>
    <div style="clear:both;"></div>
	<div id="footer">
		<div class="container1">
			<div id="footerbox1">
				<a href="https://www.megabox.co.kr/megaboxinfo" class="footerlink">회사소개</a>
				<a href="https://www.megabox.co.kr/recruit" class="footerlink">인재채용</a>
				<a href="https://www.megabox.co.kr/socialcontribution" class="footerlink">사회공헌</a>
				<a href="https://www.megabox.co.kr/partner" class="footerlink">제휴/광고/부대사업문의</a>
				<a href="https://www.megabox.co.kr/support/terms" class="footerlink"><b>개인정보처리방침</b></a>
				<a href="https://jebo.joonganggroup.com/main.do" class="footerlink">윤리경영</a>
				<a href="#" id="footerbox"><img src="./image/ico-footer-search.png" style="margin:-4px 0" />극장찾기</a>
			</div>

			<div id="footerbox4">
				<div id="footerbox2">
					<img src="./image/logo-opacity_new2.png" style="margin:0 15px 0 0; float:left;" />
					<p class="footertext" style="margin-top:3px">
						서울특별시 마포구 월드컵로 240, 지상 2층(성산동, 월드컵주경기장) ARS 1544-0070</p>
					<p class="footertext">
						대표자명 김진선 · 개인정보보호책임자 조상연 · 사업자등록번호 211-86-59478 · 통신판매업신고번호 제 833호
					</p>
					<p class="footertext">
						COPYRIGHT © MegaboxJoongAng, Inc. All rights reserved
					</p>
				</div>

				<div id="footerbox3">
					<a href="https://apps.apple.com/kr/app/megabox/id894443858?l=ko&ls=1">
						<div class="footerlink1"
							style="background-image:url(https://img.megabox.co.kr/static/pc/images/common/ico/ico-appstore.png)">
						</div>
					</a>
					<a href="https://play.google.com/store/apps/details?id=com.megabox.mop">
						<div class="footerlink1"
							style="background-image:url(https://img.megabox.co.kr/static/pc/images/common/ico/ico-googleplay.png)">
						</div>
					</a>
					<a href="https://www.instagram.com/megaboxon">
						<div class="footerlink1"
							style="background-image:url(https://img.megabox.co.kr/static/pc/images/common/ico/ico-instagram.png)">
						</div>
					</a>
					<a href="https://www.facebook.com/megaboxon">
						<div class="footerlink1"
							style="background-image:url(https://img.megabox.co.kr/static/pc/images/common/ico/ico-facebook.png)">
						</div>
					</a>
					<a href="https://twitter.com/megaboxon">
						<div class="footerlink1"
							style="background-image:url(https://img.megabox.co.kr/static/pc/images/common/ico/ico-twitter.png)">
						</div>
					</a>
				</div>
			</div>


		</div>
	</div>
</body>