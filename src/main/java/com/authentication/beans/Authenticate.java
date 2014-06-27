package com.authentication.beans;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Authenticate {

    @Nonnull
    private final String username;

    @Nonnull
    private final String password;

    @JsonCreator
    public Authenticate(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    @Nonnull
    public String getUsername() {
        return username;
    }

    @Nonnull
    public String getPassword() {
        return password;
    }
}
