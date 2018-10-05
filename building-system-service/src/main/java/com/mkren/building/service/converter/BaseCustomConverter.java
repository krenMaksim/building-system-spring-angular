package com.mkren.building.service.converter;

import javax.annotation.Resource;

import org.dozer.CustomConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkren.building.dao.RecordsArchiveDAO;
import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.dao.UserDAO;

@Component
public abstract class BaseCustomConverter implements CustomConverter {

    @Resource(name = "userDao")
    protected UserDAO userDao;

    @Resource(name = "smetaDao")
    protected SmetaDAO smetaDao;

    @Resource(name = "recordsArchiveDao")
    protected RecordsArchiveDAO archiveDao;

    @Autowired
    protected Mapper defaultDozerMapper;

    protected <T, V> V defaultConvert(T sourse, Class<V> destClass) {
	return defaultDozerMapper.map(sourse, destClass);
    }

    @Override
    abstract public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3);
}
