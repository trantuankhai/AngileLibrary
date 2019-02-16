package com.angile.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.angile.model.TbTheme;

public interface ThemeServices {
	public List<TbTheme> getTheme( int min , int max);
	public boolean addTheme(String name_Theme);
	public boolean removeTheme(int id_Theme);
	public boolean editTheme(int id_Theme,String name_Theme);
	public TbTheme showThemeById(int id_Theme);
	public TbTheme searchTheme(String nameTheme);
	public boolean exportExcel()throws IOException;

	
	

}
