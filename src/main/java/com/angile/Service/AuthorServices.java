package com.angile.Service;

import java.util.List;

import com.angile.model.TbAuthor;

public interface AuthorServices {
	public List<TbAuthor> getAuthor(int min, int max);
	public boolean addAuthor(TbAuthor Author);
	public boolean editAuthor(int id_author,TbAuthor author);
	public boolean removeAuthor(int id_Author);
	public TbAuthor getAuthorById(Integer id_Author);
	public boolean exportExcel();
	public TbAuthor getAuthorByName(String name);

}
