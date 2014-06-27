package com.authentication.service;

import javax.annotation.Nonnull;

import org.springframework.http.ResponseEntity;

import com.authentication.beans.Authenticate;

public interface AccountService {

    public @Nonnull
    ResponseEntity authenticate(@Nonnull Authenticate authenticate);
}
