package com.markcha.currencyconversionservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    private final CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    public CurrencyConversionController(CurrencyExchangeServiceProxy currencyExchangeServiceProxy) {
        this.currencyExchangeServiceProxy = currencyExchangeServiceProxy;
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CrurrencyConversionBean rerieveEchangeValue(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ) {
        Map<String, String> uriValiables = new HashMap<>();
        uriValiables.put("from", from);
        uriValiables.put("to", to);

        ResponseEntity<CrurrencyConversionBean> responseEntity =new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CrurrencyConversionBean.class,
                uriValiables
        );
        System.out.println(responseEntity);

        CrurrencyConversionBean response = responseEntity.getBody();
        return new CrurrencyConversionBean(
                response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                quantity.multiply(response.getConversionMultiple()),
                quantity,
                response.getPort()
        );
    }
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CrurrencyConversionBean rerieveEchangeValueFegin(
            @RequestHeader("Authorization") String token,
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ) {
        CrurrencyConversionBean response = currencyExchangeServiceProxy.rerieveEchangeValue(token, from, to);
        return new CrurrencyConversionBean(
                response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                quantity.multiply(response.getConversionMultiple()),
                quantity,
                response.getPort()
        );
    }
}
