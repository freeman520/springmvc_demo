package edu.freshen.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.freshen.dao.CityDao;
import edu.freshen.entity.City;
@Scope("prototype")
@Repository("cityDao")
public class CityDaoImpl extends BaseDaoImpl<City> 
	implements CityDao {

//	@Override
//	public int insertCity(List<City> citys) {
//		
//		Session ses = sf.getCurrentSession();
//		ses.
//		
//		
//		return 0;
//	}


}
