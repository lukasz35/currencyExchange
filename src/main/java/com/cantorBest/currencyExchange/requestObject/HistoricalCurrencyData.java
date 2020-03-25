package com.cantorBest.currencyExchange.requestObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@ToString
public class HistoricalCurrencyData {

    String base;
    Date start_at;
    Date end_at;
    Map<Date, Map< String, Double> > rates;

}
