package com.assignment.mathwebservice.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MathOperationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAddAPI_WhenOperandValue_IsInteger() throws Exception {
		String jsonString = "{\r\n" + 
				"    \"x\": \"100\",\r\n" + 
				"    \"y\": \"50\"\r\n" + 
				"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/add").accept(MediaType.APPLICATION_JSON)
				.content(jsonString).contentType(MediaType.APPLICATION_JSON)
				.with(httpBasic("manoj","gupta"));

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"result\":\"150\"}";

		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		assertEquals(expected, result.getResponse().getContentAsString());
	}

	@Test
	public void testAddAPI_WhenOperandValue_IsDouble() throws Exception {

		String jsonString = "{\r\n" + 
				"    \"x\": \"100.50\",\r\n" + 
				"    \"y\": \"50.20\"\r\n" + 
				"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/add").accept(MediaType.APPLICATION_JSON)
				.content(jsonString).contentType(MediaType.APPLICATION_JSON)
				.with(httpBasic("manoj","gupta"));

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"result\":\"150.70\"}";

		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		assertEquals(expected, result.getResponse().getContentAsString());
	}

	@Test
	public void testDiffAPI_WhenOperandValue_IsInteger() throws Exception {

		String jsonString = "{\r\n" + 
				"    \"x\": \"100\",\r\n" + 
				"    \"y\": \"50\"\r\n" + 
				"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/diff").accept(MediaType.APPLICATION_JSON)
				.content(jsonString).contentType(MediaType.APPLICATION_JSON)
				.with(httpBasic("manoj","gupta"));

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"result\":\"50\"}";
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		assertEquals(expected, result.getResponse().getContentAsString());
	}

	@Test
	public void testDiffAPI_WhenOperandValue_IsDouble() throws Exception {
		String jsonString = "{\r\n" + 
				"    \"x\": \"100.50\",\r\n" + 
				"    \"y\": \"50.25\"\r\n" + 
				"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/diff").accept(MediaType.APPLICATION_JSON)
				.content(jsonString).contentType(MediaType.APPLICATION_JSON)
				.with(httpBasic("manoj","gupta"));

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"result\":\"50.25\"}";
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		assertEquals(expected, result.getResponse().getContentAsString());
	}

	@Test
	public void call_api_without_authentication() throws Exception {
		String jsonString = "{\r\n" + 
				"    \"x\": \"100.50\",\r\n" + 
				"    \"y\": \"50.25\"\r\n" + 
				"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/diff").accept(MediaType.APPLICATION_JSON)
				.content(jsonString).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "HTTP Status 401 - Full authentication is required to access this resource\r\n";

		assertEquals(HttpStatus.UNAUTHORIZED.value(), result.getResponse().getStatus());
		assertEquals(expected, result.getResponse().getContentAsString());

	}

	@Test
	public void call_Api_With_Incorect_Credential() throws Exception {
		String jsonString = "{\r\n" + 
				"    \"x\": \"100.50\",\r\n" + 
				"    \"y\": \"50.25\"\r\n" + 
				"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/diff").accept(MediaType.APPLICATION_JSON)
				.content(jsonString).contentType(MediaType.APPLICATION_JSON)
				.with(httpBasic("manoj","gupta1"));

		String expected = "HTTP Status 401 - Bad credentials\r\n";

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertEquals(HttpStatus.UNAUTHORIZED.value(), result.getResponse().getStatus());
		assertEquals(expected, result.getResponse().getContentAsString());
	}
}
