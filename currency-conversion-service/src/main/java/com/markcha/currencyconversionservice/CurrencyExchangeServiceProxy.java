package com.markcha.currencyconversionservice;

import feign.Headers;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.math.BigDecimal;

//@FeignClient(name="currency-exchange-service", url="http://localhost:8000")
@RibbonClient(name="currency-exchange-service")
@FeignClient(name="api-gateway")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")

    public CrurrencyConversionBean rerieveEchangeValue(
            @RequestHeader("Authorization") String token,
            @PathVariable("from") String from,
            @PathVariable("to") String to
    );
}
