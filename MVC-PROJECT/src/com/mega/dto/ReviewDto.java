package com.mega.dto;

import java.util.Date;

public class ReviewDto {
	private String memberId;
	private int score;
	private String reviewText;
	private String viewingPoints;
	private int report;
	private String movieCode;
	private Date writeDate;
	
	public ReviewDto() {}
	public ReviewDto(String memberId, int score, String reviewText, String viewingPoints, int report, String movieCode,
			Date writeDate) {
		this.memberId = memberId;
		this.score = score;
		this.reviewText = reviewText;
		this.viewingPoints = viewingPoints;
		this.report = report;
		this.movieCode = movieCode;
		this.writeDate = writeDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public String getViewingPoints() {
		return viewingPoints;
	}
	public void setViewingPoints(String viewingPoints) {
		this.viewingPoints = viewingPoints;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public String getMovieCode() {
		return movieCode;
	}
	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
