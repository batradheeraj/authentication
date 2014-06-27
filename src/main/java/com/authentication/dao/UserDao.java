package com.authentication.dao;

import javax.annotation.Nonnull;

import com.authentication.beans.Authenticate;
import com.authentication.beans.User;

public interface UserDao {

    public @Nonnull
    User authenticateUser(@Nonnull Authenticate authenticate);

    public int insertApiKey(@Nonnull Authenticate authenticate, @Nonnull String api_key);
}
