package com.mkren.building.service.generator;

import java.util.Objects;

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
	return map(defaultDozerMapper, entity, UserBean.class);
    }

    public SmetaBean createSmetaBean(SmetaEntity entity) {
	return map(customDozerMapper, entity, SmetaBean.class);
    }

    public MagazineBean createMagazineBean(MagazineEntity entity) {
	return map(customDozerMapper, entity, MagazineBean.class);
    }

    public MagazineEntity createMagazineEntity(NewRecordBean bean) {
	return map(customDozerMapper, bean, MagazineEntity.class);
    }

    public NewRecordBean createNewRecordBean(MagazineEntity entity) {
	return map(customDozerMapper, entity, NewRecordBean.class);
    }

    private static <T, V> T map(Mapper mapper, V entity, Class<T> targetType) {
	Objects.requireNonNull(targetType);

	if (Objects.isNull(entity)) {
	    return null;
	}

	return mapper.map(entity, targetType);
    }
}
