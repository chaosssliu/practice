package net.antra.deptemp.service;

import net.antra.deptemp.ws.ArrayOfForecast;

public interface WeatherDelegateService {
	String getWeatherByZip(String zip);
	ArrayOfForecast getWeatherForcastByZip(String zip);
}
