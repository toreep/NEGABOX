package com.mega.dto;

public class ListDistrictTheaterCountDto {
	private String Area;
	private int AreaCount;
	
	public ListDistrictTheaterCountDto() {}
	public ListDistrictTheaterCountDto(String area, int areaCount) {
		super();
		Area = area;
		AreaCount = areaCount;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public int getAreaCount() {
		return AreaCount;
	}
	public void setAreaCount(int areaCount) {
		AreaCount = areaCount;
	}
}
