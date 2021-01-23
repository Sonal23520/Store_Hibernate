package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.dao.custom.impl.CustomerDaoImpl;

public class DaoFactory {

    private static DaoFactory daoFactoryInstance;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactoryInstance == null) {
            daoFactoryInstance = new DaoFactory();
        }
        return daoFactoryInstance;
    }
    public enum DaoType{
    CUSTOMER
    }
    public <T extends SuperDAO> T getDao(DaoType daoType){
        switch (daoType){
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            default:
                return null;
        }
    }
}
