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

/**
 * @author Hasee
 * @Data 2021/1/28 11:21
 */
@WebServlet(name = "LoadServlet",urlPatterns = "/load")
public class LoadServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("id");
        Customer customer = null;
        customer = customerService.load(cid);
        req.setAttribute("crms",customer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/edit.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
    }
}
