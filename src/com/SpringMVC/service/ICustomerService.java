package com.SpringMVC.service;

import java.util.List;

import com.SpringMVC.entity.Customer;
import com.SpringMVC.util.PagedResult;

public interface ICustomerService {
	
	public List<Customer> getAllCustomer();

	public PagedResult<Customer> getCustomerbyName(String userName, Integer pageNumber, Integer pageSize);
}
