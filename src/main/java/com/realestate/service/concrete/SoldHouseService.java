package com.realestate.service.concrete;

import com.realestate.dto.*;
import com.realestate.entities.Customer;
import com.realestate.entities.House;
import com.realestate.entities.SoldHouse;
import com.realestate.enums.HouseStatusType;
import com.realestate.exception.BaseException;
import com.realestate.exception.ErrorMessage;
import com.realestate.exception.MessageType;
import com.realestate.repository.CustomerRepository;
import com.realestate.repository.HouseRepository;
import com.realestate.repository.RealEstateAgentRepository;
import com.realestate.repository.SoldHouseRepository;
import com.realestate.service.ICurrencyRatesService;
import com.realestate.service.ISoldHouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
public class SoldHouseService implements ISoldHouseService {

    @Autowired
    private SoldHouseRepository soldHouseRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RealEstateAgentRepository realEstateAgentRepository;
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private ICurrencyRatesService currencyRatesService;

    public BigDecimal convertAmountToUsd(Customer customer) {
        CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates("23-01-2025", "23-01-2025");

        BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());
        BigDecimal customerUsdAmount = customer.getAccount().getAmount().divide(usd, 2, BigDecimal.ROUND_HALF_UP);
        return customerUsdAmount;
    }

    public boolean checkAmount(DtoSealedHouseIU dtoSealedHouseIU){
        Optional<Customer> optCustomer = customerRepository.findById(dtoSealedHouseIU.getCustomerId());
        if(optCustomer.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoSealedHouseIU.getCustomerId().toString()));
        }
        Optional<House> optHouse = houseRepository.findById(dtoSealedHouseIU.getHouseId());
        if(optHouse.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoSealedHouseIU.getHouseId().toString()));
        }

        BigDecimal customerUsdAmount = convertAmountToUsd(optCustomer.get());

        if(customerUsdAmount.compareTo(optHouse.get().getPrice()) >= 0){
            return true;
        }
        return false;

    }

    public BigDecimal remainingCustomerAmount(Customer customer,House house) {
        BigDecimal customerUsdAmount = convertAmountToUsd(customer);
        BigDecimal remainingCustomerUsdAmount = customerUsdAmount.subtract(house.getPrice());

        CurrencyRatesResponse currencyRates = currencyRatesService.getCurrencyRates("23-01-2025", "23-01-2025");
        BigDecimal usd = new BigDecimal(currencyRates.getItems().getFirst().getUsd());
        return remainingCustomerUsdAmount.multiply(usd);
    }

    public boolean checkHouseStatus(Long houseId){
        Optional<House> optHouse = houseRepository.findById(houseId);
        if(optHouse.isPresent() && optHouse.get().getStatus().name().equals(HouseStatusType.SOLD.name())){
            return false;
        }
        return true;
    }

    private SoldHouse createSealedHouse(DtoSealedHouseIU dtoSealedHouseIU){
        SoldHouse soldHouse = new SoldHouse();
        soldHouse.setCreateTime(new Date());

        soldHouse.setCustomer(customerRepository.findById(dtoSealedHouseIU.getCustomerId()).orElse(null));
        soldHouse.setRealEstateAgent(realEstateAgentRepository.findById(dtoSealedHouseIU.getRealEstateAgentId()).orElse(null));
        soldHouse.setHouse(houseRepository.findById(dtoSealedHouseIU.getHouseId()).orElse(null));
        return soldHouse;
    }

    @Override
    public DtoSealedHouse buyHouse(DtoSealedHouseIU dtoSealedHouseIU) {

        if(!checkAmount(dtoSealedHouseIU)){
            throw new BaseException(new ErrorMessage(MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH,dtoSealedHouseIU.getCustomerId().toString()));
        }
        if (!checkHouseStatus(dtoSealedHouseIU.getHouseId())) {
            throw new BaseException(new ErrorMessage(MessageType.HOUSE_STATUS_IS_ALREADY_SOLD,dtoSealedHouseIU.getHouseId().toString()));
        }

        SoldHouse savedSoldHouse = soldHouseRepository.save(createSealedHouse(dtoSealedHouseIU));

        House house = savedSoldHouse.getHouse();
        house.setStatus(HouseStatusType.SOLD);

        Customer customer = savedSoldHouse.getCustomer();
        customer.getAccount().setAmount(remainingCustomerAmount(customer,house));
        customerRepository.save(customer);

        houseRepository.save(house);
        return toDto(savedSoldHouse);
    }

    public DtoSealedHouse toDto(SoldHouse soldHouse){
        DtoSealedHouse dtoSealedHouse = new DtoSealedHouse();
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoRealEstateAgent dtoRealEstateAgent = new DtoRealEstateAgent();
        DtoHouse dtoHouse = new DtoHouse();

        BeanUtils.copyProperties(soldHouse, dtoSealedHouse);
        BeanUtils.copyProperties(soldHouse.getCustomer(), dtoCustomer);
        BeanUtils.copyProperties(soldHouse.getRealEstateAgent(), dtoRealEstateAgent);
        BeanUtils.copyProperties(soldHouse.getHouse(), dtoHouse);

        dtoSealedHouse.setCustomer(dtoCustomer);
        dtoSealedHouse.setRealEstateAgent(dtoRealEstateAgent);
        dtoSealedHouse.setHouse(dtoHouse);

        return dtoSealedHouse;
    }

}
