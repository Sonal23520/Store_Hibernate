package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.bo.SuperBO;
import lk.ijse.thogakade.dto.CustomerDTO;

public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;
}
