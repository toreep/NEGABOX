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
import com.mega.dto.MainDto;
import com.mega.dto.MovieDto;

public class MovieDao {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<MovieDto> movielist = new ArrayList<MovieDto>();
	ArrayList<ApiDto> apiList = new ArrayList<ApiDto>();
	ArrayList<Integer> heartCount = new ArrayList<Integer>();
	ArrayList<MainDto> mainlist = new ArrayList<MainDto>();
	ArrayList<Float> reviewCount = new ArrayList<Float>();
	HashMap<String, Integer> hmapMovieCodeLike = new HashMap<String, Integer>();
	ArrayList<MovieDto> movieinfolist = new ArrayList<MovieDto>();

	// 전체 영화정보
	public ArrayList<MovieDto> Movielist() {
		String sql = "select * from movie";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String movieCode = rs.getString("movie_code");
				String movieName = rs.getString("movie_name");
				Date openingDay = rs.getTimestamp("opening_day");
				int runningTime = rs.getInt("running_time");
				String director = rs.getString("director");
				String rating = rs.getString("rating");
				String casting = rs.getString("casting");
				String moviePhoto = rs.getString("movie_photo");
				String plot = rs.getString("plot");
				String allType = rs.getString("alltype");
				String tag = rs.getString("tag");
				String engName = rs.getString("eng_name");
				String traler = rs.getString("trailer");
				String tralerSub = rs.getString("trailer_sub");
				String stealCut = rs.getString("stealcut");
				String genre = rs.getString("genre");
				String mini_title = rs.getString("mini_title");
				int dolby = rs.getInt("dolby");
				int mx = rs.getInt("mx");
				movielist.add(new MovieDto(movieCode, movieName, openingDay, runningTime, director, rating, casting,
						moviePhoto, plot, allType, tag, engName, traler, tralerSub, stealCut, genre, mini_title, dolby,
						mx));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movielist;
	}

	// 영화 정보(메인)
	public ArrayList<MainDto> mainlist(ApiDto dto) {
		String sql = "select movie_photo, dolby, mx, movie_code, plot, movie_name from movie where movie_name = ?";
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
				System.out.println("========MovieDao========");
				System.out.println(movieCode);
				System.out.println(movieName);
				mainlist.add(new MainDto(movieCode, moviePhoto, plot, dolby, mx, movieName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mainlist;
	}

	// 영화정보 (인포)
	public ArrayList<MovieDto> movieinfo(String dto) {
		String sql = "select * from movie where movie_code = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String movieName = rs.getString("movie_name");
				Date openingDay = rs.getDate("opening_day");
				int runningTime = rs.getInt("running_time");
				String director = rs.getString("director");
				String rating = rs.getString("rating");
				String casting = rs.getString("casting");
				String moviePhoto = rs.getString("movie_photo");
				String plot = rs.getString("plot");
				String allType = rs.getString("alltype");
				String tag = rs.getString("tag");
				String engName = rs.getString("eng_name");
				String trailer = rs.getString("trailer");
				String trailerSub = rs.getString("trailer_sub");
				String stealcut = rs.getString("stealcut");
				String genre = rs.getString("genre");
				String miniTitle = rs.getString("mini_title");
				int dolby = rs.getInt("dolby");
				movieinfolist.add(new MovieDto("", movieName, openingDay, runningTime, director, rating, casting,
						moviePhoto, plot, allType, tag, engName, trailer, trailerSub, stealcut, genre, miniTitle, dolby,
						0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieinfolist;
	}
}
