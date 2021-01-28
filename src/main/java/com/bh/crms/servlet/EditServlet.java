package com.bh.crms.servlet;

import com.bh.crms.pojo.Customer;
import org.assertj.core.util.DateUtil;
import service.CustomerService;

import javax.naming.Name;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author Hasee
 * @Data 2021/1/28 15:06
 */
@WebServlet(name = "EditServlet",urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("测试");
        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        String gender = req.getParameter("gender");
        String birth = req.getParameter("birthday");
        Date birthday = DateUtil.parse(birth);
        String cellphone = req.getParameter("cellphone");
        String email = req.getParameter("email");
        String description = req.getParameter("description");
        Customer c = new Customer(cid,cname,gender,birthday,cellphone,email,description);
        customerService.editCustomer(c);
        req.setAttribute("msg","修改成功");
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/msg.jsp");
        dispatcher.forward(req,resp);
    }
}
