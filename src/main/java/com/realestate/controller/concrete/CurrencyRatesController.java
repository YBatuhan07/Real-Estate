package com.realestate.controller.concrete;

import com.realestate.controller.ICurrencyRatesController;
import com.realestate.controller.RootEntity;
import com.realestate.dto.CurrencyRatesResponse;
import com.realestate.service.ICurrencyRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.realestate.controller.RootEntity.ok;

@RestController
@RequestMapping("currency")
public class CurrencyRatesController implements ICurrencyRatesController {

    @Autowired
    private ICurrencyRatesService currencyRatesService;

    @GetMapping("/getusd")
    @Override
    public RootEntity<CurrencyRatesResponse> getCurrencyRates(@RequestParam String startDate, String endDate) {
        return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
    }
}
