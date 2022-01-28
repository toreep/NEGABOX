package com.mega.action;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mega.dao.AllmovieDao;
import com.mega.dao.ApiDao;
import com.mega.dao.MainDao;
import com.mega.dao.MovieDao;
import com.mega.dao.ReviewDao;
import com.mega.dto.ApiDto;
import com.mega.dto.MovieAllDto;
import com.mega.dto.MovieDto;
import com.mega.dto.ReviewDto;

public class MovieInfoAction implements Action {
		MovieDao movieDao = new MovieDao();
		AllmovieDao AllmovieDao = new AllmovieDao();
		ArrayList<MovieAllDto> list = new ArrayList<MovieAllDto>();
		ApiDao ApiDao = new ApiDao();
		ReviewDao ReviewDao = new ReviewDao();
		Date a;
		DecimalFormat decFormat = new DecimalFormat("#,###");
		MainDao MainDao = new MainDao();
		ArrayList<ApiDto> apiList = ApiDao.allmovieApi();
		
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mName = request.getParameter("mName");
		String movieName = request.getParameter("movieName");
		System.out.println("info:" + mName);
		list.add(new MovieAllDto(mName,"",a,"","","",0,0));
		request.setAttribute("mName", mName);
		request.setAttribute("movieName", movieName);
		
		// 영화 정보
		ArrayList<MovieDto> movieinfo = movieDao.movieinfo(mName);
		request.setAttribute("movieinfo", movieinfo);
		
		
		
		for(MovieDto vo : movieinfo) {
			request.setAttribute("moviePhoto", vo.getMoviePhoto());
			request.setAttribute("tag", vo.getTag());
			request.setAttribute("engName", vo.getEngName());
			request.setAttribute("rating", vo.getRating());
			request.setAttribute("dolby", vo.getDolby());
			request.setAttribute("plot", vo.getPlot());
			request.setAttribute("allType", vo.getAllType());
			request.setAttribute("director", vo.getDirector());
			request.setAttribute("genre", vo.getGenre());
			request.setAttribute("runningTime", vo.getRunningTime());
			request.setAttribute("openingDay", vo.getOpeningDay());
			request.setAttribute("casting", vo.getCasting());
		}
		
		// 영화 리뷰
		ArrayList<ReviewDto> listReview = ReviewDao.listReview(mName);
		request.setAttribute("listReview", listReview);
		
		// 관람평 평균
		float scoreaver = 0;
		for(ReviewDto vo : listReview) {
			scoreaver += vo.getScore();
		}
		float cor = scoreaver / listReview.size();
		
		float corr = (float)(Math.round(cor*10)/10.0);
		if(Double.isNaN(corr)) {
			corr = 0;
		}
		request.setAttribute("corr", corr);
		
		// 영화 api 누적관객수, 일자별 관객수
		ArrayList<ApiDto> allmovieApi = ApiDao.allmovieApi();
		String accApi = "";
		String cntApi = "";
		for(ApiDto vo : allmovieApi) {
			if(movieName.equals(vo.getMovieNm())) {
				accApi = vo.getAudiAcc();
				System.out.println("누적관객수 " + accApi);
				cntApi = vo.getAudiCnt();
				System.out.println("일자별 관객수" + cntApi);
			}
		}
		int attendance = Integer.parseInt(accApi);
		int cntApiDay = Integer.parseInt(cntApi);
		accApi = decFormat.format(attendance);
		cntApi = decFormat.format(cntApiDay);
		
		request.setAttribute("accApi", accApi);
		request.setAttribute("cntApi", cntApi);
		
		// 영화 리뷰 갯수
		int Review = ReviewDao.reviewCount(mName);
		request.setAttribute("Review", Review);
		
		// 영화 리뷰 차트점수
		ArrayList<Integer> chartResult = ReviewDao.chartResult(mName);
		String chartPit1 = "";
		String chartPit2 = "";
		int max1 = 0;
		int max2 = 0;
		for(int i = 0; i < 4; i++) {
			if(chartResult.get(i) > max1) {
				max2 = max1;
				max1 = chartResult.get(i);
			} else if (chartResult.get(i) > max2) {
			    max2 = chartResult.get(i);
			}
		}
		chartPit1 = "";
		chartPit2 = "";
		int chartStory = chartResult.get(0);
		int chartProduction = chartResult.get(1);
		int chartOst = chartResult.get(2);
		int chartVisual = chartResult.get(3);
		int chartActor = chartResult.get(4);
		
		
		if(chartStory == max1) {
			chartPit1 = "스토리";
		}
		if(chartProduction == max1) {
			chartPit1 = "연출";
		}
		if(chartOst == max1) {
			chartPit1 = "OST";
		}
		if(chartVisual == max1) {
			chartPit1 = "영상미";
		}
		if(chartActor == max1) {
			chartPit1 = "배우";
		}
		if(chartStory == max2) {
			chartPit2 = "스토리";
		}
		if(chartProduction == max2) {
			chartPit2 = "연출";
		}
		if(chartOst == max2) {
			chartPit2 = "OST";
		}
		if(chartVisual == max2) {
			chartPit2 = "영상미";
		}
		if(chartActor == max2) {
			chartPit2 = "배우";
		}
		System.out.println("스토리 : " + chartStory);
		System.out.println("연출 : " + chartProduction);
		System.out.println("OST : " + chartOst);
		System.out.println("영상미 : " + chartVisual);
		System.out.println("배우 : " + chartActor);
		System.out.println("가장높은 카운트 수 :" + chartPit1);
		System.out.println("두번째 높은 카운트 수 : " + chartPit2);
		
		// 영화 좋아요 갯수 (작업중)
		
		
		// 예매율
				int pip = 0;
				for(ApiDto vo : apiList) {
					pip += Integer.parseInt((vo.getAudiCnt()));
				}
				float n = 0; 
				float m = 0; 
				float apinum = 0; 
				double sumApi = 0;
				
					double Apisum = 0;
					for(ApiDto vo : apiList) {
						if(vo.getMovieNm().equals(movieName)) {
							n = Float.parseFloat(vo.getAudiCnt());
							apinum = n / pip * 100;
							sumApi = Math.round(apinum*10)/10.0;
							Apisum = sumApi;
						}
					}
					System.out.println("예매율 : " +Apisum);
		
		request.setAttribute("chartStory", chartStory);
		request.setAttribute("chartProduction", chartProduction);
		request.setAttribute("chartOst", chartOst);
		request.setAttribute("chartVisual", chartVisual);
		request.setAttribute("chartActor", chartActor);
		request.setAttribute("chartPit1", chartPit1);
		request.setAttribute("chartPit2", chartPit2);
		request.setAttribute("Apisum", Apisum);
		
		request.getRequestDispatcher("movie_info.jsp").forward(request, response);
		
		
	}
}
