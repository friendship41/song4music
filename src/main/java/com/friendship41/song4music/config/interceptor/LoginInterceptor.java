package com.friendship41.song4music.config.interceptor;

import com.friendship41.song4music.repository.entity.Member;
import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        HttpSession session = request.getSession();

        Member member = (Member) session.getAttribute("member");
        if(member == null || member.getMMemberId() == null)
        {
            response.sendRedirect("/loginPage");
            return false;
        }

        return super.preHandle(request, response, handler);
    }
}
