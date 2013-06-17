package com.ruyicai.systemmanage.dao;

import com.ruyicai.common.dao.IBaseDao;
import com.ruyicai.systemmanage.domain.User;

public interface UserDao extends IBaseDao<User> {
	public User findUserByName(String name);
}
