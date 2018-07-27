package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.entity.MagazineEntity;

@Repository("magazineDao")
@Transactional(readOnly = false)
public class MagazineDaoImpl extends BaseDao implements MagazineDAO {

    @Autowired
    private MagazineDaoSpringData magazineDaoSpringData;

    @Override
    public List<MagazineEntity> loadAllMagazine() {
	return magazineDaoSpringData.findAll();
    }

    @Override
    public MagazineEntity loadMagazineById(Integer magazineId) {
	Objects.requireNonNull(magazineId);

	return magazineDaoSpringData.findById(magazineId)
	                            .orElse(null);
    }

    @Override
    public MagazineEntity storeMagazine(MagazineEntity magazine) {
	Objects.requireNonNull(magazine);

	return magazineDaoSpringData.save(magazine);
    }

    @Override
    public void updateMagazine(MagazineEntity mag) {
	Objects.requireNonNull(mag);
	Objects.requireNonNull(mag.getId());

	manager.merge(mag);
    }
}