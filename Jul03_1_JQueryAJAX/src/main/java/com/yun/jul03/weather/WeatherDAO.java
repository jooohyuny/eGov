package com.yun.jul03.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	// 자바로 기상청XML 콘솔창에
	public String get(String zone) {
		HttpURLConnection huc = null;
		try {
			String s = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone="+zone;
			URL u = new URL(s);
			huc = (HttpURLConnection) u.openConnection();
			InputStreamReader isr = new InputStreamReader(huc.getInputStream(),"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StringBuffer sb = new StringBuffer();
			
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			String xml = sb.toString();
			return xml;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			huc.disconnect();
		}
		
	}
}
