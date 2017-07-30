package com.mkren.building.dao.mysql;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.entity.SmetaEntity;

@Repository("smetaDao")
public class SmetaDaoImpl extends BaseDao implements SmetaDAO {

	@Override
	public List<SmetaEntity> loadAllSmeta() {
		String query = "SELECT s FROM SmetaEntity s";

		return manager.createQuery(query, SmetaEntity.class).getResultList();
	}

	@Override
	public SmetaEntity loadSmetaById(Integer smetaId) {
		return manager.find(SmetaEntity.class, smetaId);
	}

	@Override
	public SmetaEntity loadSmetaByPp(Integer smetaPp) {
		Query query = manager.createQuery("SELECT s FROM SmetaEntity s WHERE s.pp = :smetaPp");
		query.setParameter("smetaPp", smetaPp);

		return (SmetaEntity) query.getSingleResult();
	}

	@Override
	public Double getRestFromVolumesById(Integer smetaId) {
		String select = "SELECT ROUND(sm.kolVo - SUM(COALESCE(mag.volume, 0)), 2) ";
		String from = "FROM SmetaEntity sm LEFT OUTER JOIN MagazineEntity mag ";
		String on = "ON sm.id = mag.smeta.id ";
		String where = "WHERE sm.id=:smetaId ";

		Query query = manager.createQuery(select + from + on + where);
		query.setParameter("smetaId", smetaId);

		return (Double) query.getSingleResult();
	}
}
