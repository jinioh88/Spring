package spring;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	public MemberRegisterService() {}
	
	//@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void register(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member!=null) {
			throw new AlreadyExistingMemberException("dup email"+req.getEmail());
		}
		Member newMember = new Member(req.getEmail(),req.getPassword(),req.getName(),new Date());
	}
}
