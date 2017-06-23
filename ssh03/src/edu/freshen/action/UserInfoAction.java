package edu.freshen.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.freshen.dao.BaseDao;
import edu.freshen.entity.Department;
import edu.freshen.entity.Student;
import edu.freshen.entity.UserInfo;
import edu.freshen.service.UserInfoService;
@Scope("prototype")
@Controller
public class UserInfoAction extends ActionSupport {
	@Resource
	private UserInfoService userInfoService;
	
	private UserInfo userInfo;//封装 账户信息对象
	private int state;
	
	@Resource
	private BaseDao baseDao;
	
	public String testProj(){
		Department dep =new Department();
		dep.setId(1);
		dep.setDepName("测试部门");
		Student stu = new Student();
		stu.setDepartment(dep);
		stu.setId(1);
		stu.setStuName("tom");
		
		baseDao.insertEntity(stu);
		return SUCCESS;
	}
	
	
	public String registUser(){
		state = userInfoService.insertUserInfo(userInfo);
		return SUCCESS;
	}
	public String updateUser(){
		state = userInfoService.updateUserInfo(userInfo);
		return SUCCESS;
	}
	public String loginUser(){
		userInfo = userInfoService.loginCheck(
				userInfo.getLoginName(), 
				userInfo.getLoginPwd());
		return SUCCESS;
	}
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
