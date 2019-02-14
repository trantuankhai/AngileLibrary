package com.angile.Dao;

import java.util.List;

import com.angile.model.TbPlublishing;

public interface PublishingDao {
	public List<TbPlublishing> getPublishing(int min, int max);
	public boolean addPublishing(TbPlublishing Publishing);
	public boolean editPublishing(int id_Publishing);
	public boolean removePublishing(int id_Publishing);
	public TbPlublishing getPublishingById(int id_Publishing);
}
