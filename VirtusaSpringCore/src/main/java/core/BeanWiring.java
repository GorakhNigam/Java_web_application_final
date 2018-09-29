package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanWiring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Context.xml");
		Employee empl = ctx.getBean("emp", Employee.class);
		System.out.println(empl.getEmpcode()+empl.getAddress().getCity()+empl.getSalary());
	}

}
