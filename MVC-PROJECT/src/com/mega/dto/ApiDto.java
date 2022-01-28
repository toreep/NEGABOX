package com.mega.dto;

public class ApiDto {
		private String audiCnt;
		private String audiAcc;
		private String movieNm;
		
		public ApiDto() {}
		public ApiDto(String audiCnt, String audiAcc, String movieNm) {
			this.audiCnt = audiCnt;
			this.audiAcc = audiAcc;
			this.movieNm = movieNm;
		}
		public String getAudiCnt() {
			return audiCnt;
		}
		public void setAudiCnt(String audiCnt) {
			this.audiCnt = audiCnt;
		}
		public String getAudiAcc() {
			return audiAcc;
		}
		public void setAudiAcc(String audiAcc) {
			this.audiAcc = audiAcc;
		}
		public String getMovieNm() {
			return movieNm;
		}
		public void setMovieNm(String movieNm) {
			this.movieNm = movieNm;
		}
}
