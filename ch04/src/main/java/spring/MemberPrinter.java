package spring;

public class MemberPrinter {
	public void print(Member member) {
		System.out.printf("아이디=%d, 이메일=%d, 이름=%d, 등록일=%d\n",member.getId(),member.getEmail(),member.getName(),member.getRegisterDate());
		
	}

}
