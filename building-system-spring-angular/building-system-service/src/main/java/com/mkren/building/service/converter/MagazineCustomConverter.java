package com.mkren.building.service.converter;

import com.mkren.building.bean.ArchiveBean;
import com.mkren.building.bean.MagazineBean;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.entity.SmetaEntity;
import com.mkren.building.entity.UserEntity;

//@Component
public class MagazineCustomConverter extends BaseCustomConverter {

	public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3) {
		if (source == null) {
			return null;
		}
		if (source instanceof MagazineEntity) {
			MagazineEntity entity = (MagazineEntity) source;
			MagazineBean bean = defaultConvert(entity, MagazineBean.class);

			String obosnovanie = null;
			String edIzm = null;
			// для отображения полупустых записей в журнале
			Integer idSmeta = entity.getSmeta().getId();
			if (idSmeta > 0) {
				obosnovanie = getObosnovanie(entity.getSmeta().getId());
				edIzm = getEdIzm(entity.getSmeta().getId());
			} else {
				obosnovanie = "";
				edIzm = "";
			}
			bean.setObosnovanie(obosnovanie);
			bean.setEdIzm(edIzm);

			String surnameInitials = getSurnameInitials(entity.getUser().getId());
			String role = getRole(entity.getUser().getId());
			bean.setSurnameInitials(surnameInitials);
			bean.setRole(role);

			ArchiveBean archive = beanGenerator.createArchiveBean(entity.getId());
			bean.setArchive(archive);

			return bean;
		}
		return null;
	}

	private String getObosnovanie(Integer smetaId) {
		SmetaEntity smetaEntity = smetaDao.loadSmetaById(smetaId);

		return smetaEntity.getNaimenovanie();
	}

	private String getEdIzm(Integer smetaId) {
		SmetaEntity smetaEntity = smetaDao.loadSmetaById(smetaId);

		return smetaEntity.getEdIzm();
	}

	private String getRole(Integer userId) {
		UserEntity userEntity = userDao.loadUserById(userId);
		return userEntity.getRole();
	}

	private String getSurnameInitials(Integer userId) {
		UserEntity userEntity = userDao.loadUserById(userId);
		return userEntity.getSurnameInitials();
	}
}
