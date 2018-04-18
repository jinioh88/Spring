package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	@Autowired
	private MemberDao memDao;
	private MemberPrinter printer;

	
	public void setMemberDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if(member==null) {
			System.out.println("no data!\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}