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

import com.mkren.building.dao.RecordsArchiveDAO;
import com.mkren.building.entity.RecordsArchiveEntity;
import com.mkren.building.util.JsonUtil;

class RecordsArchiveDaoImplTest extends AbstractDaoTest {

    @Autowired
    private RecordsArchiveDAO recordsArchiveDao;

    private RecordsArchiveEntity expectedRecordsArchiveEntity;

    @PostConstruct
    private void init() {
	expectedRecordsArchiveEntity = recordsArchiveDao.loadRecordsArchiveById(1);
    }

    @Test
    void loadRecordsArchiveById() {
	assertEquals(expectedRecordsArchiveEntity, recordsArchiveDao.loadRecordsArchiveById(1));
    }

    @Test
    void loadRecordsArchiveByFakeId() {
	assertEquals(null, recordsArchiveDao.loadRecordsArchiveById(FAKE_ID));
    }

    @Test
    void loadRecordsArchiveByNullId() {
	assertThrows(NullPointerException.class, () -> {
	    recordsArchiveDao.loadRecordsArchiveById(null);
	});
    }

    @Test
    @Sql(scripts = AbstractDaoTest.RECREATE_DB_SQL, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    void storeRecordsArchive() {
	RecordsArchiveEntity entity = JsonUtil.makeCopy(expectedRecordsArchiveEntity);
	entity.setId(null);

	RecordsArchiveEntity storedEntity = recordsArchiveDao.storeRecordsArchive(entity);

	entity.setId(storedEntity.getId());

	assertEquals(entity, storedEntity);
    }

    @Test
    void storeRecordsArchiveNullValue() {
	assertThrows(NullPointerException.class, () -> {
	    recordsArchiveDao.storeRecordsArchive(null);
	});
    }

    @Test
    void loadRecordsArchiveByMagazineId() {
	List<RecordsArchiveEntity> archiveList = recordsArchiveDao.loadRecordsArchiveByMagazineId(1);

	assertFalse(archiveList.isEmpty());
	assertEquals(1, archiveList.size());

	archiveList.forEach(smeta -> assertTrue(Objects.nonNull(smeta)));
    }

    @Test
    void loadRecordsArchiveByFakeMagazineId() {
	assertTrue(recordsArchiveDao.loadRecordsArchiveByMagazineId(FAKE_ID)
	                            .isEmpty());
    }

    @Test
    void loadRecordsArchiveByNullMagazineId() {
	assertThrows(NullPointerException.class, () -> {
	    recordsArchiveDao.loadRecordsArchiveByMagazineId(null);
	});
    }
}
