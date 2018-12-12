package com.encore.model;

public class userDTO {
	String userid;
	String username; 
	String userpwd;
	String phone;
	String email;
	int point;
	
	
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("userDTO [userid=").append(userid).append(", username=").append(username).append(", userpwd=")
				.append(userpwd).append(", phone=").append(phone).append(", email=").append(email).append(", point=")
				.append(point).append("]");
		return builder.toString();
	}


	public userDTO() {
		
	}
	
	
	public userDTO(String userid, String username, String userpwd, String phone, String email, int point) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.phone = phone;
		this.email = email;
		this.point = point;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}     
	
	
	
}
