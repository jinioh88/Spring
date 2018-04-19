package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.ChangePasswordService;
import spring.IdpasswordNotMatchingException;
import spring.MemberNotFoundException;

public class MainForCPS {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		ChangePasswordService cps = ctx.getBean("changePwdSvc",ChangePasswordService.class);
		
		try {
			cps.changePassword("jinioh88@gmail.com", "1111", "1234");
		} catch(MemberNotFoundException e) {
			System.out.println("회원 없음");
		} catch(IdpasswordNotMatchingException e) {
			System.out.println("암호 불일치");
		}
		ctx.close();
	}

}
