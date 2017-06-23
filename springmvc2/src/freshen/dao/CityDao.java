package freshen.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import freshen.entity.City;
@Repository
public class CityDao {
	@Resource
	private JdbcTemplate jdbcTemp;
	
	public List<City> findAll(int start,int size){
		String sql = "select * from city limit ?,?";
		RowMapper<City> rowMapper =new BeanPropertyRowMapper<City>(City.class);
		
		return jdbcTemp.query(sql, rowMapper,start,size);
	}
	
	
}
