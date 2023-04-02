package com.springSecurity.Spring.Security.Config;

import com.springSecurity.Spring.Security.Repo.CustomUser;
import com.springSecurity.Spring.Security.Repo.customRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Service
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;
    private final customRepo customRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String userName= String.valueOf(request.getHeader("username"));
        String password= String.valueOf(request.getHeader("password"));


        CustomAuthentication ca= new CustomAuthentication(userName,password,false,null);

        var a=customAuthenticationManager.authenticate(ca);
        if(a.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request,response);
        }
        filterChain.doFilter(request,response);
    }

    @Bean
    public void addData(){
        CustomUser u1= new CustomUser();
        u1.setName("shubham");
        u1.setPassword("shubham");
        customRepo.save(u1);
    }
}
