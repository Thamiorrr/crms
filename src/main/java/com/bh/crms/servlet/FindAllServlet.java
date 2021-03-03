package com.bh.crms.servlet;

import com.bh.crms.domain.PageBean;
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
        //获取当前页码
        String pagecode = req.getParameter("pc");
        int pc = 1;
        if (pagecode != null && !pagecode.trim().isEmpty()) {
            pc = Integer.parseInt(pagecode);
        }

        //获取URL
        String url = req.getRequestURI() + "?" + req.getQueryString();
        System.out.println("url00000:"+url);

        int lastIndex = url.lastIndexOf("&pc=");
        if (lastIndex != -1){
            url = url.substring(0,lastIndex);
            System.out.println("ifffff");
        }
        System.out.println("url00000:"+url);

        //获取总记录数
        long count = -1;
        count = customerService.findAllCount();
        int tr = (int)count;
        //每页记录数
        int ps = 10;
        //创建pagebean
        PageBean<Customer> pb = new PageBean<>(pc,tr,ps);
        pb.setUrl(url);
        //获取当页记录
        List<Customer> list = null;
        list = customerService.findAll(pagecode);
        pb.setBeanList(list);
        req.setAttribute("pb",pb);

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
