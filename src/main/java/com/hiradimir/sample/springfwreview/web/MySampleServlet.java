package com.hiradimir.sample.springfwreview.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yutaka on 2015/02/27.
 */
public class MySampleServlet extends HttpServlet {
    
    ApplicationContext app;

    @Override
    public void init() throws ServletException {
        super.init();
        app = new ClassPathXmlApplicationContext("/spring/application-config.xml");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = request.getParameter("message");
        MyBean myBean = (MyBean)app.getBean("mybean1");
        myBean.addMessage(message);
        response.sendRedirect("sample");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyBean myBean = (MyBean)app.getBean("mybean1");
        request.setAttribute("mybean", myBean);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    
}
