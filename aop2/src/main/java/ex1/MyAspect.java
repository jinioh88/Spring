package ex1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	@Before("execution(public void ex1.Boy.runSomething ())")
	public void before(JoinPoint joinPoint) {
		System.out.println("얼굴확인 : 문 개방!");
	}
}
