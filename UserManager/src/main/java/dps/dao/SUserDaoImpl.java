package dps.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SUserDaoImpl implements SUserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SUserDaoImpl.class);

    public void modify() {
        LOGGER.info("执行修改操作");
    }

    public void view() {
        LOGGER.info("执行查询操作");
    }
}
