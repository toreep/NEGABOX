package com.mega.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mega.dao.AllmovieDao;
import com.mega.dao.ApiDao;
import com.mega.dto.ApiDto;
import com.mega.dto.MovieAllDto;

public class AllmovieAction implements Action {
		AllmovieDao AllmovieDao = new AllmovieDao();
		ApiDao ApiDao = new ApiDao();
		ArrayList<ApiDto> apiList = ApiDao.allmovieApi();
		ArrayList<MovieAllDto> movieList = new ArrayList<MovieAllDto>();
		
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)(session.getAttribute("id"));
		System.out.println("세션 id : " + id);
		
		//예매율 계산
		int pip = 0;
		for(ApiDto vo : apiList) {
			pip += Integer.parseInt((vo.getAudiCnt()));
		}
		String accApi = "";
		String cntApi = "";
		float n = 0; 
		float m = 0; 
		float apinum = 0; 
		double sumApi = 0;
		
			double[] Apisum = new double[10];
			int tt = 0;
				for(ApiDto vo : apiList) {
					n = Float.parseFloat(vo.getAudiCnt());
					apinum = n / pip * 100;
					sumApi = Math.round(apinum*10)/10.0;
					Apisum[tt] = sumApi;
					tt++;
				}
			
		//영화 api 10개
		for(ApiDto vo : apiList) {
			movieList = AllmovieDao.movielist(new ApiDto("","",vo.getMovieNm()));
		} 
		//그외 영화들
		ArrayList<MovieAllDto> notlist = AllmovieDao.notlist(movieList);
		
		//전체 영화  좋아요수 api(10개)
		ArrayList<Integer> countList = AllmovieDao.countList(movieList);
		
		//전체 영화 좋아요수 (그외)
		ArrayList<Integer> countListNot = AllmovieDao.countList(notlist);
		
		//전체 영화 숫자
		int movieCount = AllmovieDao.Allmovie();
		
		//영화 관람평(api)
		ArrayList<Float> reviewCount = AllmovieDao.reviewCount(movieList);
		
		//영화 관람평(그외)
		ArrayList<Float> reviewCountNot = AllmovieDao.reviewCount(notlist);
		
		//회원 좋아요(api)
		HashMap<String, Integer> hmapMovieCodeLike = AllmovieDao.hmapMovieCodeLike(movieList, id);
		
		//회원 좋아요(그외)
		HashMap<String, Integer> hmapMovieCodeLike2 = AllmovieDao.hmapMovieCodeLike(notlist, id);
		
		request.setAttribute("movieList", movieList);
		request.setAttribute("notlist", notlist);
		request.setAttribute("countList", countList);
		request.setAttribute("countListNot", countListNot);
		request.setAttribute("movieCount", movieCount);
		request.setAttribute("reviewCount", reviewCount);
		request.setAttribute("reviewCountNot", reviewCountNot);
		request.setAttribute("hmapMovieCodeLike", hmapMovieCodeLike);
		request.setAttribute("hmapMovieCodeLike2", hmapMovieCodeLike2);
		request.setAttribute("Apisum", Apisum);
		
		request.getRequestDispatcher("all_movie.jsp").forward(request, response);
		
	}
}
