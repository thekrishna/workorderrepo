package com.wava.order;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wava.ordermgmt.controller.WorkOrderApiController;
import com.wava.ordermgmt.model.Order;
import com.wava.ordermgmt.service.WorkOrderService;

@WebMvcTest(controllers = WorkOrderApiController.class)
public class OrderAPIControllerTest {

	private static final String CREATE_ORDER_JSON = "{\"orderDate\":\"\",  \"orderStatus\":\"\",  \"orderTotal\":\"8\",   \"channelType\": \"store\", "
			+ " \"orderLineItems\":[  {     \"id\":\"1\",      	\"orderDescription\":\"Spicy\", "
			+ "\"quantity\":\"1\",  \"price\":\"5\", \"topping1\":\"Onion\",      	\"topping2\":\"Pepper\",      	"
			+ "\"topping3\":\"Jalppino\",      	\"productCode\":\"VegPrizza\" },   	{      \"id\":\"2\",      	"
			+ "\"orderDescription\":\"Normal\",      	\"quantity\":\"1\",      	\"price\":\"3\",    "
			+ "  \"productCode\":\"SandWich\"	}   ]} ";

	private static final String ADD_URI = "/orders";
	private static final String GET_ALL_ORDERS_URI = "/orders";
	private static final String GET_ORDER_URI = "/orders/{orderId}";
	private static final String DELETE_ORDER_URI = "/orders/{orderId}";

	@InjectMocks
	private WorkOrderApiController orderController;

	private MockMvc mockMvc;

	@Mock
	private WorkOrderService workOrderService;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateOrder_201() throws Exception {
		final Order expectedOrder = getObjectMapper().readValue(CREATE_ORDER_JSON, Order.class);

		when(workOrderService.saveOrder(any(Order.class))).thenReturn(expectedOrder);

		mockMvc.perform(post(ADD_URI).content(CREATE_ORDER_JSON).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andDo(print()).andExpect(status().isCreated());

		verify(workOrderService).saveOrder(any(Order.class));
	}

	@Test
	public void testGetOrder_200() throws Exception {
		final long orderId = Long.valueOf("1");
		final Order expectedOrder = getObjectMapper().readValue(CREATE_ORDER_JSON, Order.class);
		
		when(workOrderService.findOrderById(any(Long.class))).thenReturn(expectedOrder);
		
		mockMvc.perform(get(GET_ORDER_URI,orderId).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print())
			.andExpect(status().isOk());
		
		verify(workOrderService).findOrderById(any(Long.class));
	}
	
	@Test
	public void testGetAllOrders_200() throws Exception {
		final Order expectedOrder = getObjectMapper().readValue(CREATE_ORDER_JSON, Order.class);
		List<Order> expectedOrders = new ArrayList<>();
		expectedOrders.add(expectedOrder);
		
		when(workOrderService.getAllOrders()).thenReturn(expectedOrders);
		
		mockMvc.perform(get(GET_ALL_ORDERS_URI).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print())
			.andExpect(status().isOk());
		
		verify(workOrderService).getAllOrders();
	}
	
	@Test
	public void testDeleteOrder_200() throws Exception {
		final long orderId = Long.valueOf("1");
		doNothing().when(workOrderService).deleteOrder(any(Long.class));
		
		mockMvc.perform(get(DELETE_ORDER_URI,orderId).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print())
			.andExpect(status().isOk());
		
		verify(workOrderService).findOrderById(any(Long.class));
	}
	

	private static ObjectMapper getObjectMapper() {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			return mapper;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}