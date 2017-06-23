package edu.freshen.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.freshen.entity.City;
import edu.freshen.service.CityService;
@Scope("prototype")
@Controller
public class CityAction extends ActionSupport {
	@Resource
	private CityService cityService; //ciyt业务逻辑
	private List<City> citys;	//City集合
	private City city;	//city对象
	//分页的几个关键数据
	private int pageSize=15;	//页面容量
	private int maxPage;		//最大页码
	private int currentPage;	//当前页面
	private long maxItems;		//记录总条数
	
	private String client;
	
	//请求所有城市列表
	public String queryCity(){
		
		maxItems = cityService.countCity();
		maxPage= (int) 
		(maxItems%pageSize==0?maxItems/pageSize:maxItems/pageSize+1);
		//检验当前页
		if(currentPage<=0)currentPage=0;
		if(currentPage>=maxPage)currentPage=maxPage;
		
		citys = cityService.queryCityByPage(currentPage*pageSize, 
				       pageSize);
		if(client!=null && client.equalsIgnoreCase("phone")){
			return "cityjson";
		}
		return SUCCESS;
	}
	//新增城市 Action
	public String insertCity(){
		cityService.insertCity(city);
		return SUCCESS;
	}
	//删除城市Action
	public String deleteCity(){
		if(cityService.deleteCity(city)>0){
			
		}else{
			
		}
		return SUCCESS;
	}
	//更新城市
	public String updateCity(){
		cityService.updateCity(city);
		return SUCCESS;
	}
	//查询一个城市对象
	public String findCity(){
		
		return SUCCESS;
	}
	
	
	

	public CityService getCityService() {
		return cityService;
	}


	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}


	public List<City> getCitys() {
		return citys;
	}


	public void setCitys(List<City> citys) {
		this.citys = citys;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public long getMaxItems() {
		return maxItems;
	}


	public void setMaxItems(long maxItems) {
		this.maxItems = maxItems;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	
	
	
	
	
	
}
