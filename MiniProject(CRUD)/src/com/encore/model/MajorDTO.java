package com.encore.model;

import java.util.List;

public class MajorDTO {
	int major_id;
	String major_title;

	public MajorDTO() {

	}

	public MajorDTO(int major_id, String major_title) {
		super();
		this.major_id = major_id;
		this.major_title = major_title;
	}

	public int getMajor_id() {
		return major_id;
	}

	public void setMajor_id(int major_id) {
		this.major_id = major_id;
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
		builder.append("MajorDTO [major_id=").append(major_id).append(", major_title=").append(major_title).append("]");
		return builder.toString();
	}

}
