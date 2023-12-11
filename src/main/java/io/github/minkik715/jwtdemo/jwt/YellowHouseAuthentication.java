package io.github.minkik715.jwtdemo.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class YellowHouseAuthentication implements Authentication {

    private final String accountId;

    private Boolean authentication =false;


    public YellowHouseAuthentication(String accountId) {
        this.accountId = accountId;
        this.setAuthenticated(true);
    }

    public String getAccountId() {
        return accountId;
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
        return accountId;
    }

    @Override
    public boolean isAuthenticated() {
        return authentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        authentication = isAuthenticated;
    }

    @Override
    public String getName() {
        return null;
    }
}
