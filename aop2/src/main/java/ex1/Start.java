package ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1/aop.xml");
		
		Person remeo = context.getBean("boy",Person.class);
		
		remeo.runSomething();
	}

}
