package com.wava.ordermgmt.controller;

import org.springframework.web.bind.annotation.RestController;
import com.wava.ordermgmt.service.WorkOrderService;

@RestController
public class WorkOrderApiController {
	private WorkOrderService workOrderService;
	
	public WorkOrderApiController(WorkOrderService workOrderService){
		this.workOrderService = workOrderService;
	}

}
