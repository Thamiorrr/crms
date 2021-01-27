package com.bh.crms.servlet;

import com.bh.crms.pojo.Customer;
import org.assertj.core.util.DateUtil;
import service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * 添加数据
 * @author Hasee
 * @Data 2021/1/27 11:17
 */
@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1.封装对象
         * 2.添加cid-uuid
         * 3.调用service方法
         * 4.成功信息保存至requset域
         * 5.跳转到msg.jsp
         */
        String cname = req.getParameter("cname");
        String gender = req.getParameter("gender");
        String birth = req.getParameter("birthday");
        Date birthday = DateUtil.parse(birth);
        String cellphone = req.getParameter("cellphone");
        String email = req.getParameter("email");
        String description = req.getParameter("description");
        Customer c = new Customer("0001",cname,gender,birthday,cellphone,email,description);
        customerService.addCustomer(c);
        req.setAttribute("msg","添加成功");
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/msg.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
