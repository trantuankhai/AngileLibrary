package com.angile.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.angile.model.TbTheme;

public class ThemeDAOImpl implements ThemeDAO {
	private final static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

	@SuppressWarnings("all")
	public List<TbTheme> getTheme(int min, int max) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from TbTheme");
			query.setFirstResult(min);
			query.setMaxResults(max);
			session.getTransaction().commit();
			return query.list();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addTheme(String name_Theme) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.save(new TbTheme(name_Theme));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean removeTheme(int id_Theme) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.delete(session.get(TbTheme.class, id_Theme));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean editTheme(int id_Theme, String name_Theme) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			TbTheme theme = session.get(TbTheme.class, id_Theme);
			theme.setNameTheme(name_Theme);
			session.update(theme);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

}
