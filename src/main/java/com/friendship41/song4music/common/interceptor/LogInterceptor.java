package com.friendship41.song4music.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Slf4j
public class LogInterceptor extends HandlerInterceptorAdapter
{
    public static void writePreHandleLog(final HttpServletRequest request) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Req > " + request.getMethod() + " : ");
        stringBuffer.append("URI = " + request.getRequestURI()
                + (request.getQueryString() == null ? "" : "?" + request.getQueryString()));

        StringBuffer strHeader = new StringBuffer();
        for (
                Enumeration<String> enumerationHeaderKey = request.getHeaderNames(); enumerationHeaderKey
                .hasMoreElements();) {
            String headerKey = enumerationHeaderKey.nextElement();
            strHeader.append("[" + headerKey + ": " + request.getHeader(headerKey) + "] ");
        }
        stringBuffer.append(", Header = " + strHeader.toString());

        log.info(stringBuffer.toString());
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) throws Exception {
        log.info("Res > " + response.getStatus());
    }

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object handler) throws Exception {

        writePreHandleLog(request);
        return super.preHandle(request, response, handler);
    }
}
