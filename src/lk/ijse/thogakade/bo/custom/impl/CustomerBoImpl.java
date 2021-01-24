package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.CustomerBO;
import lk.ijse.thogakade.dao.DaoFactory;
import lk.ijse.thogakade.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.entity.Customer;

import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBO {
    CustomerDaoImpl customerDAO = DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);
    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.add(new Customer(customerDTO.getId(),customerDTO.getName()
                ,customerDTO.getAddress(),customerDTO.getSalary()));
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        ArrayList<CustomerDTO> arrayList = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();
    for (Customer customer : all) {
      arrayList.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary()));
    }
        return arrayList;
    }

    @Override
    public boolean deleteCustomer(String s) throws Exception {
        return customerDAO.delete(s);
    }

    @Override
    public CustomerDTO searchCustomer(String s) throws Exception {
        Customer search = customerDAO.search(s);
        return new CustomerDTO(search.getId(),search.getName(),search.getAddress(),
                search.getSalary());
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.update(new Customer(customerDTO.getId(),customerDTO.getName()
                ,customerDTO.getAddress(),customerDTO.getSalary()));
    }


}
