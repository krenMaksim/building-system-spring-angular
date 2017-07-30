package com.mkren.building.dao.mysql;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDao {
	@PersistenceContext
	protected EntityManager manager;

}
