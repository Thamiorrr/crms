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
        String sql = "select * from tb_customer";
        List<Customer> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<Customer>(Customer.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
