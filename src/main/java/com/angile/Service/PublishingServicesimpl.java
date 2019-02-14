package com.angile.Service;

import java.util.List;

import com.angile.Dao.PublishingDaoImpl;
import com.angile.model.TbPlublishing;

public class PublishingServicesimpl implements PublishingServices {
	private PublishingDaoImpl PublishingServicesimpl = new PublishingDaoImpl();

	@Override
	public List<TbPlublishing> getPublishing(int min, int max) {
		// TODO Auto-generated method stub
		return PublishingServicesimpl.getPublishing(min, max);
	}

	@Override
	public boolean addPublishing(TbPlublishing Publishing) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPublishing(int id_Publishing) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePublishing(int id_Publishing) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TbPlublishing getPublishingById(int id_Publishing) {
		// TODO Auto-generated method stub
		return null;
	}

}
