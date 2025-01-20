package com.realestate.exception;

public enum MessageType {
    NO_RECORD_EXIST("1004","kayıt yok"),
    TOKEN_IS_EXPIRED("1005","tokenin süresi dolmuştur"),
    GENERAL_EXCEPTION("0000","hata oluştu"),
    USERNAME_NOT_FOUND("1006","username bulunamadı");

    private String code;
    private String message;

    MessageType(String code,String message){
        this.code=code;
        this.message=message;
    }
}
