package com.wava.order;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.wava.ordermgmt.WorkOrderMgmtApiApplication;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WorkOrderMgmtApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkOrderMgmtApiApplicationTests {

	private static final String CREATE_ORDER_JSON = "{\"orderDate\":\"\",  \"orderStatus\":\"\",  \"orderTotal\":\"8\",   \"channelType\": \"store\", "
			+ " \"orderLineItems\":[  {     \"orderLineItemNumber\":\"1\",      	\"orderDescription\":\"Spicy\", "
			+ "\"quantity\":\"1\",  \"price\":\"5\", \"topping1\":\"Onion\",      	\"topping2\":\"Pepper\",      	"
			+ "\"topping3\":\"Jalppino\",      	\"productCode\":\"VegPrizza\" },   	{      \"orderLineItemNumber\":\"2\",      	"
			+ "\"orderDescription\":\"Normal\",      	\"quantity\":\"1\",      	\"price\":\"3\",    "
			+ "  \"productCode\":\"SandWich\"	}   ]} ";


	@LocalServerPort
	int randomServerPort;

	TestRestTemplate restTemplate = new TestRestTemplate();
	//HttpHeaders headers = new HttpHeaders();

	@Test
	public void testCreateOrder() throws URISyntaxException    {


		final String baseUrl = "http://localhost:"+randomServerPort+"/orders";
		URI uri = new URI(baseUrl);


		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true"); 
		headers.setContentType(MediaType.APPLICATION_JSON);	        


		HttpEntity<String> request = new HttpEntity<>(CREATE_ORDER_JSON.toString(), headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		Assert.assertEquals(201, result.getStatusCodeValue());
	}	    


}
