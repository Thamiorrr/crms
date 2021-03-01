package com.bh.crms;

import com.bh.crms.Utils.JdbcUtil;
import com.bh.crms.pojo.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
class CrmsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test

    public void addCustomerTest() throws SQLException {
        /**
         * 添加数据
         */

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "insert into tb_customer values(?,?,?,?,?,?,?,?)";
        int a = 0;
        for(;a<100;a++){
            String cid = UUID.randomUUID().toString().replace("-","");
            String cname = "测试用例"+ a;
            String cgender ="男";
            String birthday = "2021-01-05";
            int end = 100+ a;
            String cellphone ="13900000"+end;
            String email = "Thamiorr@outlook.com";
            String description = "第"+a+"个";
            qr.update(sql,cid,cname,cgender,birthday,cellphone,email,description,"1");

        }


    }

    @Test
    public void test() throws SQLException {
        /**
         * 添加数据
         */

        String a ="1";

        int b= Integer.valueOf(a);
        System.out.println(b-1);

        }


}

