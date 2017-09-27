package com.sojson.common.model;

public class AppCourse {
	/***id*/
	private Integer id;
	/***课程大类、任务类别、课程集、课程块、课程对应的名称*/
	private String name;
	/***父级目录*/
	private Integer pid;
	/***第N层级*/
	private Integer level;
	/***文字描述*/
	private String remark;
	
	/***音频存储路径*/
	private String audio;
	/***图片素材1的存储路径*/
	private String picOne;
	/***图片素材2的存储路径*/
	private String picTwo;
	/***图片素材3的存储路径*/
	private String picThree;
	/***图片素材4的存储路径*/
	private String picFour;
	
	/**状态：2表示已经完成，1表示正在进行,0表示未开始**/
	private Integer catalogState; //层级1的状态：课程大类的完成状态
	private Integer taskState; //层级2的状态：任务类型的完成状态
	private Integer courseSetState; //层级3的状态：课程集的完成状态
	
	private String proCeed;    //用户在当前课程大类下的练习进度
	private Integer totalTime; //用户在当前课程大类下的累计练习时长
	private Integer totalScore; //用户在当前课程大类下的累计得分
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public String getPicOne() {
		return picOne;
	}
	public void setPicOne(String picOne) {
		this.picOne = picOne;
	}
	public String getPicTwo() {
		return picTwo;
	}
	public void setPicTwo(String picTwo) {
		this.picTwo = picTwo;
	}
	public String getPicThree() {
		return picThree;
	}
	public void setPicThree(String picThree) {
		this.picThree = picThree;
	}
	public String getPicFour() {
		return picFour;
	}
	public void setPicFour(String picFour) {
		this.picFour = picFour;
	}
	public Integer getCatalogState() {
		return catalogState;
	}
	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}
	public Integer getTaskState() {
		return taskState;
	}
	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}
	public Integer getCourseSetState() {
		return courseSetState;
	}
	public void setCourseSetState(Integer courseSetState) {
		this.courseSetState = courseSetState;
	}
	public Integer getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public String getProCeed() {
		return proCeed;
	}
	public void setProCeed(String proCeed) {
		this.proCeed = proCeed;
	}
	
}
