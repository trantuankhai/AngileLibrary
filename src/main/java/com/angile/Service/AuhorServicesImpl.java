package com.angile.Service;

import java.util.List;

import com.angile.Dao.AuthorDaoImpl;
import com.angile.model.TbAuthor;

public class AuhorServicesImpl implements AuthorServices {
 private	AuthorDaoImpl AuhorDAO  = new AuthorDaoImpl();
	@Override
	public List<TbAuthor> getAuthor(int min, int max) {
		// TODO Auto-generated method stub
		return AuhorDAO.getAuthor(min, max);
	}

	@Override
	public boolean addAuthor(TbAuthor Author) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editAuthor(int id_Author) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAuthor(int id_Author) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TbAuthor getAuthorById(int id_Author) {
		// TODO Auto-generated method stub
		return null;
	}

}
