package com.atguigu.view;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Component
public class HelloView implements View {
    public String getContentType() {
        return null;
    }

    public void render(Map<String, ?> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf8");
        System.out.println("执行了render方法");
        response.getWriter().println("新视图");
    }
}
