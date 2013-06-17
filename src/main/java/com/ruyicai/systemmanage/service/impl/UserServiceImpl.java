package com.ruyicai.systemmanage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruyicai.common.utils.Utils;
import com.ruyicai.common.utils.encode.MD5Util;
import com.ruyicai.systemmanage.dao.UserDao;
import com.ruyicai.systemmanage.domain.User;
import com.ruyicai.systemmanage.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService ,UserDetailsService{
	public static final String USER_NOT_EXIST_MSG = "用户名不存在";
	@Resource
	private UserDao userDao;
	private static List<User> users = null;
	private static Map<String,String> userMaps = null;
	@Override
	@Transactional(readOnly = false)
	public void save(Object obj) {
		userDao.save(obj);
		users = null;
	}

	@Override
	public void update(User user) {
		user.setPassword(MD5Util.md5Digest(user.getPassword()));
		userDao.update(user);
		users = null;
	}

	@Override
	public void updateBySelf(User user) {
		userDao.update(user);
		users = null;
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(String ids) {
		userDao.deleteByIds(ids);
		users = null;
	}

	@Override
	public void deleteById(Long id) {
		userDao.deleteByIds(id + "");
		users = null;
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id + "");
	}

	@Override
	public User findByName(String name) {
		return userDao.findUserByName(name);
	}

	@Transactional(readOnly = false)
	public List<User> getListByConditionPerPage(String hql, int start, int limit) {
		return userDao.getListByConditionPerPage(hql, start, limit);
	}

	@Transactional(readOnly = false)
	public long getCountByCondition(String hql) {
		return userDao.getCountByCondition(hql);
	}
	public List<User> findAll(){
		if(Utils.listIsNull(users)){
	    	 users=  userDao.findAll();
	    	 userMaps=new HashMap<String,String>();
	    		for(User b:users){
	    			userMaps.put(b.getWorkid(), b.getName());
	    		}
	    	}
	    return users;
	}
	public String getUsername(String workid){
		if(Utils.listIsNull(users)) findAll();
    	return userMaps.get(workid);
	}
	/**
	 * 这个实现主要从数据库读入用户的密码角色和是否锁定过期等信息
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		User user = userDao.findUserByName(username);
		if (user == null) {
			throw new UsernameNotFoundException(USER_NOT_EXIST_MSG);
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRoleId()+""));
		user.setAuthorities(authorities);
		return user;
	}
}
