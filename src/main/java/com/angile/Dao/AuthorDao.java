package com.angile.Dao;

import java.util.List;

import com.angile.model.TbAuthor;


public interface AuthorDao {
	public List<TbAuthor> getAuthor(int min, int max);
	public boolean addAuthor(TbAuthor Author);
	public boolean editAuthor(int id_author,TbAuthor author);
	public boolean removeAuthor(int id_Author);
	public TbAuthor getAuthorById(int id_Author);
}
