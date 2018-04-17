package spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForAssembler {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어 입력 : ");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료");
				break;
			}
			if(command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			} else if(command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}else if(command.equals("list")) {
				processListCommand();
				continue;
			}
//			printHelp();
		}
	}
	
	private static Assembler assembler = new Assembler();
	
	private static void processNewCommand(String[] arg) {
		if(arg.length!=5) {
//			printHelp();
			return;
		}
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호 불일치");
			return;
		}
		try {
			regSvc.register(req);
			System.out.println("등록완료.\n");
		} catch(AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일\n");
		}
	}
	
	private static void processChangeCommand(String[] arg) {
		if(arg.length!=4) {
//			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc =ctx.getBean("changePwdSvc",ChangePasswordService.class);
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호 변경\n");
		} catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일.\n");
		} catch(IdpasswordNotMatchingException e) {
			System.out.println("임일과 암호가 일치하지 않음\n");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter",MemberListPrinter.class);
		listPrinter.printAll();
	}
}
