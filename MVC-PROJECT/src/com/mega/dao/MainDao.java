package com.mega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mega.action.DBConnection;
import com.mega.dto.ApiDto;
import com.mega.dto.MainDto;

public class MainDao {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Float> reviewCount = new ArrayList<Float>();
	// 영화정보
	public ArrayList<MainDto> movielist(ApiDto dto) {
		ArrayList<MainDto> movieList = new ArrayList<MainDto>();
		String sql ="select movie_photo, dolby, mx, movie_code, plot, movie_name from movie where movie_name = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMovieNm());
			rs = pstmt.executeQuery();
			if(rs.next()) {
			String moviePhoto = rs.getString("movie_photo");
			int dolby = rs.getInt("dolby");
			int mx = rs.getInt("mx");
			String plot = rs.getString("plot");
			String movieCode = rs.getString("movie_code");
			String movieName = rs.getString("movie_name");
			movieList.add(new MainDto(movieCode,moviePhoto,plot,dolby,mx,movieName));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} return movieList;
	}
	
	// 관람평 점수(메인)
	public ArrayList<Float> review(ArrayList<MainDto> dto) {
		String sql = "select round(sum(score)/count(*) ,1) score from review where movie_code = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			for(MainDto vo : dto) {
				pstmt.setString(1, vo.getMovieCode());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println("메인 관람평 평균 이름 " + vo.getMovieCode());
					System.out.println("메인 관람평 평균 점수" + rs.getFloat("score"));
					reviewCount.add(rs.getFloat("score"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} return reviewCount;
	}
	
	// 영화별 좋아요 숫자(메인)
	public ArrayList<Integer> heartCount(ArrayList<MainDto> dto) {
		String sql = "select count(*) from want_to_watch where movie_code = ?";
		ArrayList<Integer> heartCount = new ArrayList<Integer>();
		try {
			pstmt = conn.prepareStatement(sql);
			for(MainDto vo : dto) {
				pstmt.setString(1, vo.getMovieCode());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					heartCount.add(rs.getInt("count(*)")); // 좋아요 카운트 영화 순서별.
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} return heartCount;
	}
	
	// 회원 좋아요(메인)
	public HashMap<String, Integer> MemberHeartCount(ArrayList<MainDto> dto, String id) {
		String sql	= "select count(*) from want_to_watch where member_id = ? and movie_code = ?";
		HashMap<String, Integer> hmapMovieCodeLike = new HashMap<String, Integer>();
		for(MainDto vo : dto) {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,id);
				pstmt.setString(2,vo.getMovieCode());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					hmapMovieCodeLike.put(vo.getMovieCode(), rs.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hmapMovieCodeLike;
	}
}
