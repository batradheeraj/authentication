package com.authentication.service;

import java.util.Calendar;

import javax.annotation.Nonnull;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.authentication.beans.Authenticate;
import com.authentication.beans.ErrorResponse;
import com.authentication.beans.Token;
import com.authentication.beans.User;
import com.authentication.beans.UserTokenWrapper;
import com.authentication.cache.TokenCache;
import com.authentication.dao.UserDao;
import com.authentication.util.Sha1Util;

public class AccountServiceImpl {

    @Nonnull
    private UserDao userDao;

    @Nonnull
    private TokenCache tokenCache;

    public @Nonnull
    ResponseEntity authenticate(@Nonnull Authenticate authenticate) {

        // Authenticating User
        User user = userDao.authenticateUser(authenticate);

        if (user.getId() == -1) {
            ErrorResponse errorResponse = new ErrorResponse("user credentials didn't match");
            return new ResponseEntity(errorResponse, HttpStatus.UNAUTHORIZED);
        } else if (user.getId() == -2) {
            ErrorResponse errorResponse = new ErrorResponse("internal server error");
            return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String email = authenticate.getUsername();
        String password = authenticate.getPassword();

        // Inserting new Api_Key and updating login time
        Calendar cal = Calendar.getInstance();
        long time = cal.getTimeInMillis();
        String api_key = DigestUtils.md5Hex(time + email);

        user.setApi_key(api_key);

        int rowCount = userDao.insertApiKey(authenticate, api_key);
        if (rowCount != 1) {
            ErrorResponse errorResponse = new ErrorResponse("internal server error");
            return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Creating SHA1 Token for authentication
        String key = email + Math.random() * 1000 + password;
        key = Sha1Util.SHA1(key);

        Token token = new Token(key);

        // Token entry in cache
        int id = user.getId();
        tokenCache.put(key, id);

        UserTokenWrapper userTokenWrapper = new UserTokenWrapper(token, user);
        return new ResponseEntity(userTokenWrapper, HttpStatus.OK);
    }

    public void setUserDao(@Nonnull UserDao userDao) {
        this.userDao = userDao;
    }

    public void setTokenCache(@Nonnull TokenCache tokenCache) {
        this.tokenCache = tokenCache;
    }
}
