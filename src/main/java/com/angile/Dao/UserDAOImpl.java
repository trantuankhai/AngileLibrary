/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angile.Dao;

import com.angile.model.TbUser;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Tuan Khai
 */
public class UserDAOImpl implements UserDAO {

	private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

	@SuppressWarnings("all")
	@Override
	public int logIn(String userName, String passWord) {
		int role = -1;
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			Query query = session
					.createQuery("from TbUser us where us.userName= :userName and  us.passWord= :passWord");
			query.setParameter("userName", userName);
			query.setParameter("passWord", passWord);
			List<TbUser> liTbUsers = query.list();
			session.getTransaction().commit();
			if (liTbUsers.size() > 0) {
				for (TbUser x : liTbUsers) {
					role = x.getRole();
				}
			} else {
				role = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return role;

	}

	@Override
	public boolean register(String userName, String passWord, String fullName, String email, int role) {
		// TODO Auto-generated method stub
		return false;
	}
}
