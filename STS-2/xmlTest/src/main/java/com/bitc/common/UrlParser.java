package com.bitc.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlParser {
	@Value("${custom.serviceKey}")
	private String serviceKey;

	private String endPoint = "http://openapi.data.go.kr/openapi/service/rest/Covid19";
	private String serviceFunc = "/getCovid19InfStateJson";
	private String keyFunc = "?serviceKey=";
	private String pageNo = "&pageNo=1";
	private String rows = "&numOfRows=10";
	private String startCreateDt = "&startCreateDt=";
	private String endCreateDt = "&endCreateDt=";

	public String getUrl(String startDt, String endDt) {
		String strUrl = endPoint + serviceFunc + keyFunc + serviceKey + pageNo + rows + startCreateDt + startDt
				+ endCreateDt + endDt;

		return strUrl;
	}

	public String getPharmacyUrl(String q0, String q1, String qT, String qN) {
		String q00 = null;
		String q01 = null;
		String q0N = null;
		
		try {
			q00 = URLEncoder.encode(q0, "UTF-8");
			q01 = URLEncoder.encode(q1, "UTF-8");
			q0N = URLEncoder.encode(qN, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		String endPoint = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService";
		String serviceFunc = "/getParmacyListInfoInqire";
		String keyFunc = "?serviceKey=";
		String Q0 = "&Q0=";
		String Q1 = "&Q1=";
		String QT = "&QT=";
		String QN = "&QN=";
		String ORD = "&ORD=NAME";
		String pageNo = "&pageNo=1";
		String rows = "&numOfRows=10";
		String serviceKey = "jTrcdKem5RUjq2w7BYfEe6F%2FWAJeveuQRbqFpw67CA1LrYeYLVjUv99EclTO45kB98rK3mmG5X6Qm32lHiHr%2Bw%3D%3D";

		String strUrl = endPoint + serviceFunc + keyFunc + serviceKey + Q0 + q00 + Q1 + q01 + QT + qT + QN + q0N + ORD
				+ pageNo + rows;

		return strUrl;
	}
}
