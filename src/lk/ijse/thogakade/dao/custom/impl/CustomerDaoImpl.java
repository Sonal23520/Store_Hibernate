package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDAO {
    Session session = FactoryConfiguration.getInstance().getSession();
    @Override
    public boolean add(Customer entity) throws Exception {
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
        Transaction transaction = session.beginTransaction();
        Customer load = session.load(Customer.class, Integer.parseInt(s));
        session.delete(load);
        transaction.commit();
        return true;
    }

    @Override
    public Customer search(String s) throws Exception {
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, Integer.parseInt(s));
        transaction.commit();
        return customer;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Customer");
        List<Customer> list = query.list();
        transaction.commit();
        return (ArrayList<Customer>) list;
    }
}
