package lk.ijse.thogakade.bo;

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
    enum BoType{

    }
    public <T extends SuperBO>T getBo(BoType boType){
        switch (boType){
            default:
                return null;
        }
    }
}
