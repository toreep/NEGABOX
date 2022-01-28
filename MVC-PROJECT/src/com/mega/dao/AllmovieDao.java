package com.mega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.mega.action.DBConnection;
import com.mega.dto.ApiDto;
import com.mega.dto.MovieAllDto;

public class AllmovieDao {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<MovieAllDto> movieList = new ArrayList<MovieAllDto>();
	ArrayList<Integer> countList = new ArrayList<Integer>();
	ArrayList<MovieAllDto> notlist = new ArrayList<MovieAllDto>();
	ArrayList<Float> reviewCountNot = new ArrayList<Float>();
	ArrayList<Float> reviewCount = new ArrayList<Float>();
	HashMap<String, Integer> hmapMovieCodeLike = new HashMap<String, Integer>();
	HashMap<String, Integer> hmapMovieCodeLike2 = new HashMap<String, Integer>();

	// 전체 영화 정보(api기반 10개)
	public ArrayList<MovieAllDto> movielist(ApiDto dto) {
		String sql = "select movie_photo, dolby, mx, movie_code, plot, opening_day, rating, movie_name FROM movie where movie_name = ?";
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getMovieNm());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String moviePhoto = rs.getString("movie_photo");
					int dolby = rs.getInt("dolby");
					int mx = rs.getInt("mx");
					String plot = rs.getString("plot");
					String movieCode = rs.getString("movie_code");
					String movieName = rs.getString("movie_name");
					String rating = rs.getString("rating");
					Date openingDay = rs.getTimestamp("opening_day");
					movieList.add(new MovieAllDto(movieCode, movieName, openingDay, rating, moviePhoto, plot, dolby, mx));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieList;
	}

	// 전체 영화 정보 (그외)
	public ArrayList<MovieAllDto> notlist(ArrayList<MovieAllDto> dto) {
		String sql = "select movie_photo, dolby, mx, movie_code, plot, opening_day, rating, movie_name from movie where movie_name not in (?,?,?,?,?,?,?,?,?,?)";
		int j = 1;
		try {
			pstmt = conn.prepareStatement(sql);
			for (MovieAllDto vo : movieList) {
				System.out.println("전체영화정보 그외 :" + vo.getMovieName());
				pstmt.setString(j, vo.getMovieName());
				j++;
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String moviePhoto = rs.getString("movie_photo");
				int dolby = rs.getInt("dolby");
				int mx = rs.getInt("mx");
				String plot = rs.getString("plot");
				String movieCode = rs.getString("movie_code");
				String movieName = rs.getString("movie_name");
				String rating = rs.getString("rating");
				Date openingDay = rs.getTimestamp("opening_day");
				System.out.println("그외 영화들 : " + movieName);
				notlist.add(new MovieAllDto(movieCode, movieName, openingDay, rating, moviePhoto, plot, dolby, mx));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notlist;
	}

	// 전체영화 좋아요
	public ArrayList<Integer> countList(ArrayList<MovieAllDto> dto) {
		String sql = "select count(*) from want_to_watch where movie_code = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			for (MovieAllDto vo : dto) {
				pstmt.setString(1, vo.getMovieCode());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					countList.add(rs.getInt("count(*)"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countList;
	}

	// 전체영화 숫자
	public int Allmovie() {
		String sql = "select count(*) from movie";
		int movieCount = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				movieCount = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieCount;
	}

	// 영화당 관람평 점수
	public ArrayList<Float> reviewCount(ArrayList<MovieAllDto> dto) {
		String sql = "select round(sum(score)/count(*) ,1) score from review where movie_code = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			for (MovieAllDto vo : dto) {
				pstmt.setString(1, vo.getMovieCode());
				rs = pstmt.executeQuery();
				if(rs.next()) {
				reviewCount.add(rs.getFloat("score"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewCount;
	}

	// 회원 좋아요 숫자(api)
	public HashMap<String, Integer> hmapMovieCodeLike(ArrayList<MovieAllDto> dto, String id) {
		String sql = "select count(*) from want_to_watch where member_id = ? and movie_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			for (MovieAllDto vo : dto) {
				pstmt.setString(1, id);
				pstmt.setString(2, vo.getMovieCode());
				rs = pstmt.executeQuery();

				if (rs.next()) {
					hmapMovieCodeLike.put(vo.getMovieCode(), rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hmapMovieCodeLike;
	}
}
