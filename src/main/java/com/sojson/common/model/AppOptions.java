package com.sojson.common.model;

public class AppOptions {
	/**主键**/
	private Integer id;
	/**问题表主键**/
	private Integer qid;
	/**选项序号，例如ABCD**/
	private String seq;
	/**选项内容**/
	private String content;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
