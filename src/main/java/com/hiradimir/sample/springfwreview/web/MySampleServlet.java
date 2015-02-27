package com.hiradimir.sample.springfwreview.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yutaka on 2015/02/27.
 */
public class MySampleServlet extends HttpServlet {
    
    @Autowired
    MyBean2 myBean2;

    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = request.getParameter("message");
        myBean2.getMyBean().addMessage(message);
        response.sendRedirect("sample");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mybean", myBean2);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    
}
