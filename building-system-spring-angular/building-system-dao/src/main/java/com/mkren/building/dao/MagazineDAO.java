package com.mkren.building.dao;

import java.util.List;

import com.mkren.building.entity.MagazineEntity;

public interface MagazineDAO {
	public List<MagazineEntity> loadAllMagazine();

	public MagazineEntity loadMagazineById(Integer magazineId);

	public MagazineEntity storeMagazine(MagazineEntity magazine);

	public void updateMagazine(MagazineEntity magazine);

}
