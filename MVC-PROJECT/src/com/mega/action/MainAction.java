package com.mega.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mega.dao.ApiDao;
import com.mega.dao.MainDao;
import com.mega.dao.MemberDao;
import com.mega.dao.MovieDao;
import com.mega.dto.ApiDto;
import com.mega.dto.MainDto;

public class MainAction implements Action {
	MainDao MainDao = new MainDao();
	ApiDao ApiDao = new ApiDao();
	MemberDao MemberDao = new MemberDao();
	MovieDao MovieDao = new MovieDao();
	ArrayList<MainDto> movieList = new ArrayList<MainDto>();
	ArrayList<ApiDto> apiList = ApiDao.movieApi();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		for(ApiDto vo : apiList) {
			movieList.addAll(MainDao.movielist(new ApiDto("","",vo.getMovieNm())));
			System.out.println("api 영화이름  : " + vo.getMovieNm());
		}
		
		ArrayList<Float> reviewScore = MainDao.review(movieList);
		ArrayList<Integer> heartCount = MainDao.heartCount(movieList);
		HashMap<String, Integer> MemberHeartCount = MainDao.MemberHeartCount(movieList, id);
		
		request.setAttribute("movieList", movieList);	// 메인화면 영화 정보 (api기반)
		request.setAttribute("heartCount", heartCount);
		request.setAttribute("MemberHeartCount", MemberHeartCount);
		request.setAttribute("reviewScore", reviewScore);
		
		request.getRequestDispatcher("main_page.jsp").forward(request, response);
	}
}
