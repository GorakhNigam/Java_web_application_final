package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("Context.xml");
       Employee empl = ctx.getBean("emp",Employee.class);
       empl.setEmpcode(111);
       empl.setEmpname("virtusa");
       empl.setSalary(2000);
       System.out.println(empl.getEmpcode()+empl.getEmpname());
    }
}
