/*
 * AutoWired 적용
 * id 보다 type이 우선시 된다. 
 */
package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex05/expert003.xml");

		//Car car = (Car)context.getBean("car");
		Car car = context.getBean("car", Car.class);

		System.out.println(car.getTireBrand());

	}
}