package com.ruyicai.systemmanage.service;

import java.util.List;

import com.ruyicai.systemmanage.domain.User;

public interface UserService {
	public void save(Object obj);

	public void update(User user);

	public void updateBySelf(User user);

	public void delete(String ids);

	public void deleteById(Long id);

	public User findById(Long id);

	public User findByName(String name);
	public String getUsername(String workid);
	public List<User> getListByConditionPerPage(String hql, int start, int limit);
	public List<User> findAll();
	public long getCountByCondition(String hql);
}
