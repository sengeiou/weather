package com.vangaurd.coding.challenge.weather.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import com.vanguard.coding.challenge.weather.rest.domain.WeatherWrapper;
import com.vanguard.coding.challenge.weather.rest.entity.WeatherEntity;
import com.vanguard.coding.challenge.weather.rest.service.WeatherService;

@WebMvcTest
@ComponentScan(basePackages = "com.vanguard")
public class WeatherControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WeatherService weatherService;

	@Test
	public void testGetWeatherService() throws Exception {

		WeatherWrapper weatherWrapper = new WeatherWrapper();
		weatherWrapper.setDescription("Overcast clouds");
		
		WeatherEntity weatherEntity = new WeatherEntity();
		weatherEntity.setCountry("AU");
		weatherEntity.setCity("Melbourne");
		weatherEntity.setApiKey("123");

		Mockito.when(weatherService.getWeatherDetails(weatherEntity)).thenReturn(weatherWrapper);

		mockMvc.perform(get("/getWeatherDetails?city=Melbourne&country=AU&apiKey=123")).andExpect(status().isOk())
				.andExpect(jsonPath("description", Matchers.equalTo("Overcast clouds")));

	}

	@Test
	public void testGetWeatherService_negative_notFound() throws Exception {

		WeatherWrapper weatherWrapper = new WeatherWrapper();
		weatherWrapper.setDescription("Overcast clouds");

		Mockito.when(weatherService.getWeatherDetails(new WeatherEntity())).thenReturn(weatherWrapper);
		mockMvc.perform(get("/getWeathers")).andExpect(status().isNotFound());

	}

}
