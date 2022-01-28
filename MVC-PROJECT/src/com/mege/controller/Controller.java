package com.mege.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mega.action.Action;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청은 예를 들어, "Controller?command=login"
		request.setCharacterEncoding("UTF-8");
		Action action = null;
		ActionFactory af = ActionFactory.getInstance();
		String command = request.getParameter("command");
		action = af.getAction(command);
		try {
			if(action != null)
				action.execute(request, response);
		} catch(Exception e) { e.printStackTrace(); }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}







