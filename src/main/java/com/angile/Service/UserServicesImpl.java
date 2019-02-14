package com.angile.Service;

import com.angile.Dao.UserDAOImpl;

public class UserServicesImpl implements UserServices {
	UserDAOImpl userDAOImpl = new UserDAOImpl();
	@Override
	public int logIn(String userName, String passWord) {
		if(!userName.equals("") && !passWord.equals("")) {
			return userDAOImpl.logIn(userName, passWord);
		}
		return -1;
	}

	@Override
	public boolean register(String userName, String passWord, String fullName, String email, int role) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
