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
 * @Data 2021/1/28 15:46
 */
@WebServlet(name = "DeleteServlet",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("id");
        customerService.delete(cid);
        req.setAttribute("msg","删除成功");
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/msg.jsp");
        dispatcher.forward(req,resp);
    }
}
