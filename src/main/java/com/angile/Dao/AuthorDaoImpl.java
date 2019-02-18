package com.angile.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.angile.model.TbAuthor;

public class AuthorDaoImpl implements AuthorDao {
	private final SessionFactory sessionFactoty = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

	@Override
	public List<TbAuthor> getAuthor(int min, int max) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from TbAuthor");
			query.setFirstResult(min);
			query.setMaxResults(max);
			List<TbAuthor> author = query.list();
			session.getTransaction().commit();
			return author;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addAuthor(TbAuthor Author) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			session.save(Author);
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
	public boolean editAuthor(int id_author,TbAuthor author) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			author.setId(id_author);
			session.saveOrUpdate(author);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean removeAuthor(int id_Author) {
		Session session = sessionFactoty.openSession();
		TbAuthor author = null;
		try {
			session.getTransaction().begin();
			author =  session.get(TbAuthor.class, id_Author);
			session.delete(author);
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
	public TbAuthor getAuthorById(int id_Author) {
		Session session = sessionFactoty.openSession();
		TbAuthor author = null;
		try {
			session.getTransaction().begin();
			author = session.get(TbAuthor.class, id_Author);
			session.getTransaction().commit();
			return author;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
