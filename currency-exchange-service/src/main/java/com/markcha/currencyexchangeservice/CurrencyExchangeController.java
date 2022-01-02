package com.markcha.currencyexchangeservice;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private final ExchangeValueRepository exchangeValueRepository;


    public CurrencyExchangeController(Environment environment, ExchangeValueRepository exchangeValueRepository) {
        this.environment = environment;
        this.exchangeValueRepository = exchangeValueRepository;
    }
    @GetMapping("")
    public String test() {
        return "hello";
    }
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue rerieveEchangeValue(
            @PathVariable String from,
            @PathVariable String to
    ) {
        ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
        exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        System.out.println(exchangeValue);
        exchangeValue.setPort(
                Integer.parseInt(environment.getProperty("local.server.port"))
        );
        return exchangeValue;
    }
}
