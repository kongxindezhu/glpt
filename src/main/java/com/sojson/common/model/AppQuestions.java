package com.sojson.common.model;

import java.util.List;

public class AppQuestions {
	/**主键**/
	private Integer id;
	/**问题序号**/
	private Integer num;
	/**所属课程集编号**/
	private Integer cid;
	/**问题题干**/
	private String content;
	/**问题正解**/
	private String answer;
	/**答案解析**/
	private String remark;
	/**选项列表**/
	private List<AppOptions> options;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<AppOptions> getOptions() {
		return options;
	}
	public void setOptions(List<AppOptions> options) {
		this.options = options;
	}
	
}
