package com.markcha.currencyexchangeservice;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExchangeValue {
    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
    @Id
    private Long id;

    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")
    private String to;

//    @Column(name="conversion_multiple")
    private BigDecimal conversionMultiple;
    private int port;
}
