package lk.ijse.thogakade.dao;

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
    enum DaoType{

    }
    public <T extends SuperDAO> T getDao(DaoType daoType){
        switch (daoType){
            default:
                return null;
        }
    }
}
