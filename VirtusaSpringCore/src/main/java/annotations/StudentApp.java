package annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Annotation.xml");
		Student std = ctx.getBean("student", Student.class);
		System.out.println(std.getRegno() + std.getStdname() + std.getTotal() + std.getLibrary().getBooksDue());
	}

}
