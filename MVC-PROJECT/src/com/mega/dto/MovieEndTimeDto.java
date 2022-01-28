package com.mega.dto;

public class MovieEndTimeDto {
	private String time;
	private int runningTime;
	private String endTime;
	
	public MovieEndTimeDto() {}
	public MovieEndTimeDto(java.lang.String time, int runningTime, java.lang.String endTime) {
		super();
		this.time = time;
		this.runningTime = runningTime;
		this.endTime = endTime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
