package com.angile.Service;

import java.util.List;

import com.angile.Dao.ThemeDAO;
import com.angile.Dao.ThemeDAOImpl;
import com.angile.model.TbTheme;

public class ThemeServicesImpl implements ThemeDAO {
	ThemeDAOImpl themeDAo = new ThemeDAOImpl();

	@Override
	public List<TbTheme> getTheme(int min, int max) {
		return themeDAo.getTheme(min, max);
	}

	@Override
	public boolean addTheme(String name_Theme) {
		if (!name_Theme.equals("")) {
			if (themeDAo.addTheme(name_Theme)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	@Override
	public boolean removeTheme(int id_Theme) {
		// TODO Auto-generated method stub
		return themeDAo.removeTheme(id_Theme);
	}

	@Override
	public boolean editTheme(int id_Theme, String name_Theme) {
		if (!name_Theme.equals("")) {
			if (themeDAo.editTheme(id_Theme, name_Theme) == true) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public TbTheme showThemeById(int id_Theme) {
		// TODO Auto-generated method stub
		return themeDAo.showThemeById(id_Theme);
	}

}
