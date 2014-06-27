package com.authentication.beans;

import javax.annotation.Nonnull;

public class ErrorResponse {

    @Nonnull
    private String error;

    public ErrorResponse(@Nonnull String error) {
        this.error = error;
    }

    @Nonnull
    public String getError() {
        return error;
    }
}
