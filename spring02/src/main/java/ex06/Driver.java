/*
 * AutoWired ����
 * id ���� type�� �켱�� �ȴ�. 
 */
package ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex06/expert003.xml");

		//Car car = (Car)context.getBean("car");
		Car car = context.getBean("car", Car.class);

		System.out.println(car.getTireBrand());

	}
}