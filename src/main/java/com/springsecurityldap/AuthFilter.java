package com.springsecurityldap;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends GenericFilter{

    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(req);

        Cookie[] cookies = mutableRequest.getCookies();
        if(cookies!=null)
            for (int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("nginxauth")){
                    String auth=cookies[i].getValue().replace("\"", "");
                    System.out.println(auth);
                    mutableRequest.putHeader("Authorization","Basic "+auth);                    
                }
            }

        chain.doFilter(mutableRequest, response);

    }

}