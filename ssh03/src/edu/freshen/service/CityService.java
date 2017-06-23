package edu.freshen.service;

import java.util.List;

import edu.freshen.dao.CityDao;
import edu.freshen.dao.DbVersionDao;
import edu.freshen.entity.City;
import edu.freshen.entity.DbVersion;

public class CityService {
	
	private CityDao cityDao;
	private DbVersionDao dbDao;
	/**
	 * 新增一个城市对象
	 * @param city
	 * @return
	 */
	public int insertCity(City city){
		DbVersion dbVer = dbDao.getEntity(DbVersion.class, 1);
		dbVer.setDbVersion(dbVer.getDbVersion()+1);
		dbDao.updateEntity(dbVer, 1);
		return cityDao.insertEntity(city);
	}
	public int insertCity(List<City> citys){
		if(citys==null||citys.size()<1)return 0;
		for (int i = 0; i < citys.size(); i++) {
			cityDao.insertEntity(citys.get(i));
		}
		
		DbVersion dbVer = dbDao.getEntity(DbVersion.class, 1);
		dbVer.setDbVersion(dbVer.getDbVersion()+1);
		dbDao.updateEntity(dbVer, 1);
		return citys.size();
	}
	/**
	 * 删除城市对象
	 * @param city
	 * @return
	 */
	public int deleteCity(City city){
		DbVersion dbVer = dbDao.getEntity(DbVersion.class, 1);
		dbVer.setDbVersion(dbVer.getDbVersion()+1);
		dbDao.updateEntity(dbVer, 1);
		return cityDao.deleteEntity(City.class, city.getId());
	}
	/**
	 * 更新城市对象
	 * @param city
	 * @return
	 */
	public int updateCity(City city){
		DbVersion dbVer = dbDao.getEntity(DbVersion.class, 1);
		dbVer.setDbVersion(dbVer.getDbVersion()+1);
		dbDao.updateEntity(dbVer, 1);
		return cityDao.updateEntity(city, city.getId());
	}
	
	/**
	 * 分页查找 City实体数据
	 * @param start
	 * @param size
	 * @return
	 */
	public List<City> queryCityByPage(int start,int size){
		//逻辑判断
		//审查
		//记录
		return cityDao.queryByPage(City.class, start, size);
	}
	/**
	 * 统计有City实体 记录数目
	 * @return
	 */
	public long countCity(){
		return cityDao.countItem(City.class);
	}
	public CityDao getCityDao() {
		return cityDao;
	}
	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	public DbVersionDao getDbDao() {
		return dbDao;
	}
	public void setDbDao(DbVersionDao dbDao) {
		this.dbDao = dbDao;
	}
	
	
}
