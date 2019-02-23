package com.angile.Service;

import java.util.List;

import com.angile.model.TbBook;

public interface BookServices {
	public List<TbBook> getBook(int min, int max);
	public boolean addBook(TbBook book);
	public boolean editBook(int id_book);
	public boolean removeBook(int id_book);
	public TbBook getBookById(int id_book);
	public boolean exportExcel();
	public List<TbBook> showBookByIdThem(int id);

}
