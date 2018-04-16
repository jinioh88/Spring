/*
 * AOP @Before 적용
 */
package ex1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	@Before("execution(public void ex1.Boy.runSomething ())")
	//@Before("execution(*.runSomething ())")
	public void before(JoinPoint joinPoint) {
		System.out.println("얼굴확인 : 문 개방!");
	}
}
