package com.mkren.building.service.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mkren.building.bean.ArchiveBean;
import com.mkren.building.bean.MagazineBean;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.entity.RecordsArchiveEntity;
import com.mkren.building.entity.SmetaEntity;
import com.mkren.building.entity.UserEntity;

@Component
public class MagazineCustomConverter extends BaseCustomConverter {

    @Override
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
	    Integer idSmeta = entity.getSmeta()
	                            .getId();
	    if (idSmeta > 0) {
		obosnovanie = getObosnovanie(entity.getSmeta()
		                                   .getId());
		edIzm = getEdIzm(entity.getSmeta()
		                       .getId());
	    } else {
		obosnovanie = "";
		edIzm = "";
	    }
	    bean.setObosnovanie(obosnovanie);
	    bean.setEdIzm(edIzm);

	    String surnameInitials = getSurnameInitials(entity.getUser()
	                                                      .getId());
	    String role = getRole(entity.getUser()
	                                .getId());
	    bean.setSurnameInitials(surnameInitials);
	    bean.setRole(role);

	    ArchiveBean archive = createArchiveBean(entity.getId());
	    bean.setArchive(archive);

	    return bean;
	}
	return null;
    }

    ArchiveBean createArchiveBean(Integer idMagazine) {

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
	UserEntity userEntity = userDao.loadUserById(entity.getUser()
	                                                   .getId());

	String surname = userEntity.getSurnameInitials();
	String role = userEntity.getRole();
	String date = entity.getDate()
	                    .toString();

	return " [ " + date + ": " + surname + " " + role + " ]; ";
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
