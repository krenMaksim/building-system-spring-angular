package com.mkren.building.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.dao.RecordsArchiveDAO;
import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.dao.UserDAO;
import com.mkren.building.service.generator.BeanGenerator;

public abstract class AbstractService {
	@Resource(name = "userDao")
	protected UserDAO userDao;

	@Resource(name = "smetaDao")
	protected SmetaDAO smetaDao;

	@Resource(name = "recordsArchiveDao")
	protected RecordsArchiveDAO archiveDao;

	@Resource(name = "magazineDao")
	protected MagazineDAO magazineDao;

	@Autowired
	protected BeanGenerator beanGenerator;
}
