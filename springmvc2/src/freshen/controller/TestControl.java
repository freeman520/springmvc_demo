package freshen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import freshen.entity.City;
import freshen.service.CityService;
@Controller
public class TestControl {
	@Resource
	private CityService cityService;
	
	private List<City> data;
	private int pageSize=15;
	private int currentPage=0;
	
	@RequestMapping("/hello")
	public String hello(int currentPage,Map<String,List> map){
		System.out.println("run cp="+currentPage);
		data = cityService.findCitys(currentPage*pageSize,pageSize);
		map.put("citys", data);
		return "hello";
	}
	@RequestMapping("/index")
	public String index(int currentPage){
		System.out.println("run index cp="+currentPage);
		
		return "index";
	}
	
	
	@RequestMapping("/helloJson")
	public void helloJson(int currentPage,PrintWriter pw){
		System.out.println("runJson cp="+currentPage);
		data = cityService.findCitys(currentPage*pageSize,pageSize);
		//System.out.println(new Gson().toJson(data));
		pw.write(new Gson().toJson(data));
	}
	

	public List<City> getData() {
		return data;
	}

	public void setData(List<City> data) {
		this.data = data;
	}
	
}
