package com.wava.order;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

//import com.wava.order.model.Order;

import junit.framework.Assert;


	@RunWith(SpringRunner.class)
	@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
	public class WorkOrderMgmtApiApplicationTests 
	{
		
		private static final String CREATE_ORDER_JSON = "{\"orderDate\":\"\",  \"orderStatus\":\"\",  \"orderTotal\":\"8\",   \"channelType\": \"store\", "
				+ " \"orderLineItems\":[  {     \"orderLineItemNumber\":\"1\",      	\"orderDescription\":\"Spicy\", "
				+ "\"quantity\":\"1\",  \"price\":\"5\", \"topping1\":\"Onion\",      	\"topping2\":\"Pepper\",      	"
				+ "\"topping3\":\"Jalppino\",      	\"productCode\":\"VegPrizza\" },   	{      \"orderLineItemNumber\":\"2\",      	"
				+ "\"orderDescription\":\"Normal\",      	\"quantity\":\"1\",      	\"price\":\"3\",    "
				+ "  \"productCode\":\"SandWich\"	}   ]} ";

	    @Autowired
	    private TestRestTemplate restTemplate;
	     
	    @LocalServerPort
	    int randomServerPort;
	    

        @Autowired
    	ResourceLoader resourceLoader;
	 
	    @Test
	    public void testCreateOrder() throws URISyntaxException 
	    
	    
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/ordermgmt/order/";
	        
	        ClassPathResource res = new ClassPathResource("createOrder.json");    
	        File file = new File(res.getPath());
	        
	        String content = file.getAbsolutePath();
			
	        URI uri = new URI(baseUrl);
	    
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true");      
	 
	       // HttpEntity<Order> request = new HttpEntity<>(order, headers);
	         
	       // ResponseEntity<String> result = this.restTemplate.postForEntity(uri, content, String.class);
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, content.toString(), String.class);
	         
	        //Verify request succeed
	        Assert.assertEquals(201, result.getStatusCodeValue());
	    }
	}