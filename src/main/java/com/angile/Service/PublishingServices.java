package com.angile.Service;

import java.util.List;

import com.angile.model.TbPlublishing;

public interface PublishingServices {
	public List<TbPlublishing> getPublishing(int min, int max);
	public boolean addPublishing(TbPlublishing Publishing);
	public boolean editPublishing(int id_Publishing , TbPlublishing plublishing);
	public boolean removePublishing(int id_Publishing);
	public TbPlublishing getPublishingById(Integer id_Publishing);
	public boolean exportExcel();
	public TbPlublishing getPublishingByName(String name);

}
