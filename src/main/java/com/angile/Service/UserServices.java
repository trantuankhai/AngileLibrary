package com.angile.Service;

public interface UserServices {
	public int logIn(String userName , String passWord);
	public boolean register(String userName , String passWord ,String fullName, String email,int role);

}
