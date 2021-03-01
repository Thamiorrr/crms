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
        String pc = req.getParameter("pc");

        List<Customer> list = null;
        long count = -1;
        list = customerService.findAll(pc);
        count = customerService.findAllCount();
        int pagenum = (int)count;
        pagenum = pagenum%10==0?pagenum/10:pagenum/10+1;
        req.setAttribute("crmsList",list);
        req.setAttribute("pc",pc);
        req.setAttribute("pagenum",pagenum);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/list.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
