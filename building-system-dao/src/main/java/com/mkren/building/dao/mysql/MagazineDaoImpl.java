package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.entity.MagazineEntity;

@Repository("magazineDao")
@Transactional(readOnly = false)
public class MagazineDaoImpl extends BaseDao implements MagazineDAO {

    @Override
    public List<MagazineEntity> loadAllMagazine() {
	String query = "SELECT mag FROM MagazineEntity mag";

	return manager.createQuery(query, MagazineEntity.class)
	              .getResultList();
    }

    @Override
    public MagazineEntity loadMagazineById(Integer magazineId) {
	Objects.requireNonNull(magazineId);

	return manager.find(MagazineEntity.class, magazineId);
    }

    @Override
    public MagazineEntity storeMagazine(MagazineEntity magazine) {
	Objects.requireNonNull(magazine);

	return manager.merge(magazine);
    }

    @Override
    public void updateMagazine(MagazineEntity mag) {
	Objects.requireNonNull(mag);
	Objects.requireNonNull(mag.getId());

	manager.merge(mag);
    }
}