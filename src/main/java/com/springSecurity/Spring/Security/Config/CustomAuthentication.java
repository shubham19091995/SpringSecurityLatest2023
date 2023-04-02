package com.springSecurity.Spring.Security.Config;

import com.springSecurity.Spring.Security.Repo.CustomUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import com.springSecurity.Spring.Security.Repo.customRepo;

import java.util.Collection;


@AllArgsConstructor
@Getter
@Setter
public class CustomAuthentication implements Authentication {

    @Autowired
    private customRepo customRepo;

    private final String username;
    private  final String password;
    private final boolean isCustomAuthenticated;
    private  final CustomUser customUser;

    public CustomAuthentication(String username,String password , boolean isCustomAuthenticated,CustomUser customUser){
        this.username=username;
        this.password=password;
        this.isCustomAuthenticated=isCustomAuthenticated;
        this.customUser=customUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return isCustomAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}
