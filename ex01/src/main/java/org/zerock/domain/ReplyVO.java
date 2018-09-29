package org.zerock.domain;

import java.util.Date;

public class ReplyVO {
	private Integer rno;
	private Integer bno;
	private String replytest;
	private String replyer;
	private Date regdate;
	private Date updatedate;
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getReplytest() {
		return replytest;
	}
	public void setReplytest(String replytest) {
		this.replytest = replytest;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", replytest=" + replytest + ", replyer=" + replyer
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
}
