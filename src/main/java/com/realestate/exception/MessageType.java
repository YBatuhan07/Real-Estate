package com.realestate.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    GENERAL_EXCEPTION("0000","hata oluştu"),
    NO_RECORD_EXIST("1004","kayıt yok"),
    TOKEN_IS_EXPIRED("1005","tokenin süresi dolmuştur"),
    USERNAME_NOT_FOUND("1006","username bulunamadı"),
    USERNAME_OR_PASSWORD_INVALID("1007","Kullanıcı adı veya şifre bulunamadı"),
    REFRESH_TOKEN_NOT_FOUND("1008","Refresh token bulunamadı"),
    REFRESH_TOKEN_IS_EXPIRED("1009","Refresh token süresi doldu"),
    CURRENCY_RATES_IS_OCCURED("1010","döviz kuru alınamadı"),
    CUSTOMER_AMOUNT_IS_NOT_ENOUGH("1011","Müşterinin parası yeterli değil"),
    HOUSE_STATUS_IS_ALREADY_SOLD("1012","ARABA ZATEN SATILMIŞ");

    private String code;
    private String message;

    MessageType(String code,String message){
        this.code=code;
        this.message=message;
    }
}
