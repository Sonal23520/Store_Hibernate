package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDAO {
    @Override
    public boolean add(Customer entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Customer search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        return null;
    }
}
