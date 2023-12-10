package io.github.minkik715.jwtdemo.jwt;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;

public class YellowHouseToken {

    public static YellowHouseAuthentication getToken() {
        return (YellowHouseAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getAccountId() {
        return getToken().getAccountId();
    }

}
