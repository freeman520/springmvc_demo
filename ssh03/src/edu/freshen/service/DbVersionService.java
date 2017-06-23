package edu.freshen.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.freshen.dao.DbVersionDao;
import edu.freshen.entity.DbVersion;
public class DbVersionService {
	private DbVersionDao dbVersionDao;
	
	
	public DbVersion findDbVersion(){
		return dbVersionDao.getEntity(DbVersion.class, 1);
	}


	public DbVersionDao getDbVersionDao() {
		return dbVersionDao;
	}


	public void setDbVersionDao(DbVersionDao dbVersionDao) {
		this.dbVersionDao = dbVersionDao;
	}
	
	
}
