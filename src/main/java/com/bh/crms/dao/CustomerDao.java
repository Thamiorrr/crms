package com.bh.crms.dao;

import com.bh.crms.Utils.JdbcUtil;
import com.bh.crms.pojo.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Hasee
 * @Data 2021/1/27 11:30
 */
public class CustomerDao {
    private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

    public void addCustomer(Customer c){
        /**
         * 添加数据
         */
        String sql = "insert into tb_customer values(?,?,?,?,?,?,?)";
        Object[] objects = {c.getCid(),c.getCname(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getDescription()};

        try {
            qr.update(sql,objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<Customer> findAll(){
        String sql = "select * from tb_customer where enable = '1'";
        List<Customer> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<Customer>(Customer.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public Customer load(String cid){
        String sql = "select * from tb_customer where cid=?";
        Customer customer = null;
        try {
            customer = qr.query(sql, new BeanHandler<Customer>(Customer.class),cid);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return customer;
    }

    public void edit(Customer crms){
        String sql = "update tb_customer set cname=?,gender=?,birthday=?,cellphone=?,email=?,description=? where cid=?";
        Object[] objects = {
                crms.getCname(), crms.getGender(),
                crms.getBirthday(), crms.getCellphone(),
                crms.getEmail(), crms.getDescription(),crms.getCid()
        };
        try {
            qr.update(sql,objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(String cid){
        String sql = "update tb_customer set enable = 0 where cid = ?";
        try {
            qr.update(sql,cid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List query(Customer c){
//        String sql = "select * from tb_customer as t where(t.cname like ? or ? ='') and (t.gender = ? or ? ='')" +
//                "and (t.cellphone = ? or  ? ='') and (t.email = ? or ? ='') and enable = 1 ";
        String sql = "select * from tb_customer as t where(t.cname like ? or ? ='')and (t.gender = ? or ? ='')\n" +
                "and (t.cellphone = ? or  ? ='') and (t.email = ? or ? ='') and enable = 1";
        Object[] objects = {
                "%"+c.getCname().trim()+"%",c.getCname().trim(),
                c.getGender().trim(),c.getGender().trim(),
                c.getCellphone().trim(), c.getCellphone().trim(),
                c.getEmail().trim(),c.getEmail().trim()
        };
//        System.out.println(objects[0]+"要执行的搜索条件！");
//        System.out.println(objects[1]+"要执行的搜索条件！");
//        System.out.println(objects[2]+"要执行的搜索条件！");
//        System.out.println(objects[3]+"要执行的搜索条件！");
//        Object[] objects = {
//                "%"+c.getCname().trim()+"%"
//       };
//                System.out.println(objects[0]+"要执行的搜索条件！");

        List<Customer> customerList = null;
        try {
            customerList = qr.query(sql, new BeanListHandler<Customer>(Customer.class),objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
//        System.out.println(customerList.size()+"长度");
//
//        System.out.println(customerList.get(0).getCname());
        return customerList;
    }
}
