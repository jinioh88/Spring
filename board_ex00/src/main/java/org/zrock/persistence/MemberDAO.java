package org.zrock.persistence;

import org.zrock.domain.MemberVO;

public interface MemberDAO {
	public String getTime();
	public void insertMember(MemberVO vo);
}
