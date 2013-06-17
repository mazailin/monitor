package com.ruyicai.systemmanage.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ruyicai.common.dao.impl.BaseDaoImpl;
import com.ruyicai.systemmanage.dao.UserDao;
import com.ruyicai.systemmanage.domain.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findUserByName(String name) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("name", name));
		List<User> list = (List<User>) this.getHibernateTemplate()
				.findByCriteria(criteria);
		if (null != list && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
