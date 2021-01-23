package lk.ijse.thogakade.bo;

import lk.ijse.thogakade.bo.custom.impl.CustomerBoImpl;

public class BoFactory {

    private static BoFactory boFactoryInstance;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        if (boFactoryInstance == null) {
            boFactoryInstance = new BoFactory();
        }
        return boFactoryInstance;
    }
    public  enum BoType{
        CUSTOMER

    }
    public <T extends SuperBO>T getBo(BoType boType){
        switch (boType){
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            default:
                return null;
        }
    }
}
