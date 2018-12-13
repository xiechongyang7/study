package com.seesea.study.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/13 10:00
 * @Author xie
 */
@WebFilter(urlPatterns = "/*")
@Component
public class LogFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(LogFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put("reqNo","1111a");
        logger.info("servletRequest。。。。。。。");
        filterChain.doFilter(servletRequest, servletResponse);
        MDC.remove("reqNo");
    }

    @Override
    public void destroy() {
        logger.info("销毁方法");
    }
}
