package com.dhc.app.api.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// OncePerRequestFilter 每个http请求执行1次
@Component
@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION = "Authorization";

    private final UserDetailsService userDetailsService;


    /**
     * token认证，当前端携带了有效token时自动放行
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
//    @Transactional
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(AUTHORIZATION);
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        if (JwtUtil.verify(token) && JwtUtil.isExpired(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!JwtUtil.verify(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        //从token中获取用户名
        String username = JwtUtil.getUsername(token);
        //查询用户数据
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //生成UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        //将authenticationToken添加到上下文，后续就不需要认证了
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);

    }
}
