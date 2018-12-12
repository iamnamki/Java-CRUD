package com.encore.model;

public class DTO {
	int studentID;
	String name;
	int major_id;
	String skill;
	String major_title;

	public DTO() {

	}

	public DTO(int studentID, String name, int major_id, String skill, String major_title) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.major_id = major_id;
		this.skill = skill;
		this.major_title = major_title;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMajor_id() {
		return major_id;
	}

	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getMajor_title() {
		return major_title;
	}

	public void setMajor_title(String major_title) {
		this.major_title = major_title;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DTO [studentID=").append(studentID).append(", name=").append(name).append(", major_id=")
				.append(major_id).append(", skill=").append(skill).append(", major_title=").append(major_title)
				.append("]");
		return builder.toString();
	}

}
