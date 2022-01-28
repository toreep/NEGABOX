package com.mega.dto;

import java.util.Date;

public class MovieDto {
	private String movieCode;
	private String movieName;
	private Date openingDay;
	private int runningTime;
	private String director;
	private String rating;
	private String casting;
	private String moviePhoto;
	private String plot;
	private String allType;
	private String tag;
	private String engName;
	private String traler;
	private String tralerSub;
	private String stealCut;
	private String genre;
	private String mini_title;
	private int dolby;
	private int mx;
	
	public MovieDto() {}
	public MovieDto(String movieCode, String movieName, Date openingDay, int runningTime, String director,
			String rating, String casting, String moviePhoto, String plot, String allType, String tag, String engName,
			String traler, String tralerSub, String stealCut, String genre, String mini_title, int dolby, int mx) {
		super();
		this.movieCode = movieCode;
		this.movieName = movieName;
		this.openingDay = openingDay;
		this.runningTime = runningTime;
		this.director = director;
		this.rating = rating;
		this.casting = casting;
		this.moviePhoto = moviePhoto;
		this.plot = plot;
		this.allType = allType;
		this.tag = tag;
		this.engName = engName;
		this.traler = traler;
		this.tralerSub = tralerSub;
		this.stealCut = stealCut;
		this.genre = genre;
		this.mini_title = mini_title;
		this.dolby = dolby;
		this.mx = mx;
	}
	public String getMovieCode() {
		return movieCode;
	}
	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getOpeningDay() {
		return openingDay;
	}
	public void setOpeningDay(Date openingDay) {
		this.openingDay = openingDay;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCasting() {
		return casting;
	}
	public void setCasting(String casting) {
		this.casting = casting;
	}
	public String getMoviePhoto() {
		return moviePhoto;
	}
	public void setMoviePhoto(String moviePhoto) {
		this.moviePhoto = moviePhoto;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getAllType() {
		return allType;
	}
	public void setAllType(String allType) {
		this.allType = allType;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getTraler() {
		return traler;
	}
	public void setTraler(String traler) {
		this.traler = traler;
	}
	public String getTralerSub() {
		return tralerSub;
	}
	public void setTralerSub(String tralerSub) {
		this.tralerSub = tralerSub;
	}
	public String getStealCut() {
		return stealCut;
	}
	public void setStealCut(String stealCut) {
		this.stealCut = stealCut;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMini_title() {
		return mini_title;
	}
	public void setMini_title(String mini_title) {
		this.mini_title = mini_title;
	}
	public int getDolby() {
		return dolby;
	}
	public void setDolby(int dolby) {
		this.dolby = dolby;
	}
	public int getMx() {
		return mx;
	}
	public void setMx(int mx) {
		this.mx = mx;
	}
	
}
