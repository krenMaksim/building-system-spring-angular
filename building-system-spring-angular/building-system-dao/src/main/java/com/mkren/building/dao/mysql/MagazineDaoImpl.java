package com.mkren.building.dao.mysql;

import java.util.List;

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

		return manager.createQuery(query, MagazineEntity.class).getResultList();
	}

	@Override
	public MagazineEntity loadMagazineById(Integer magazineId) {
		return manager.find(MagazineEntity.class, magazineId);
	}

	@Override
	public MagazineEntity storeMagazine(MagazineEntity magazine) {
		return manager.merge(magazine);
	}

	@Override
	public void updateMagazine(MagazineEntity mag) {
		if (mag.getId() != null) {
			manager.merge(mag);
		}
	}

	// Query query = manager.createQuery("UPDATE MagazineEntity mag SET " + "mag.smeta = :smeta," + " mag.location = :location," + " mag.date = :date," + " mag.smena = :smena," + " mag.weather = :weather," + " mag.conditions = :conditions,"
	// + " mag.volume = :volume," + " mag.controle = :controle," + " mag.user = :user WHERE mag.id = :id");
	// query.setParameter("smeta", mag.getSmeta());
	// query.setParameter("location", mag.getLocation());
	// query.setParameter("date", mag.getDate());
	// query.setParameter("smena", mag.getSmena());
	// query.setParameter("weather", mag.getSmena());
	// query.setParameter("conditions", mag.getConditions());
	// query.setParameter("volume", mag.getVolume());
	// query.setParameter("controle", mag.getControle());
	// query.setParameter("smena", mag.getSmena());
	// query.setParameter("user", mag.getUser());
	// query.setParameter("id", mag.getId());
	// query.executeUpdate();
}