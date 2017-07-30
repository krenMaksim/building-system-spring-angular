package com.mkren.building.dao;

import java.util.List;

import com.mkren.building.entity.SmetaEntity;

public interface SmetaDAO {
	public List<SmetaEntity> loadAllSmeta();

	public SmetaEntity loadSmetaById(Integer smetaId);

	public SmetaEntity loadSmetaByPp(Integer smetaPp);

	public Double getRestFromVolumesById(Integer smetaId);

}
