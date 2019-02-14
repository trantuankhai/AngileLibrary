package com.angile.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.angile.model.TbBook;

public class BookDAOImpl implements BookDAO {
	private final SessionFactory sessionFactoty = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

	@Override
	@SuppressWarnings("all")
	public List<TbBook> getBook(int min, int max) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from TbBook");
			query.setFirstResult(min);
			query.setMaxResults(max);
			List<TbBook> book = query.list();
			session.getTransaction().commit();
			return book;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addBook(TbBook book) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			session.save(book);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean editBook(int id_book) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean removeBook(int id_book) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			session.delete(session.get(TbBook.class, id_book));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public TbBook getBookById(int id_book) {
		Session session = sessionFactoty.openSession();
		TbBook book =null;
		try {
			session.getTransaction().begin();
			 book = session.get(TbBook.class, id_book);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return book;
	}

}