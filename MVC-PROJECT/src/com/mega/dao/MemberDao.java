package com.mega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mega.action.DBConnection;
import com.mega.dto.MemberDto;

public class MemberDao {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<MemberDto> memberlist = new ArrayList<MemberDto>();
	ArrayList<MemberDto> member = new ArrayList<MemberDto>();
	
	
	// 로그인 체크!
	public boolean loginCheck(MemberDto dto) {
		
		String sql = "SELECT count(*) FROM membervo WHERE member_id=? AND pw=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int ret = rs.getInt(1);
				if (ret == 1)
					return true;
				else
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	// 로그인 회원 정보
	public ArrayList<MemberDto> member(MemberDto dto) {
		String sql = "select * from membervo where member_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("member_id");
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String birthday = rs.getString("birthday");
				String address = rs.getString("address");
				String photo = rs.getString("photo");
				int point = rs.getInt("point");
				int administrator = rs.getInt("administrator");
				member.add(new MemberDto(id,pw,name,email,phone,birthday,address,photo,point,administrator));
			} else return member = null;
		} catch (SQLException e) {
			e.printStackTrace();
		} return member;
	}
}
