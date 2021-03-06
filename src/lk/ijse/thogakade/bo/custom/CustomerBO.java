package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.bo.SuperBO;
import lk.ijse.thogakade.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;
    public ArrayList<CustomerDTO> getAll()throws Exception;
    public boolean deleteCustomer(String s)throws Exception;
    public CustomerDTO searchCustomer(String s)throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO)throws Exception;

}
