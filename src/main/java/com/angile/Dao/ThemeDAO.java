package com.angile.Dao;

import java.util.List;

import com.angile.model.TbTheme;

public interface ThemeDAO {
	public List<TbTheme> getTheme( int min , int max);
	public boolean addTheme(String name_Theme);
	public boolean removeTheme(int id_Theme);
	public boolean editTheme(int id_Theme,String name_Theme);
	
	

}
