package com.realestate.controller;

import com.realestate.dto.CurrencyRatesResponse;

public interface ICurrencyRatesController {
    public RootEntity<CurrencyRatesResponse> getCurrencyRates(String startDate, String endDate);
}
