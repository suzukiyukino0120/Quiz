package com.example.form;

public class AdminLoginForm {
	
	private Integer employeeId;
	
	private String password;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminLoginForm [employeeId=" + employeeId + ", password=" + password + "]";
	}
	
	

}
