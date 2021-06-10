package com.udacity.pricing;

import com.udacity.pricing.Repository.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	PriceRepository priceRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getting_price_by_id() throws Exception {
		mockMvc.perform(get("/prices/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.vehicleId").exists())
				.andExpect(jsonPath("$.vehicleId").value(1));
	}

	@Test
	public void getting_all_prices() throws Exception {
		mockMvc.perform(get("/prices/"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._embedded").exists())
				.andExpect(jsonPath("$._embedded.prices").exists())
				.andExpect(jsonPath("$._embedded.prices", hasSize(19)));
	}





}
