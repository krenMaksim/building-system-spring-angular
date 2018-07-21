package com.mkren.building.dao.mysql;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mkren.building.spring.DaoConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DaoConfig.class })
abstract class AbstractDaoTest {

}
