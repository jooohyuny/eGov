package com.yun.jul03.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {
	
	@Autowired
	private WeatherDAO wDAO;
	
	@RequestMapping(value = "/weather.get", method= RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody String weathertGet(
			@RequestParam(value="zone") String zone) {
		
		return wDAO.get(zone);
	}
}
