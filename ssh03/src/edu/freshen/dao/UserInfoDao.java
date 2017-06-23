package edu.freshen.dao;

import edu.freshen.entity.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {

	/**
	 * 账号登录方法，
	 * @param ln ，lp 账号和密码
	 * @return 账号对象
	 */
	public UserInfo login(String ln,String lp);
	
	/**
	 * 检测  账户是否存在
	 * @param ln 账号
	 * @return  存在返回true，否则返回false
	 */
	public boolean loingNameExist(String ln);
	
	
}
