package com.mkren.building.service.generator;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mkren.building.bean.ArchiveBean;
import com.mkren.building.bean.MagazineBean;
import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.bean.SmetaBean;
import com.mkren.building.bean.UserBean;
import com.mkren.building.dao.RecordsArchiveDAO;
import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.entity.RecordsArchiveEntity;
import com.mkren.building.entity.SmetaEntity;
import com.mkren.building.entity.UserEntity;
import com.mkren.building.service.dozer.Dozer;
import com.mkren.building.service.dozer.Mapping;

@Component
public final class BeanGenerator {
	@Resource(name = "smetaDao")
	private SmetaDAO smetaDao;

	@Resource(name = "userDao")
	private UserDAO userDao;

	@Resource(name = "recordsArchiveDao")
	private RecordsArchiveDAO archiveDao;

	public UserBean creatUserBean(UserEntity entity) {
		return Dozer.uneversalConvert(entity, UserBean.class, Mapping.DEFAULT);
	}

	public SmetaBean createSmetaBean(SmetaEntity entity) {
		return Dozer.uneversalConvert(entity, SmetaBean.class, Mapping.CUSTOM);
	}

	public MagazineBean createMagazineBean(MagazineEntity entity) {
		return Dozer.uneversalConvert(entity, MagazineBean.class, Mapping.CUSTOM);
	}

	public MagazineEntity createMagazineEntity(NewRecordBean bean) {
		return Dozer.uneversalConvert(bean, MagazineEntity.class, Mapping.CUSTOM);
	}

	public NewRecordBean createNewRecordBean(MagazineEntity entity) {
		return Dozer.uneversalConvert(entity, NewRecordBean.class, Mapping.CUSTOM);
	}

	public ArchiveBean createArchiveBean(Integer idMagazine) {

		ArchiveBean archiveBean = new ArchiveBean();

		StringBuffer date = new StringBuffer();
		StringBuffer smena = new StringBuffer();
		StringBuffer location = new StringBuffer();
		StringBuffer obosnovanie = new StringBuffer();
		StringBuffer weather = new StringBuffer();
		StringBuffer conditions = new StringBuffer();
		StringBuffer kolVo = new StringBuffer();
		StringBuffer controle = new StringBuffer();
		StringBuffer surnameInitials = new StringBuffer();

		List<RecordsArchiveEntity> archiveEntities = archiveDao.loadRecordsArchiveByMagazineId(idMagazine);

		for (RecordsArchiveEntity entity : archiveEntities) {
			String redactor = getRedactorOmen(entity);
			String oldRecord = entity.getOldRecord() + redactor;

			switch (entity.getNameColumn()) {
			case "date_":
				date.append(oldRecord);
				break;
			case "smena":
				smena.append(oldRecord);
				break;
			case "location":
				location.append(oldRecord);
				break;
			case "id_smeta":
				Integer idSmeta = Integer.valueOf(entity.getOldRecord());
				SmetaEntity smetaEntity = smetaDao.loadSmetaById(idSmeta);
				obosnovanie.append(smetaEntity.getNaimenovanie() + redactor);
				break;
			case "weather":
				weather.append(oldRecord);
				break;
			case "conditions":
				conditions.append(oldRecord);
				break;
			case "volume":
				kolVo.append(oldRecord);
				break;
			case "controle":
				controle.append(oldRecord);
				break;
			case "id_user":
				Integer idUser = Integer.valueOf(entity.getOldRecord());
				UserEntity userEntity = userDao.loadUserById(idUser);
				surnameInitials.append(userEntity.getSurnameInitials() + " ");
				surnameInitials.append(userEntity.getRole());
				surnameInitials.append(oldRecord);
				break;
			}
		}

		archiveBean.setDate(date.toString());
		archiveBean.setSmena(smena.toString());
		archiveBean.setLocation(location.toString());
		archiveBean.setObosnovanie(obosnovanie.toString());
		archiveBean.setWeather(weather.toString());
		archiveBean.setConditions(conditions.toString());
		archiveBean.setKolVo(kolVo.toString());
		archiveBean.setControle(controle.toString());
		archiveBean.setSurnameInitials(surnameInitials.toString());

		return archiveBean;
	}

	private String getRedactorOmen(RecordsArchiveEntity entity) {
		UserEntity userEntity = userDao.loadUserById(entity.getUser().getId());

		String surname = userEntity.getSurnameInitials();
		String role = userEntity.getRole();
		String date = entity.getDate().toString();

		return " [ " + date + ": " + surname + " " + role + " ]; ";
	}
}
