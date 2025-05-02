package com.fit;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authorization.method.AuthorizeReturnObject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@AuthorizeReturnObject
@PostAuthorize("returnObject?.owner == authentication.name or hasRole('ACCOUNTANT')")
public @interface PostReadBankAccount {
}
