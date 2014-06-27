package com.authentication.beans;

import javax.annotation.Nonnull;

public class UserTokenWrapper {

    @Nonnull
    private Token token;

    @Nonnull
    private User user;

    public UserTokenWrapper(@Nonnull Token token, @Nonnull User user) {
        this.token = token;
        this.user = user;

    }

    @Nonnull
    public Token getToken() {
        return token;
    }

    @Nonnull
    public User getUser() {
        return user;
    }
}
