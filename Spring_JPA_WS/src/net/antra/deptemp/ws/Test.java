package net.antra.deptemp.ws;

public class Test {

	public static void main(String[] args) {
		Weather weather = new Weather();
		WeatherSoap weatherService = weather.getWeatherSoap();
		WeatherReturn res = weatherService.getCityWeatherByZIP("20165");
		System.out.println(res.getState());
	}

}
