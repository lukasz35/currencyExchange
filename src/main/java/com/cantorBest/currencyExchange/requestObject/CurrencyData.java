package com.cantorBest.currencyExchange.requestObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@ToString
public class CurrencyData {
    String base;
    Date date;
    Map<String, Double > rates;

}
