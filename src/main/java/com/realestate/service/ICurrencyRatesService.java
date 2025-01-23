package com.realestate.service;

import com.realestate.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {
    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);
}
