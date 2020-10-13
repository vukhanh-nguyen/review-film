package com.citynow.filter;


import com.citynow.model.UserModel;
import com.citynow.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/*"})
public class Authentication implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "LOGIN");
        if (url.startsWith("/admin")) {
            if (model != null) {
                if (model.getRole().getCode().equals("ADMIN")) {
                    chain.doFilter(servletRequest, servletResponse);
                } else if (model.getRole().getCode().equals("USER")) {
                    response.sendRedirect(request.getContextPath()+"/login");
                }
            } else {
                response.sendRedirect(request.getContextPath()+"/login");
            }
        } else if (url.startsWith("/create-post")) {
            if (model != null){
                chain.doFilter(servletRequest, servletResponse);
            }else{
                response.sendRedirect(request.getContextPath()+"/login");
            }
        } else {
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
