package com.wava.ordermgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wava.ordermgmt.model.OrderLineItem;

@Repository
public interface OrderLineItemRepository extends CrudRepository<OrderLineItem,Long>{

}
