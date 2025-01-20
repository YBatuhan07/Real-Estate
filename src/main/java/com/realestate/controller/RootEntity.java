package com.realestate.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RootEntity<T> {
    private Integer status;
    private T payload;
    private String errorMessage;

    public static <T> RootEntity<T> ok(T payload) {
        RootEntity<T> rootentity = new RootEntity<T>();
        rootentity.setStatus(200);
        rootentity.setPayload(payload);
        rootentity.setErrorMessage(null);
        return rootentity;
    }

    public static <T> RootEntity<T> error(String errorMessage) {
        RootEntity<T> rootentity = new RootEntity<T>();
        rootentity.setStatus(500);
        rootentity.setErrorMessage(errorMessage);
        rootentity.setPayload(null);
        return rootentity;
    }

}
