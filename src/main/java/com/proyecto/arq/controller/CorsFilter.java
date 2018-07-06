package com.proyecto.arq.controller;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends GenericFilterBean implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        httpResponse.setHeader("Access-Control-Allow-Origin","*");
        httpResponse.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE, PUT");
        httpResponse.setHeader("Access-Control-Allow-Headers", "User, Authorization, Content-Length, Content-type");
        httpResponse.setHeader("Access-Control-Expose-Headers", "User, Authorization, Content-Length, Content-type");
        httpResponse.setHeader("Access-Control-Allow-Credentials","false");
        httpResponse.setHeader("Access-Control-Max-Age","3600");
        //httpResponse.addHeader("User","pedro");
        System.out.println("********** cors completado ************");
        chain.doFilter(request,response);
    }
}
