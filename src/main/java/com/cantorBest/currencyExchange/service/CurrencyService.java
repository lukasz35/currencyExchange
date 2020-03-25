package com.cantorBest.currencyExchange.service;

import com.cantorBest.currencyExchange.requestObject.CurrencyData;
import com.cantorBest.currencyExchange.requestObject.HistoricalCurrencyData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CurrencyService {
    private static final String CURRENCY_URL_LATEST = "https://api.exchangeratesapi.io/latest";
    private static final String CURRENCY_URL = "https://api.exchangeratesapi.io";
    private static final String CURRENCY_URL_HISTORY = "https://api.exchangeratesapi.io/history";

    private final RestTemplate restTemplate;

    public CurrencyService( RestTemplateBuilder restTemplateBuilder ){
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getDefoultLatestCurrency(){
        return this.restTemplate.getForObject( CURRENCY_URL_LATEST, String.class );
    }


    public CurrencyData getCurrencyDataAsObject(){
        return this.restTemplate.getForObject( CURRENCY_URL_LATEST, CurrencyData.class );
    }

    public  List<String>  getNamesOfCurrency(CurrencyData obj){
        return new ArrayList<>(obj.getRates().keySet());
    }
    public List<Double> getValuesForNames(CurrencyData obj, List<String> currencyNamesList){
        List<Double> variablesList = new ArrayList<>();
        for (String currency: currencyNamesList) {
            variablesList.add(obj.getRates().get(currency));
        }
        return variablesList;
    }

    public CurrencyData getHistoricalDataFromDay(String dateStrnig ){
        return restTemplate.getForObject(CURRENCY_URL+"/"+dateStrnig, CurrencyData.class);
    }
    public CurrencyData getlDataForSymbols(String symbolsStrnig ){
        return restTemplate.getForObject(CURRENCY_URL_LATEST+"?symbols=" + symbolsStrnig, CurrencyData.class);
    }

    public CurrencyData getlDataForCurrency(String currencyString ){
        return restTemplate.getForObject(CURRENCY_URL_LATEST+"?base=" + currencyString, CurrencyData.class);
    }

    public HistoricalCurrencyData getHistoricalCurrencyFromPeriod( String start_at, String end_at){
        return restTemplate.getForObject("https://api.exchangeratesapi.io/history?start_at="+start_at+"&end_at="+end_at, HistoricalCurrencyData.class);
    }
    public HistoricalCurrencyData getHistoricalCurrencyBase( String start_at, String end_at, String base, String symbols ){
        if (symbols != null){
            return restTemplate.getForObject(
                    "https://api.exchangeratesapi.io/history?start_at="
                            +start_at+"&end_at="+end_at+"&base="+base+"&symbols="+symbols,
                    HistoricalCurrencyData.class);
        }else{
            return restTemplate.getForObject(
                    "https://api.exchangeratesapi.io/history?start_at="
                            +start_at+"&end_at="+end_at+"&base="+base,
                    HistoricalCurrencyData.class);
        }
    }
}
