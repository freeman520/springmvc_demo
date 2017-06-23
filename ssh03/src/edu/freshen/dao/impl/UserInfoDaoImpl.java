package edu.freshen.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.freshen.dao.UserInfoDao;
import edu.freshen.entity.UserInfo;
@Scope("prototype")
@Repository("userInfoDao")
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao {

	@Override
	public UserInfo login(String ln, String lp) {
		String hql = "from UserInfo u where u.loginName=? and u.loginPwd=?";
		Query query = sf.getCurrentSession().createQuery(hql);
		query.setString(0, ln);
		query.setString(1, lp);
		return (UserInfo) query.uniqueResult();
	}

	@Override
	public boolean loingNameExist(String ln) {
		String hql = "from UserInfo u where u.loginName=?";
		Query query = sf.getCurrentSession().createQuery(hql);
		query.setString(0, ln);
		if(query.uniqueResult()!=null){
			return true;
		}else
			return false;
	}

}
