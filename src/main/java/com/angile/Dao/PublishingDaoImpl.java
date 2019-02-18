package com.angile.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.angile.model.TbAuthor;
import com.angile.model.TbPlublishing;

public class PublishingDaoImpl implements PublishingDao {
	private final SessionFactory sessionFactoty = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

	@SuppressWarnings("all")
	@Override
	public List<TbPlublishing> getPublishing(int min, int max) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from TbPlublishing");
			query.setFirstResult(min);
			query.setMaxResults(max);
			List<TbPlublishing> plublishings = query.list();
			session.getTransaction().commit();
			return plublishings;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addPublishing(TbPlublishing Publishing) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			session.save(Publishing);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean editPublishing(int id_Publishing, TbPlublishing plublishing) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			plublishing.setId(id_Publishing);
			session.update(plublishing);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean removePublishing(int id_Publishing) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			session.delete(session.get(TbPlublishing.class, id_Publishing));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public TbPlublishing getPublishingById(int id_Publishing) {
		Session session = sessionFactoty.openSession();
		TbPlublishing plublishing = null;
		try {
			session.getTransaction().begin();
			plublishing = (TbPlublishing) session.get(TbPlublishing.class, id_Publishing);
			session.getTransaction().commit();
			return plublishing;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

}
