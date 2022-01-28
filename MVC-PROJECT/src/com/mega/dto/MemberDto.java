package com.mega.dto;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String birthday;
	private String address;
	private String photo;
	private int point;
	private int administrator;
	
	public MemberDto() {}
	public MemberDto(String id, String pw, String name, String email, String phone, String birthday, String address,
			String photo, int point, int administrator) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.address = address;
		this.photo = photo;
		this.point = point;
		this.administrator = administrator;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getAdministrator() {
		return administrator;
	}
	public void setAdministrator(int administrator) {
		this.administrator = administrator;
	}
	
	
	
}








