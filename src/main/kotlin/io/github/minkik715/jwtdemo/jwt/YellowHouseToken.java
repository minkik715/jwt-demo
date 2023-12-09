package io.github.minkik715.jwtdemo.jwt;

import org.springframework.security.core.context.SecurityContextHolder;

public class YellowHouseToken {

    public static YellowHouseAuthentication getToken() {
        return (YellowHouseAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getAccountId(){
        return getToken().getAccountId();
    }

}
