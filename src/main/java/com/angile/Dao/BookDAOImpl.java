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
		List<TbBook> books = null;
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from TbBook");
			query.setFirstResult(min);
			query.setMaxResults(max);
			books = query.list();
			session.getTransaction().commit();
			return books;
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
	public boolean editBook(int id_book, TbBook book) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			book.setId(id_book);
			session.update(book);
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
	public boolean removeBook(Integer id_book) {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			session.delete(session.get(TbBook.class, id_book));
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
	public TbBook getBookById(int id_book) {
		Session session = sessionFactoty.openSession();
		TbBook book = null;
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

	@Override
	public List<TbBook> showBookByIdThem(int id_theme) {
		Session session = sessionFactoty.openSession();
		List<TbBook> books = null;
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from TbBook b where b.idTheme.id =:id");
			query.setParameter("id", id_theme);
			books = query.list();
			session.getTransaction().commit();
			return books;
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean deleteAll() {
		Session session = sessionFactoty.openSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("delete from TbBook");
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

}
