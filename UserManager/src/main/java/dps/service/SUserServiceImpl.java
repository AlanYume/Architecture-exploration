package dps.service;

import dps.dao.SUserDao;

public class SUserServiceImpl implements SUserService {
    private SUserDao testDao;

    public void setTestDao(final SUserDao testDao) {
        this.testDao = testDao;
    }

    public void modify() {
        testDao.modify();
    }

    public void view() {
        testDao.view();
    }
}
