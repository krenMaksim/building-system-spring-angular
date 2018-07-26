package com.mkren.building.dao.mysql;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mkren.building.spring.DaoConfig;
import com.mkren.building.spring.DataSourceConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DaoConfig.class })
@ActiveProfiles(DataSourceConfig.TEST_PROFILE)
abstract class AbstractDaoTest {

    static final String RECREATE_DB_SQL = "/building_system_test.sql";

    static final Integer FAKE_ID = -1;

}
