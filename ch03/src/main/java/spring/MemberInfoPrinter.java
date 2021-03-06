package spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
//	@Autowired
	@Resource(name="memberDao")
	private MemberDao memDao;
	private MemberPrinter printer;

	
	public void setMemberDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	
//	@Autowired
//	@Qualifier("sysout")
	@Resource(name="memberPrinter")
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
