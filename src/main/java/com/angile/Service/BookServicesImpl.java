package com.angile.Service;

import java.util.List;

import com.angile.Dao.BookDAOImpl;
import com.angile.model.TbBook;

public class BookServicesImpl implements BookServices {
	BookDAOImpl bookDaoImpl = new BookDAOImpl();

	@Override
	public List<TbBook> getBook(int min, int max) {
		// TODO Auto-generated method stub
		return bookDaoImpl.getBook(min, max);
	}

	@Override
	public boolean addBook(TbBook book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editBook(int id_book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBook(int id_book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TbBook getBookById(int id_book) {
		if(id_book>0) {
			 return bookDaoImpl.getBookById(id_book);
		}
		return null;
	}

}
