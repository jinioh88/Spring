package org.zerock.service;

import org.springframework.test.context.jdbc.Sql;
import org.zerock.domain.MessageVO;

public interface MessageService {
    public void addMessage(MessageVO vo) throws Exception;
    public MessageVO readMessage(String uid, Integer mno) throws Exception;
}
