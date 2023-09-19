package com.yun.gbraucp.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {
	public static void getCurYear(HttpServletRequest req) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String cy = sdf.format(new Date());
		int cy2 = Integer.parseInt(cy);
		req.setAttribute("cy", cy2);
	}
}
