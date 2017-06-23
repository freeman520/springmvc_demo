package edu.freshen.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SessionFactory sf = ctx.getBean("sessionFactory",SessionFactory.class);
		
		Session s = sf.openSession();
		Department dep =new Department();
		dep.setId(1);
		dep.setDepName("测试部门");
		Student stu = new Student();
		stu.setDepartment(dep);
		stu.setId(1);
		stu.setStuName("tom");
		s.save(stu);
		s.close();
		
	}

}
