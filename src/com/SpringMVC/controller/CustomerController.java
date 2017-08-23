package com.SpringMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.SpringMVC.entity.Customer;
import com.SpringMVC.service.ICustomerService;
import com.SpringMVC.util.PagedResult;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController{
	@Autowired
	ICustomerService cs;
	
	@RequestMapping(value="/list.do",method=RequestMethod.GET)
	public ModelAndView getAllCustomer(Model model){
		ModelAndView mv = new ModelAndView();
		List<Customer> clist = cs.getAllCustomer();
		mv.addObject("clist",clist);
		mv.setViewName("customer/customer");
		return mv;
	}
	
	@RequestMapping("/enterCust.do")
	public String enterCustomer(){
		return "customer/customer2";
	}
	

	
	@RequestMapping(value="/list1.do",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCustomerbyName(Integer pageNumber,Integer pageSize ,String userName){
		System.out.println("分页查询用户信息列表请求入参：pageNumber{},pageSize{}"+ pageNumber+" "+pageSize);
		
		PagedResult<Customer> clist = cs.getCustomerbyName(userName,pageNumber,pageSize);
		
		 return responseSuccess(clist);
	}
}
