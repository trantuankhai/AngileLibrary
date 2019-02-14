package com.angile.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPublishing(int id_Publishing) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePublishing(int id_Publishing) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TbPlublishing getPublishingById(int id_Publishing) {
		// TODO Auto-generated method stub
		return null;
	}

}
