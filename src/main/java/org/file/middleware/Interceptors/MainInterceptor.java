package org.file.middleware.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 In Spring Boot, middleware is implemented using interceptors and filters. Both allow you to intercept and process HTTP requests and responses, but they operate at different levels of the Spring application lifecycle.

 Interceptors:
 Spring MVC Specific: Interceptors are part of the Spring MVC framework. They're typically used for tasks that relate to handling web requests within the Spring MVC context.

 Access to Handler: Interceptors have access to the handler (the controller method) that will process the request.

 Phases of Execution: They can intercept requests before, during, and after the handler's execution.

 Use Cases: Authentication, authorization, logging, request/response modification, and adding common headers.
 */

@Component
public class MainInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MainInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Interceptor -> PreHandle - Request: {} {}", request.getMethod(), request.getRequestURI());
        // Perform pre-processing here
        // Return true to continue request processing, false to stop
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("Interceptor -> PostHandle - Response status: {}", response.getStatus());
        // Perform post-processing here
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            logger.error("Interceptor -> AfterCompletion - Exception: {}", ex.getMessage());
        }
        // Perform cleanup or logging after the request is complete
    }
}