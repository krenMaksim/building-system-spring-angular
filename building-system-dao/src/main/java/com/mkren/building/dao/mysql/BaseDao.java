package com.mkren.building.dao.mysql;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

abstract class BaseDao {
    @PersistenceContext
    protected EntityManager manager;

}
