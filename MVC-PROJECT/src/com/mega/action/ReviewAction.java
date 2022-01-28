package com.mega.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mega.dao.ReviewDao;
import com.mega.dto.ReviewDto;

public class ReviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReviewDao reviewDao = new ReviewDao();
		Date today = new Date();
		
		
		HttpSession session = request.getSession();
		String loginId = (String)(session.getAttribute("id"));
		String movieCode = request.getParameter("movieCode");
		String textarea = request.getParameter("textarea");
		String star = request.getParameter("star");
		String pit1 = request.getParameter("pit1");
		String pit2 = request.getParameter("pit2");
		System.out.println("text!!!!!!!!!" + textarea);
		if(pit2 == "") {
			pit2 = "x";
		}
		System.out.println("로그인아이디 : " + loginId);
		System.out.println("영화코드 : " + movieCode);
		System.out.println("관람평 텍스트 : " + textarea);
		System.out.println("별점 : " + star);
		System.out.println("관람포인트 : " + pit1 + "," + pit2);
		
		String pit = pit1 + "," + pit2;
		
		int starscore = Integer.parseInt(star);
		reviewDao.updateReview(new ReviewDto(loginId,starscore,textarea,pit,0,movieCode,today));
		System.out.println("리뷰 등록 완료!");
	}
	
}
