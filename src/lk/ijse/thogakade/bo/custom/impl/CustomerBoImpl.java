package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.CustomerBO;
import lk.ijse.thogakade.dao.DaoFactory;
import lk.ijse.thogakade.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.entity.Customer;

public class CustomerBoImpl implements CustomerBO {
    CustomerDaoImpl customerDAO = DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);
    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.add(new Customer(customerDTO.getId(),customerDTO.getName()
                ,customerDTO.getAddress(),customerDTO.getSalary()));
    }
}
