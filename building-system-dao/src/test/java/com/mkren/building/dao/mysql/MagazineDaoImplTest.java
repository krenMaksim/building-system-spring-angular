package com.mkren.building.dao.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.util.JsonUtil;

class MagazineDaoImplTest extends AbstractDaoTest {

    @Autowired
    private MagazineDAO magazineDao;

    private MagazineEntity expectedMagazineEntity;

    @PostConstruct
    private void init() {
	expectedMagazineEntity = magazineDao.loadMagazineById(1);
    }

    @Test
    void loadAllSmeta() {
	List<MagazineEntity> magazineList = magazineDao.loadAllMagazine();

	assertFalse(magazineList.isEmpty());
	assertEquals(3, magazineList.size());

	magazineList.forEach(item -> assertTrue(Objects.nonNull(item)));
    }

    @Test
    void loadMagazineById() {
	assertEquals(expectedMagazineEntity, magazineDao.loadMagazineById(1));
    }

    @Test
    void loadMagazineByFakeId() {
	assertEquals(null, magazineDao.loadMagazineById(FAKE_ID));
    }

    @Test
    void loadMagazineByNullId() {
	assertThrows(NullPointerException.class, () -> {
	    magazineDao.loadMagazineById(null);
	});
    }

    @Test
    @Sql(scripts = AbstractDaoTest.RECREATE_DB_SQL, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    void storeMagazine() {
	MagazineEntity entity = JsonUtil.makeCopy(expectedMagazineEntity);
	entity.setId(null);

	MagazineEntity storedEntity = magazineDao.storeMagazine(entity);

	entity.setId(storedEntity.getId());

	assertEquals(entity, storedEntity);
    }

    @Test
    void storeMagazineNullValue() {
	assertThrows(NullPointerException.class, () -> {
	    magazineDao.storeMagazine(null);
	});
    }

    @Test
    @Sql(scripts = AbstractDaoTest.RECREATE_DB_SQL, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    void updateMagazine() {
	MagazineEntity entity = JsonUtil.makeCopy(expectedMagazineEntity);
	entity.setConditions("TEST");

	magazineDao.updateMagazine(entity);

	assertEquals(entity, magazineDao.loadMagazineById(1));
    }

    @Test
    void updateMagazineNullEntity() {
	assertThrows(NullPointerException.class, () -> {
	    magazineDao.updateMagazine(null);
	});
    }

    @Test
    void updateMagazineNullId() {
	MagazineEntity entity = JsonUtil.makeCopy(expectedMagazineEntity);
	entity.setId(null);

	assertThrows(NullPointerException.class, () -> {
	    magazineDao.updateMagazine(entity);
	});
    }
}
