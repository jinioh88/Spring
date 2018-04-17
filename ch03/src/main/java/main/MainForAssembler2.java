package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import spring.AlreadyExistingMemberException;
import spring.Assembler;
import spring.ChangePasswordService;
import spring.IdpasswordNotMatchingException;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainForAssembler2 {

	public static void main(String[] args) throws IOException {
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
		MemberRegisterService regSvc = assembler.getRegisterService();
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
		ChangePasswordService changePwdSvc =assembler.getChangePasswordService();
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호 변경\n");
		} catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일.\n");
		} catch(IdpasswordNotMatchingException e) {
			System.out.println("임일과 암호가 일치하지 않음\n");
		}
	}
}
