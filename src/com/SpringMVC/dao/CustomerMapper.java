package com.SpringMVC.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.SpringMVC.entity.Customer;

public interface CustomerMapper {
	public List<Customer> getAllCustomer();

	public List<Customer> getCustomerbyName(@Param("userName")String userName);
}
