package com.mkren.building.dao.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.entity.SmetaEntity;

class SmetaDaoImplTest extends AbstractDaoTest {

    private static final SmetaEntity expectedSmeta = new SmetaEntity();
    static {
	expectedSmeta.setId(1);
	expectedSmeta.setPp(2);
	expectedSmeta.setObosnovanie("Е11-2-1");
	expectedSmeta.setNaimenovanie("УСТРОЙСТВО УПЛОТНЯЕМЫХ ТРАМБОВКАМИ ПОДСТИЛАЮЩИХ СЛОЕВ ПЕСЧАНЫХ");
	expectedSmeta.setEdIzm("М3");
	expectedSmeta.setKolVo(188.8);
    }

    @Autowired
    private SmetaDAO smetaDao;

    @Test
    void loadAllSmeta() {
	List<SmetaEntity> smetaList = smetaDao.loadAllSmeta();

	assertFalse(smetaList.isEmpty());
	assertEquals(3, smetaList.size());

	smetaList.forEach(smeta -> assertTrue(Objects.nonNull(smeta)));
    }

    @Test
    void loadSmetaById() {
	assertEquals(expectedSmeta, smetaDao.loadSmetaById(expectedSmeta.getId()));
    }

    @Test
    void loadSmetaByFakeId() {
	assertEquals(null, smetaDao.loadSmetaById(FAKE_ID));
    }

    @Test
    void loadSmetaByNullId() {
	assertThrows(NullPointerException.class, () -> {
	    smetaDao.loadSmetaById(null);
	});
    }

    @Test
    void loadSmetaByPp() {
	assertEquals(expectedSmeta, smetaDao.loadSmetaByPp(expectedSmeta.getPp()));
    }

    @Test
    void loadSmetaByFakePp() {
	assertEquals(null, smetaDao.loadSmetaByPp(-1));
    }

    @Test
    void loadSmetaByNullPp() {
	assertThrows(NullPointerException.class, () -> {
	    smetaDao.loadSmetaByPp(null);
	});
    }

    @Test
    void getRestFromVolumesById() {
	assertEquals(Double.valueOf(188.8), smetaDao.getRestFromVolumesById(expectedSmeta.getId()));
    }

    @Test
    void getRestFromVolumesByFakeId() {
	assertEquals(null, smetaDao.getRestFromVolumesById(FAKE_ID));
    }

    @Test
    void getRestFromVolumesByNullId() {
	assertThrows(NullPointerException.class, () -> {
	    smetaDao.getRestFromVolumesById(null);
	});
    }
}
