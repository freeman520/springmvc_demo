package edu.freshen.action;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Encoder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * 根据提供的word模板（xml格式文件），产生新的word文件
 * @author Administrator
 *
 */
@Scope("prototype")
@Controller
public class DocAction extends ActionSupport {
	//模板配置对象
	Configuration cfg=null;
	File file;
	//下载文件名称
	String fileName="test.doc";
	InputStream inputStream;
	ByteArrayOutputStream bos;
	
	public String execute(){
		cfg = new Configuration();
		cfg.setDefaultEncoding("utf-8");
		//准备填充的数据
		Map data =new HashMap();
		data.put("a_name", "zfs");
		//加载webroot下的模板文件
		//模板文件的加载共有三种方式
		//public void setClassForTemplateLoading(Class clazz, String pathPrefix);
		//public void setDirectoryForTemplateLoading(File dir) throws IOException;
		//public void setServletContextForTemplateLoading(Object servletContext, String path);
		cfg.setServletContextForTemplateLoading(ServletActionContext.getServletContext(), 
				"/template");
		Template tp=null;
		try {
			//获取模板对象
			tp= cfg.getTemplate("test.xml");
			//创建输出文件，或者输出到流
			file = new File("d://nd.doc");
			//输出流需要制定编码格式 ，否则word不识别
			bos = new ByteArrayOutputStream();
//			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
			Writer out = new BufferedWriter(new OutputStreamWriter(bos,"utf-8"));
			//填充数据
			tp.process(data, out);
			System.out.println("Over "+file.getAbsolutePath() );
			//关闭输出流
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	

	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public InputStream getInputStream() {
		return new ByteArrayInputStream(bos.toByteArray());
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public Configuration getCfg() {
		return cfg;
	}


	public void setCfg(Configuration cfg) {
		this.cfg = cfg;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}
	
	
}
