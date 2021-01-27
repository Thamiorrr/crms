package com.bh.crms.servlet;

import com.bh.crms.pojo.Customer;
import service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Hasee
 * @Data 2021/1/27 16:37
 */
@WebServlet(name = "FindAllServlet",urlPatterns = "/findall")

public class FindAllServlet extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list = null;
        list = customerService.findAll();
        req.setAttribute("crmsList",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/list.jsp");
        dispatcher.forward(req,resp);
        for(Customer customer:list){
            System.out.println(customer.getGender());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
