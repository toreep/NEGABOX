package com.mega.dto;

public class ExitDoorDto {
	private String direction;
	private String x_left; 
	private String y_top;
	
	public ExitDoorDto() {}
	public ExitDoorDto(java.lang.String direction, java.lang.String x_left, java.lang.String y_top) {
		super();
		this.direction = direction;
		this.x_left = x_left;
		this.y_top = y_top;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getX_left() {
		return x_left;
	}
	public void setX_left(String x_left) {
		this.x_left = x_left;
	}
	public String getY_top() {
		return y_top;
	}
	public void setY_top(String y_top) {
		this.y_top = y_top;
	}
}
