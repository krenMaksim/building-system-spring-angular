package com.mkren.building.service.converter;

import org.dozer.CustomConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mkren.building.dao.RecordsArchiveDAO;
import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.dao.UserDAO;
import com.mkren.building.service.dozer.Dozer;
import com.mkren.building.service.dozer.Mapping;
import com.mkren.building.service.generator.BeanGenerator;
import com.mkren.building.spring.ServiceConfig;

public abstract class BaseCustomConverter implements CustomConverter {
    private static ApplicationContext ctx = new AnnotationConfigApplicationContext(ServiceConfig.class);

    public static void setApplicationContext(Class<?> config) {
	ctx = new AnnotationConfigApplicationContext(config);
    }

    // @Resource(name = "userDao")
    protected UserDAO userDao = ctx.getBean("userDao", UserDAO.class);

    // @Resource(name = "smetaDao")
    protected SmetaDAO smetaDao = ctx.getBean("smetaDao", SmetaDAO.class);

    // @Resource(name = "recordsArchiveDao")
    protected RecordsArchiveDAO archiveDao = ctx.getBean("recordsArchiveDao", RecordsArchiveDAO.class);

    // @Autowired
    protected BeanGenerator beanGenerator = ctx.getBean("beanGenerator", BeanGenerator.class);

    protected <T, V> V defaultConvert(T sourse, Class<V> destClass) {
	return Dozer.uneversalConvert(sourse, destClass, Mapping.DEFAULT);
    }

    @Override
    abstract public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3);
}
