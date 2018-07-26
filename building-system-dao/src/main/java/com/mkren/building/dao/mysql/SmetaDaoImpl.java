package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.entity.SmetaEntity;

@Repository("smetaDao")
public class SmetaDaoImpl extends BaseDao implements SmetaDAO {

    @Override
    public List<SmetaEntity> loadAllSmeta() {
	return manager.createQuery("SELECT s FROM SmetaEntity s", SmetaEntity.class)
	              .getResultList();
    }

    @Override
    public SmetaEntity loadSmetaById(Integer smetaId) {
	Objects.requireNonNull(smetaId);

	return manager.find(SmetaEntity.class, smetaId);
    }

    @Override
    public SmetaEntity loadSmetaByPp(Integer smetaPp) {
	Objects.requireNonNull(smetaPp);

	Query query = manager.createQuery("SELECT s FROM SmetaEntity s WHERE s.pp = :smetaPp");
	query.setParameter("smetaPp", smetaPp);

	try {
	    return (SmetaEntity) query.getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}
    }

    @Override
    public Double getRestFromVolumesById(Integer smetaId) {
	Objects.requireNonNull(smetaId);

	String sql = "" +
	        "SELECT ROUND(sm.kolVo - SUM(COALESCE(mag.volume, 0)), 2) " +
	        "FROM SmetaEntity sm LEFT OUTER JOIN MagazineEntity mag " +
	        "ON sm.id = mag.smeta.id " +
	        "WHERE sm.id=:smetaId ";

	Query query = manager.createQuery(sql);
	query.setParameter("smetaId", smetaId);

	return (Double) query.getSingleResult();
    }
}
