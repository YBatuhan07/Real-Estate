package com.realestate.service.concrete;

import com.realestate.dto.CurrencyRatesResponse;
import com.realestate.exception.BaseException;
import com.realestate.exception.ErrorMessage;
import com.realestate.exception.MessageType;
import com.realestate.service.ICurrencyRatesService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyRatesService implements ICurrencyRatesService {


    @Override
    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {

        String rootURL = "https://evds2.tcmb.gov.tr/service/evds/";
        String series = "TP.DK.USD.A";
        String type = "json";

        String endPoint = rootURL + "series=" + series + "&startDate=" + startDate + "&endDate=" + endDate + "&type=" + type;

        HttpHeaders headers = new HttpHeaders();
        headers.add("key","v7lqzqbbf4");
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<CurrencyRatesResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET, httpEntity, CurrencyRatesResponse.class);
            if(response.getStatusCode().is2xxSuccessful()){
                return response.getBody();
            }
        }catch (Exception e){
            throw new BaseException(new ErrorMessage(MessageType.CURRENCY_RATES_IS_OCCURED,e.getMessage()));
        }
        return null;
    }
}
