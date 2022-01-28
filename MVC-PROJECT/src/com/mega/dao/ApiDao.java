package com.mega.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mega.dto.ApiDto;

public class ApiDao {

	// 영화Api(메인)
	public ArrayList<ApiDto> movieApi() {
		// api 날짜 7일전 기준
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		SimpleDateFormat df = new SimpleDateFormat("YYYYMMdd");
		cal.add(Calendar.DATE, -7);
		String weeklyday = df.format(cal.getTime());
		System.out.println(weeklyday);

		ArrayList<ApiDto> apiList = new ArrayList<ApiDto>();

		// api 파싱
		try {
			String apiurl = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=9cdf19c7cea4d9369ab54dce5a79fd75&targetDt="
					+ weeklyday + "&itemPerPage=4";

			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(apiurl);

			// root tag
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			// 파싱할 tag
			NodeList nList = doc.getElementsByTagName("weeklyBoxOffice");
			NodeList movieNm = doc.getElementsByTagName("movieNm");
			NodeList audiAcc = doc.getElementsByTagName("audiAcc");
			NodeList audiCnt = doc.getElementsByTagName("audiCnt");
			// System.out.println("파싱할 리스트 수 : "+ nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node movieApi = movieNm.item(temp);
				Node accApi = audiAcc.item(temp);
				Node cntApi = audiCnt.item(temp);
				Element e1 = (Element) movieApi;
				Element e2 = (Element) accApi;
				Element e3 = (Element) cntApi;
				System.out.println("######################");

				System.out.println(e1.getTextContent());
				System.out.println(e2.getTextContent());
				System.out.println(e3.getTextContent());
				apiList.add(new ApiDto(e3.getTextContent(), e2.getTextContent(), e1.getTextContent()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiList;
	}

	
	// 영화Api(전체영화)
	public ArrayList<ApiDto> allmovieApi() {
		// api 날짜 구하기
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		SimpleDateFormat df = new SimpleDateFormat("YYYYMMdd");
		cal.add(Calendar.DATE, -7);
		String weeklyday = df.format(cal.getTime());
		ArrayList<ApiDto> apiList = new ArrayList<ApiDto>();
		int pip = 0;
		try {
			// parsing할 url 지정(API 키 포함해서)
			String apiurl = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=9cdf19c7cea4d9369ab54dce5a79fd75&targetDt="
					+ weeklyday;

			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(apiurl);

			// root tag

			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			// 파싱할 tag
			NodeList nList = doc.getElementsByTagName("weeklyBoxOffice");
			NodeList movieNm = doc.getElementsByTagName("movieNm");
			NodeList audiAcc = doc.getElementsByTagName("audiAcc");
			NodeList audiCnt = doc.getElementsByTagName("audiCnt");
			// System.out.println("파싱할 리스트 수 : "+ nList.getLength());

			String[] Narr = new String[10];
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node movieApi = movieNm.item(temp);
				Node accApi = audiAcc.item(temp);
				Node cntApi = audiCnt.item(temp);
				Element e1 = (Element) movieApi;
				Element e2 = (Element) accApi;
				Element e3 = (Element) cntApi;
				System.out.println("######################");
				Narr[temp] = e1.getTextContent();

				pip += Integer.parseInt(e2.getTextContent());
				System.out.println(e1.getTextContent());
				System.out.println(e2.getTextContent());
				System.out.println(e3.getTextContent());
				apiList.add(new ApiDto(e3.getTextContent(), e2.getTextContent(), e1.getTextContent()));
				// for end
			} // if end

		} catch (Exception e) {
			e.printStackTrace();
		} return apiList;
	}
}
