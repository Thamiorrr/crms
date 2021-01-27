package service;

import com.bh.crms.dao.CustomerDao;
import com.bh.crms.pojo.Customer;

import java.util.List;

/**
 * @author Hasee
 * @Data 2021/1/27 11:36
 */
public class CustomerService {

    private CustomerDao dao = new CustomerDao();
    public  void addCustomer(Customer c){
        dao.addCustomer(c);
    }
    public List<Customer> findAll(){
        return dao.findAll();
    }
}
