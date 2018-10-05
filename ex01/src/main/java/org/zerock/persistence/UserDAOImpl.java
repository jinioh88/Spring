package org.zerock.persistence;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.LoginDTO;
import org.zerock.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Inject
	private SqlSession session;
	
	private static String namepace = "org.zerock.mapper.UserMapper";
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namepace+".login",dto);
	}

	@Override
	public UserVO checkUserWithSessionKey(String value) {
		return session.selectOne(namepace+".checkUserWithSessionKey",value);
	}

	@Override
	public void keepLogin(String uid, String sessionId, Date next) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uid", uid);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);
		
		session.update(namepace+".keepLogin",paramMap);
	}

}
