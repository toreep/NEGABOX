package com.mega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mega.action.DBConnection;
import com.mega.dto.ReviewDto;

public class ReviewDao {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 영화별 관람평 갯수
	public int reviewCount(String dto) {
		String sql = "select count(*) from review where movie_code = ?";
		int reviewCount = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto);
			rs = pstmt.executeQuery();
			if (rs.next())
				;
			reviewCount = rs.getInt("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewCount;
	}

	// 영화 관람평 차트 점수
	public ArrayList<Integer> chartResult(String dto) {
		ArrayList<Integer> chartscore = new ArrayList<Integer>();
		String sql = "select count(*) story, "
				+ "(select count(*) from review where viewing_points like '%연출%' GROUP by movie_code HAVING movie_code = ?) production, "
				+ "(select count(*) from review where viewing_points like '%OST%' GROUP by movie_code HAVING movie_code = ?) ost, "
				+ "(select count(*) from review where viewing_points like '%영상미%' GROUP by movie_code HAVING movie_code = ?) visual, "
				+ "(select count(*) from review where viewing_points like '%배우%' GROUP by movie_code HAVING movie_code = ?) actor "
				+ "from review where viewing_points like '%스토리%' GROUP by movie_code HAVING movie_code = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto);
			pstmt.setString(2, dto);
			pstmt.setString(3, dto);
			pstmt.setString(4, dto);
			pstmt.setString(5, dto);

			rs = pstmt.executeQuery();
			if (rs.next()) {

				int chartStory = rs.getInt("story");
				int chartProduction = rs.getInt("production");
				int chartOst = rs.getInt("ost");
				int chartVisual = rs.getInt("visual");
				int chartActor = rs.getInt("actor");

				chartscore.add(chartStory);
				chartscore.add(chartProduction);
				chartscore.add(chartOst);
				chartscore.add(chartVisual);
				chartscore.add(chartActor);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return chartscore;
	}

	// 리뷰
	public ArrayList<ReviewDto> listReview(String dto) {
		ArrayList<ReviewDto> listReview = new ArrayList<ReviewDto>();
		String sql = "select * from review where movie_code = ? order by write_date desc";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String memberId = rs.getString("member_id");
				int score = rs.getInt("score");
				String reviewText = rs.getString("review_text");
				String viewingPoints = rs.getString("viewing_points");
				int report = rs.getInt("report");
				String movieCode = rs.getString("movie_code");
				Date writeDate = rs.getTimestamp("write_date");
				listReview.add(new ReviewDto(memberId, score, reviewText, viewingPoints, report, movieCode, writeDate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listReview;

	}

	public void updateReview(ReviewDto dto) {
		String sql = "INSERT INTO review(member_id,score,review_text,viewing_points,movie_code) VALUES(?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setInt(2, dto.getScore());
			pstmt.setString(3, dto.getReviewText());
			pstmt.setString(4, dto.getViewingPoints());
			pstmt.setString(5, dto.getMovieCode());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
