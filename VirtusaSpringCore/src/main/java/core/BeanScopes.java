package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Context.xml");
		Employee empl = ctx.getBean("emp",Employee.class);
		empl.setEmpcode(800);
		System.out.println(empl.getEmpcode()+empl.getEmpname());
		Employee emp2 = ctx.getBean("emp",Employee.class);
		System.out.println(empl.getEmpcode()+empl.getEmpname());
	}

}
