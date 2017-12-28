package com.SpringMVC.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.SpringMVC.dao.UserMapper;

//http://blog.csdn.net/u012367513/article/details/38866465
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	UserMapper userDao;
	
	
	//登陆验证时，通过username获取用户的所有权限信息，  
    @SuppressWarnings("deprecation")
	//并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority auth2 = new SimpleGrantedAuthority("ROLE_USER");
		SimpleGrantedAuthority auth1 = new SimpleGrantedAuthority("ROLE_ADMIN");
		
		//获取角色标志  
        String roletype = username.substring(0,3);  
        username = username.substring(3);  
        String password = "";  
		
		com.SpringMVC.entity.User dbuser = userDao.findUserByName(username);
		if(dbuser!=null){
		switch(roletype){
		case "adm":
			
			password = dbuser.getPassword();
			auths.add(auth1);
			break;
		case "usr":
		
			password = dbuser.getPassword();
			auths.add(auth2);
			break;
		}
		}else{
			throw new UsernameNotFoundException("Username not find");
		}
		
		User user = new User(username,password,true,true,true,true,auths);
		return user;
	}

}
