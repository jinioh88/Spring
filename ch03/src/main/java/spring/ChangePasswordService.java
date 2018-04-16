package spring;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPwd, String newpWD) {
		Member member = memberDao.selectEmail(email);
		if(member==null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPwd, newpWD);
		
		memberDao.update(member);
	}

}
