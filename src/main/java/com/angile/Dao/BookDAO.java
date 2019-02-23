package com.angile.Dao;

import java.util.List;

import com.angile.model.TbBook;

public interface BookDAO {
	public List<TbBook> getBook(int min, int max);
	public List<TbBook> showBookByIdThem(int id_theme);
	public boolean addBook(TbBook book);
	public boolean editBook(int id_book);
	public boolean removeBook(int id_book);
	public TbBook getBookById(int id_book);

}
