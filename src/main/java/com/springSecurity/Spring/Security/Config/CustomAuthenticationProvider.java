package com.springSecurity.Spring.Security.Config;


import com.springSecurity.Spring.Security.Repo.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import com.springSecurity.Spring.Security.Repo.customRepo;

import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private customRepo customRepo;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        CustomAuthentication ca= (CustomAuthentication) authentication;

        CustomUser data=customRepo.findAll().stream().filter(c->c.getName().equals(ca.getUsername()))
                .findFirst().orElse(new CustomUser());

        if(data.getName()!=null){
return  new CustomAuthentication(data.getName(),data.getPassword(),true,data);



        }
        throw new BadCredentialsException(" Wrong credentials !");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
