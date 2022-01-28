package com.mega.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mega.dao.MemberDao;
import com.mega.dto.MemberDto;

public class LoginCheckAction implements Action {
	MemberDao mDao = new MemberDao();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		System.out.println("로그인체크 id : " + id);
		String pw = request.getParameter("pw");
		System.out.println("로그인체크 pw : " + pw);
		int point = 0;
		String name = "";
		String email = "";
		String phone = "";
		String birthday = "";
		String address = "";
		String photo = "";
		int admin = 0;
		
		if(mDao.loginCheck(new MemberDto(id,pw,"","","","","","",0,0))) {
			
			for(MemberDto vo : mDao.member(new MemberDto(id,"","","","","","","",0,0))) {
				name = vo.getName();
				point = vo.getPoint();
				email = vo.getEmail();
				phone = vo.getPhone();
				birthday = vo.getBirthday();
				address = vo.getAddress();
				photo = vo.getPhoto();
				admin = vo.getAdministrator();
			}
			
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			session.setAttribute("phone", phone);
			session.setAttribute("birthday", birthday);
			session.setAttribute("address", address);
			session.setAttribute("photo", photo);
			session.setAttribute("admin", admin);
			
			if(admin == 1) {
				request.getRequestDispatcher("admin_page.jsp").forward(request, response);
			} else {
			request.getRequestDispatcher("Controller?command=main").forward(request, response);
			}
		}	else {
			request.getRequestDispatcher("login_failure.jsp").forward(request, response);
		}
	}
}

