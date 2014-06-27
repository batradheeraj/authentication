package com.authentication.beans;

import javax.annotation.Nonnull;

public class Token {

    @Nonnull
    private String key;

    public Token(@Nonnull String key) {
        this.key = key;
    }

    @Nonnull
    public String getKey() {
        return key;
    }
}
