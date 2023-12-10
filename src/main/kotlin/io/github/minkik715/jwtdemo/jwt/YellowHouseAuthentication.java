package io.github.minkik715.jwtdemo.jwt;

import io.github.minkik715.jwtdemo.domain.enums.UserRole;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class YellowHouseAuthentication extends AbstractAuthenticationToken {

    private final String accountId;


    public YellowHouseAuthentication(String accountId) {
        super(null);
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return accountId;
    }
}
