package edu.freshen.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import edu.freshen.dao.CityDao;
import edu.freshen.entity.City;



public class JxlService {

	private CityService cityService;
	private SessionFactory sf;
	
	/**
	 * 查询数据，生成 Excel，并转换为输出流
	 * @return
	 */
	public ByteArrayOutputStream outputJxl(int start,int size){
		//创建输出流
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		//声明 Excel文件
		WritableWorkbook book ;
		try {
			//创建Excel文件，指定到输出流
			book = Workbook.createWorkbook(os);
			//创建工作表
			WritableSheet sheet =book.createSheet("表单1", 0);
			//在第0行，产生表头
			sheet.addCell(new Label(0,0,"编号"));
			sheet.addCell(new Label(1,0,"城市名称"));
			sheet.addCell(new Label(2,0,"行政区"));
			sheet.addCell(new Label(3,0,"人口"));
			sheet.addCell(new Label(4,0,"国家代码"));
			//查询数据
			List<City>data = cityService.queryCityByPage(start,size);
			//遍历数据，产生其他行
			for(int i=0;i<data.size();i++){
				sheet.addCell(new Label(0,i+1,data.get(i).getId()+""));
				sheet.addCell(new Label(1,i+1,data.get(i).getName()));
				sheet.addCell(new Label(2,i+1,data.get(i).getDistrict()));
				sheet.addCell(new Label(3,i+1,data.get(i).getPopulation()+""));
				sheet.addCell(new Label(4,i+1,data.get(i).getCountryCode()));
			}
			//写文件，并关闭
			book.write();
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return os;
	}
	//分批录入Excel中的数据
	public int inputJxl(File jxl){
		//声明Excel文档
		Workbook book;
		int r=0;
		//自己控制 事务提交
		Session ses =sf.openSession();
		Transaction tx = ses.beginTransaction();
		try {
			//从指定文件，创建工作表
			book=Workbook.getWorkbook(jxl);
			//得到工作表
			Sheet sheet = book.getSheet(0);
			r=sheet.getRows()-1;
			//遍历工作表，插入数据到数据库
			for (int i = 1; i < sheet.getRows(); i++) {
				String id = sheet.getCell(0, i).getContents();
				String name = sheet.getCell(1, i).getContents();
				String dist = sheet.getCell(2, i).getContents();
				int popu = Integer.parseInt( sheet.getCell(3, i).getContents());
				String code = sheet.getCell(4, i).getContents();
				City city = new City(name, code, dist, popu);
				System.out.println("准备导入："+ i +city.toString());
				//保存数据
				ses.save(city);
				//每100条数据，提交一次。
				if(i%100==0){
					tx.commit();
					System.out.println("已经导入第"+i/100+"批数据："+ i +city.toString());
				}
			}
			//不满100条时，提交
			tx.commit();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
		}
		
		return r;
	}
	
	
	public CityService getCityService() {
		return cityService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
}
