package com.mege.controller;

import com.mega.action.Action;
import com.mega.action.AllmovieAction;
import com.mega.action.CheckEmailNumberAction;
import com.mega.action.FastRevAction;
import com.mega.action.InsertSeatsAction;
import com.mega.action.LoginCheckAction;
import com.mega.action.MainAction;
import com.mega.action.MovieInfoAction;
import com.mega.action.MovieTimeListAction;
import com.mega.action.RegisterAction;
import com.mega.action.ReviewAction;
import com.mega.action.SendEmailAction;
import com.mega.dao.LikeAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() { }
	
	static ActionFactory getInstance() {
		return instance;
	}
	// 싱글톤 패턴
	
	// getAction() : 파라미터로 전달받은 command 문자열의 내용에 따라
	//               해당하는 Action객체를 생성해서 참조값을 리턴.
	Action getAction(String command) {      // 예를 들어, command = "login"
		Action result = null;
		System.out.println("ActionFactory getAction()에서, command=" + command);
		// 예를 들어, "Controller?command=login" 이런 식으로 요청이 들어옴.
		switch(command) {
		case "login_check":
			result = new LoginCheckAction();
			break;
		case "main":
			result = new MainAction();
			break;
		case "allmovie":
			result = new AllmovieAction();
			break;
		case "LikeAction":
			result = new LikeAction();
			break;
		case "movieInfo":
			result = new MovieInfoAction();
			break;
		case "review":
			result = new ReviewAction();
			break;
		case "checkEmailNumber":
			result = new CheckEmailNumberAction();
			break;
		case "fastRev":
			result = new FastRevAction();
			break;
		case "insertSeats":
			result = new InsertSeatsAction();
			break;
		case "movieTimeList":
			result = new MovieTimeListAction();
			break;
		case "sendEmail":
			result = new SendEmailAction();
			break;
		case "register":
			result = new RegisterAction();
			break;
		}
		return result;
	}
}










