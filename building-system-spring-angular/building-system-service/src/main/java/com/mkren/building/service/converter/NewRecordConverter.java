package com.mkren.building.service.converter;

import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.entity.SmetaEntity;
import com.mkren.building.entity.UserEntity;

//@Component
public class NewRecordConverter extends BaseCustomConverter {
	private static final Integer NO_ID_SMETA = 0;

	public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3) {
		if (source == null) {
			return null;
		}

		Integer idSmeta = null;
		Integer ppSmeta = null;
		Integer idUser = null;

		if (source instanceof MagazineEntity) {
			MagazineEntity entity = (MagazineEntity) source;
			NewRecordBean bean = defaultConvert(entity, NewRecordBean.class);

			idUser = entity.getUser().getId();
			bean.setUserId(idUser);

			idSmeta = entity.getSmeta().getId();
			if (idSmeta != NO_ID_SMETA) {
				ppSmeta = entity.getSmeta().getPp();
			}

			bean.setPpSmeta(ppSmeta);

			return bean;
		} else if (source instanceof NewRecordBean) {
			NewRecordBean bean = (NewRecordBean) source;
			MagazineEntity entity = defaultConvert(bean, MagazineEntity.class);

			idUser = bean.getUserId();
			ppSmeta = bean.getPpSmeta();

			UserEntity userEntity = userDao.loadUserById(idUser);
			SmetaEntity smetaEntity = smetaDao.loadSmetaByPp(ppSmeta);

			entity.setUser(userEntity);
			entity.setSmeta(smetaEntity);

			return entity;
		}

		return null;
	}
}
