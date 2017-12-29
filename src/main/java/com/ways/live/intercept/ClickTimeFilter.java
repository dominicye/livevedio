package com.ways.live.intercept;

import com.shentop.ext.utils.EntityUtils;
import com.ways.live.model.Vedio;
import com.ways.live.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.net.util.URLUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

public class ClickTimeFilter extends OncePerRequestFilter {

    @Autowired
    private VedioService vedioService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String uri = httpServletRequest.getRequestURI();
        uri=URLDecoder.decode(uri,"UTF-8").substring(1);
        if (uri.contains("waysVedio/moive"))
        {
            Vedio vedio = vedioService.getVedioByVedioUrl(uri);
            if (vedio != null) {
                int clickTime = vedio.getClickTime();
                vedio.setClickTime(++clickTime);
                vedioService.UpdateVedio(vedio);
            }
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

}
