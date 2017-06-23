package edu.freshen.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.freshen.entity.City;
import edu.freshen.service.CityService;
import edu.freshen.service.JxlService;
@Scope("prototype")
@Controller
public class JxlAction extends ActionSupport {
	
	private InputStream inputStream;
	ByteArrayOutputStream os;
	
	private File file;
	private String msg;
	@Resource
	private JxlService jxlService;
	//下载Excel
	public String outputJxl(){
		os=jxlService.outputJxl(0, 50);
		return SUCCESS;
	}
	//上传Excel
	public String inputJxl(){
		msg="上传城市列表数据完成，共录入数据："+jxlService.inputJxl(file);
		return SUCCESS;
	}
	public InputStream getInputStream() {
		return new ByteArrayInputStream(os.toByteArray());
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public ByteArrayOutputStream getOs() {
		return os;
	}
	public void setOs(ByteArrayOutputStream os) {
		this.os = os;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public JxlService getJxlService() {
		return jxlService;
	}
	public void setJxlService(JxlService jxlService) {
		this.jxlService = jxlService;
	}
	
}
