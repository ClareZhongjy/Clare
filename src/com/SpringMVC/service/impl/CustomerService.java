package com.SpringMVC.service.impl;

import java.util.List;
import com.SpringMVC.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringMVC.dao.CustomerMapper;
import com.SpringMVC.entity.Customer;
import com.SpringMVC.service.ICustomerService;
import com.SpringMVC.util.PagedResult;
import com.github.pagehelper.PageHelper;


@Service("customerService")
public class CustomerService implements ICustomerService{

	@Autowired
	CustomerMapper cdao;
	
	public List<Customer> getAllCustomer() {
		
		return cdao.getAllCustomer();
	}



	@Override
	public PagedResult<Customer> getCustomerbyName(String userName, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return BeanUtil.toPagedResult(cdao.getCustomerbyName(userName));
	
	}

}
