package com.mega.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.mega.action.Action;
import com.mega.action.DBConnection;
import com.mega.dto.MemberDto;

public class LikeAction implements Action {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<MemberDto> memberlist = new ArrayList<MemberDto>();
	ArrayList<MemberDto> member = new ArrayList<MemberDto>();
	
	@Override
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String loginId = (String)(session.getAttribute("id"));
		String movieCode = request.getParameter("movieCode");
		int heart = Integer.parseInt(request.getParameter("heart"));
		// TODO : DB처리. = insert/delete
		System.out.println(heart);
		String sql = "select * from want_to_watch where member_id = ? and movie_code = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		JSONObject obj = new JSONObject();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, movieCode);
			rs = pstmt.executeQuery();
			// true이면 '채워진 하트'로 만들어야 할 차례. false이면 '빈 하트'로 만들어야 할 차례.
			if(rs.next()) {
				heart -= 1;
				sql = "delete from want_to_watch where member_id = ? and movie_code = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, loginId);
				pstmt.setString(2, movieCode);
				pstmt.executeUpdate();
				obj.put("like", false);
				obj.put("likeHeart", heart);
				out.print(obj);
			} else {
				heart += 1;
				sql = "insert into want_to_watch(member_id,movie_code) values(?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, loginId);
				pstmt.setString(2, movieCode);
				pstmt.executeUpdate();
				obj.put("like", true);
				obj.put("likeHeart", heart);
				out.print(obj);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
