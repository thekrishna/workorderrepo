package com.wava.ordermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.wava.ordermgmt.repository.OrderRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = OrderRepository.class)
public class WorkOrderMgmtApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkOrderMgmtApiApplication.class, args);
	}

}
