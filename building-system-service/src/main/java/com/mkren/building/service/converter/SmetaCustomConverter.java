package com.mkren.building.service.converter;

import com.mkren.building.bean.SmetaBean;
import com.mkren.building.entity.SmetaEntity;

//@Component
public class SmetaCustomConverter extends BaseCustomConverter {

	public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3) {
		if (source == null) {
			return null;
		}
		if (source instanceof SmetaEntity) {
			SmetaEntity entity = (SmetaEntity) source;
			SmetaBean bean = defaultConvert(entity, SmetaBean.class);

			Double rest = smetaDao.getRestFromVolumesById(entity.getId());
			if (rest == null) {
				rest = entity.getKolVo();
			}
			bean.setRest(rest);

			return bean;
		}
		return null;
	}
}
