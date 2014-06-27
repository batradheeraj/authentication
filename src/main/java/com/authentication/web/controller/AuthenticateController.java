package com.authentication.web.controller;

import javax.annotation.Nonnull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.beans.Authenticate;
import com.authentication.service.AccountServiceImpl;

@Controller
public class AuthenticateController {

    @Nonnull
    private AccountServiceImpl accountService;

    @RequestMapping(value = "/api/authenticate", headers = "Accept=application/json", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity authenticate(@RequestBody Authenticate authenticate) {

        return accountService.authenticate(authenticate);
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

}
