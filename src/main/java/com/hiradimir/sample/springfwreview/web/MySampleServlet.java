package com.hiradimir.sample.springfwreview.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by yutaka on 2015/02/27.
 */
public class MySampleServlet extends HttpServlet {
    
    @Autowired
    MyBean2 myBean2;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        jdbcTemplate.execute("INSERT INTO PersonalData (name,mail,age) VALUES \n" +
                "  ('tuyano', 'syoda@tuyano', 12);");
        
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from personaldata");
        for(Map<String,Object> record : list){
            System.out.println(record);
        }
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
