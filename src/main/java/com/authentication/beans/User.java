package com.authentication.beans;

import javax.annotation.Nonnull;

public class User {

    private int id;

    @Nonnull
    private String api_key;

    private boolean active;

    @Nonnull
    private String username;

    @Nonnull
    private String firstName;

    @Nonnull
    private String lastName;

    @Nonnull
    private String dateJoined;

    @Nonnull
    private String lastLogin;

    private boolean superuser;

    public User() {
    }

    public User(
            int id,
            @Nonnull String api_key,
            boolean active,
            @Nonnull String username,
            @Nonnull String firstName,
            @Nonnull String lastName,
            @Nonnull String dateJoined,
            @Nonnull String lastLogin,
            boolean superuser) {

        this.id = id;
        this.api_key = api_key;
        this.active = active;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateJoined = dateJoined;
        this.lastLogin = lastLogin;
        this.superuser = superuser;
    }

    public int getId() {
        return id;
    }

    @Nonnull
    public String getApi_key() {
        return api_key;
    }

    public boolean isActive() {
        return active;
    }

    @Nonnull
    public String getUsername() {
        return username;
    }

    @Nonnull
    public String getFirstName() {
        return firstName;
    }

    @Nonnull
    public String getLastName() {
        return lastName;
    }

    @Nonnull
    public String getDateJoined() {
        return dateJoined;
    }

    @Nonnull
    public String getLastLogin() {
        return lastLogin;
    }

    public boolean isSuperuser() {
        return superuser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApi_key(@Nonnull String api_key) {
        this.api_key = api_key;
    }
}
