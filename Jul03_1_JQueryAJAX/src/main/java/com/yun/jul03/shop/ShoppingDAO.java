package com.yun.jul03.shop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class ShoppingDAO {
	public String get(HttpServletRequest req) {
		HttpURLConnection huc = null;
		try {
			String q = req.getParameter("query");	
			String s = req.getParameter("start");
			String h1 = req.getHeader("ni");
			String h2 = req.getHeader("ns");
			
			String site = "https://openapi.naver.com/v1/search/shop.xml?query="+q +"&start="+s;
			URL u = new URL(site);
			huc = (HttpURLConnection) u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id",h1);
			huc.addRequestProperty("X-Naver-Client-Secret",h2);
			
			InputStreamReader isr = new InputStreamReader(huc.getInputStream(),"utf-8");
			BufferedReader br = new BufferedReader(isr);
			return br.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			huc.disconnect();
		}
	}
}
