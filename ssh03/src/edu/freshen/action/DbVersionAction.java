package edu.freshen.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.freshen.entity.DbVersion;
import edu.freshen.service.DbVersionService;
@Scope("prototype")
@Controller
public class DbVersionAction extends ActionSupport {
	private DbVersion dbVersion;
	@Resource
	private DbVersionService dbVersionService;
	
	public String execute(){
		dbVersion=dbVersionService.findDbVersion();
		return SUCCESS;
	}

	public DbVersion getDbVersion() {
		return dbVersion;
	}

	public void setDbVersion(DbVersion dbVersion) {
		this.dbVersion = dbVersion;
	}

	public DbVersionService getDbVersionService() {
		return dbVersionService;
	}

	public void setDbVersionService(DbVersionService dbVersionService) {
		this.dbVersionService = dbVersionService;
	}
	
	
	
}
