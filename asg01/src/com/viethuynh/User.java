package com.viethuynh;

public class User {
	private int id;
    private String fullName;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String role;
    private String status;

    public User() {}
    
    public User(int id, String fullName, String email, String phone, String username, String role, String status) {
    	this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.role = role;
        this.status = status;
    }
    
    public User(String fullName, String email, String phone, String username, String role, String status) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.role = role;
        this.status = status;
    }
    
    public User(String fullName, String email, String phone, String username, String password,  String role, String status) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }
    
    public User(int id, String fullName, String email, String phone, String username, String password,  String role, String status) {
        this.id = id;
    	this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}
