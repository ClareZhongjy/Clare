package com.SpringMVC.security;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringMVC.dao.UserMapper;
import com.SpringMVC.entity.User;




@Service("customUserDetailsService")
public class CustomUserDetailConfig implements UserDetailsService {


	@Autowired
	UserMapper userDao;
	
	
	
	

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException , DataAccessException{
		User customUser =null;
//		System.out.println(ssoId);
//		UserJDBC userDao = new UserJDBC();
		try {
			customUser= userDao.findUserByName(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(customUser==null){
			throw new UsernameNotFoundException("Username not found");
		}
		List<GrantedAuthority> auths = getGrantedAuthorities(customUser);
		org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(customUser.getUserName(),customUser.getPassword(), true, true, true, true, auths);
		return securityUser;
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		String[] dbAuths = user.getRole().split(",");
		for(String role:dbAuths){
			auths.add(new SimpleGrantedAuthority("ROLE_"+role));
		}

		return auths;
		
	}
	
	

}
