package com.mkren.building.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkren.building.bean.MagazineBean;
import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.service.MagazineService;
import com.mkren.building.service.generator.BeanGenerator;
import com.mkren.building.service.util.DateUtils;
import com.mkren.building.service.util.MagazineUtils;

@Service("magazineService")
public final class MagazineServiceImpl implements MagazineService {

    private final MagazineDAO magazineDao;
    private final BeanGenerator beanGenerator;

    @Autowired
    public MagazineServiceImpl(MagazineDAO magazineDao, BeanGenerator beanGenerator) {
	this.magazineDao = magazineDao;
	this.beanGenerator = beanGenerator;
    }

    @Override
    public NewRecordBean getOldRecord(Integer magazineId) {
	MagazineEntity magazineEntity = magazineDao.loadMagazineById(magazineId);
	return beanGenerator.createNewRecordBean(magazineEntity);
    }

    @Override
    public List<MagazineBean> getRecords(Date dateWith, Date dateOn, List<String> surnames) {
	List<MagazineBean> magazineBeans = getAllRecords();
	List<MagazineBean> preparedMagazineBeans = new ArrayList<MagazineBean>(magazineBeans);

	for (MagazineBean bean : magazineBeans) {
	    Date date = bean.getDate();
	    // удаляем записи с датами вне выбранного промежутка
	    if (!DateUtils.compareData(date, dateWith, dateOn)) {
		preparedMagazineBeans.remove(bean);
	    }

	    if (!MagazineUtils.surnameIsConsist(bean.getSurnameInitials(), surnames)) {
		preparedMagazineBeans.remove(bean);
	    }
	}

	if (preparedMagazineBeans.isEmpty()) {
	    preparedMagazineBeans.add(new MagazineBean());
	}

	return preparedMagazineBeans;
    }

    @Override
    public List<String> surnameInitials() {
	List<MagazineBean> listBeans = getAllRecords();
	List<String> surnameInitials = new ArrayList<String>();

	for (MagazineBean bean : listBeans) {
	    String surname = bean.getSurnameInitials();
	    if (!surnameInitials.contains(surname)) {
		surnameInitials.add(surname);
	    }
	}

	return surnameInitials;
    }

    private List<MagazineBean> getAllRecords() {
	List<MagazineEntity> listEntity = magazineDao.loadAllMagazine();
	List<MagazineBean> listBeans = new ArrayList<MagazineBean>();

	for (MagazineEntity entity : listEntity) {
	    MagazineBean bean = beanGenerator.createMagazineBean(entity);
	    listBeans.add(bean);
	}

	return listBeans;
    }
}