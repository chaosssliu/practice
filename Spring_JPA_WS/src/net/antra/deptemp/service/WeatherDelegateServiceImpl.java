package net.antra.deptemp.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.deptemp.ws.ArrayOfForecast;
import net.antra.deptemp.ws.ForecastReturn;
import net.antra.deptemp.ws.Weather;
import net.antra.deptemp.ws.WeatherReturn;
import net.antra.deptemp.ws.WeatherSoap;

@Service("weatherService")
public class WeatherDelegateServiceImpl implements WeatherDelegateService {
	@Autowired
	private Weather weather;
	
	private WeatherSoap weatherService;
	@PostConstruct
	private void init(){
		weatherService = weather.getWeatherSoap();
	}
	@Override
	public String getWeatherByZip(String zip) {
		WeatherReturn res = weatherService.getCityWeatherByZIP(zip);
		return "The weather in "+res.getCity() + ", " + res.getState() + " is " + res.getDescription() +". Temprature is " + res.getTemperature() + "F. Humidity is " + res.getRelativeHumidity() + ".";
	}

	@Override
	public ArrayOfForecast getWeatherForcastByZip(String zip) {
		ForecastReturn res = weatherService.getCityForecastByZIP(zip);
		return res.getForecastResult();
	}
	
}
