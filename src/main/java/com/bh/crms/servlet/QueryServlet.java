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
 * @author Hasee
 * @Data 2021/1/28 17:19
 */
@WebServlet(name = "QueryServlet", urlPatterns = "/query")
public class QueryServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String cellphone = req.getParameter("cellphone");
        Customer customer = new Customer(cname,gender,cellphone,email);

//        System.out.println("传入对象"+cname);
//        System.out.println("传入对象"+gender);
//        System.out.println("传入对象"+cellphone);
//        System.out.println("传入对象"+email);
        List<Customer> list = null;

        list = customerService.query(customer);
        req.setAttribute("crmsList",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/list.jsp");
        dispatcher.forward(req,resp);
    }
}
