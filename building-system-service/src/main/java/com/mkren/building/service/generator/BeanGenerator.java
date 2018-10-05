package com.mkren.building.service.generator;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkren.building.bean.MagazineBean;
import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.bean.SmetaBean;
import com.mkren.building.bean.UserBean;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.entity.SmetaEntity;
import com.mkren.building.entity.UserEntity;

@Component
public class BeanGenerator {

    @Autowired
    private Mapper defaultDozerMapper;

    @Autowired
    private Mapper customDozerMapper;

    public UserBean creatUserBean(UserEntity entity) {
	return defaultDozerMapper.map(entity, UserBean.class);
    }

    public SmetaBean createSmetaBean(SmetaEntity entity) {
	return customDozerMapper.map(entity, SmetaBean.class);
    }

    public MagazineBean createMagazineBean(MagazineEntity entity) {
	return customDozerMapper.map(entity, MagazineBean.class);
    }

    public MagazineEntity createMagazineEntity(NewRecordBean bean) {
	return customDozerMapper.map(bean, MagazineEntity.class);
    }

    public NewRecordBean createNewRecordBean(MagazineEntity entity) {
	return customDozerMapper.map(entity, NewRecordBean.class);
    }
}
