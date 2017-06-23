package edu.freshen.service;

import edu.freshen.dao.UserInfoDao;
import edu.freshen.entity.UserInfo;

public class UserInfoService {
	private UserInfoDao userInfoDao;
	
	/**
	 * 新增账号的逻辑
	 * @param user 
	 * @return 1 成功，0失败  -2 账号存在
	 */
	public int insertUserInfo(UserInfo user){
		int r=1;
		if(userInfoDao.loingNameExist(user.getLoginName())){
			r=-2;
		}else{
			r=userInfoDao.insertEntity(user);
		}
		return r;
	}
	
	public int deleteUserInfo(UserInfo user){
		return userInfoDao.deleteEntity(UserInfo.class, user.getId());
	}
	public int updateUserInfo(UserInfo user){
		return userInfoDao.updateEntity(user, user.getId());
	}
	
	public UserInfo loginCheck(String ln,String lp){
		return userInfoDao.login(ln, lp);
	}

	public UserInfoDao getDao() {
		return userInfoDao;
	}

	public void setDao(UserInfoDao dao) {
		this.userInfoDao = dao;
	}

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
	
}
