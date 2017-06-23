package freshen.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import freshen.dao.CityDao;
import freshen.entity.City;
@Service
public class CityService {
	@Resource
	private CityDao cityDao;
	
	public List<City> findCitys(int start,int size){
		return cityDao.findAll(start,size);
	}
	
}
