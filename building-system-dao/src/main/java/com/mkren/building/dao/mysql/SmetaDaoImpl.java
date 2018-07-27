package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.entity.SmetaEntity;

@Repository("smetaDao")
public class SmetaDaoImpl extends BaseDao implements SmetaDAO {

    @Autowired
    private SmetaDaoSpringData smetaDaoSpringData;

    @Override
    public List<SmetaEntity> loadAllSmeta() {

	return smetaDaoSpringData.findAll();
    }

    @Override
    public SmetaEntity loadSmetaById(Integer smetaId) {
	Objects.requireNonNull(smetaId);

	return smetaDaoSpringData.findById(smetaId)
	                         .orElse(null);
    }

    @Override
    public SmetaEntity loadSmetaByPp(Integer smetaPp) {
	Objects.requireNonNull(smetaPp);

	return smetaDaoSpringData.findByPp(smetaPp);
    }

    @Override
    public Double getRestFromVolumesById(Integer smetaId) {
	Objects.requireNonNull(smetaId);

	return smetaDaoSpringData.findRestFromVolumesById(smetaId);
    }
}
