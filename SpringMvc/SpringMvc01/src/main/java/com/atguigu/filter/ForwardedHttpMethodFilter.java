package com.atguigu.filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForwardedHttpMethodFilter implements Filter {
    private static final List<String> ALLOWED_METHODS = Collections.unmodifiableList(Arrays.asList("PUT", "DELETE", "PATCH"));

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            throw new ServletException("HttpMethodFilter just supports HTTP requests");
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (ALLOWED_METHODS.contains(httpRequest.getMethod())
                && httpRequest.getAttribute("javax.servlet.error.exception") == null) {
            httpRequest = new ForwradedHttpMethodRequestWrapper(httpRequest);
        }
        chain.doFilter(httpRequest, httpResponse);
    }

    public void destroy() {

    }

    private static class ForwradedHttpMethodRequestWrapper extends HttpServletRequestWrapper {

        public ForwradedHttpMethodRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getMethod() {
            return "POST";
        }
    }
}

