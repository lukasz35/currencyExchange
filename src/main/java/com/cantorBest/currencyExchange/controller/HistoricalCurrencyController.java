package com.cantorBest.currencyExchange.controller;

import com.cantorBest.currencyExchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/historical")
public class HistoricalCurrencyController {
    @Autowired
    CurrencyService currencyService;

    @RequestMapping("/all")
    public String getHistoricalCurrencyFromPeriod( @RequestParam String start_at, @RequestParam String end_at, Model model ){
        model.addAttribute("currency", currencyService.getHistoricalCurrencyFromPeriod( start_at, end_at ));
        return "historicalCurrency";
    }
    @RequestMapping("/filter")
    public String getHistoricalCurrencyBase(@RequestParam String start_at,
                                            @RequestParam String end_at,
                                            @RequestParam(defaultValue="PLN") String base,
//                                            @RequestParam(defaultValue="EUR") String symbols,
                                            @RequestParam(required = false) String symbols,
                                            Model model){
        model.addAttribute("currency", currencyService.getHistoricalCurrencyBase(
                start_at, end_at, base, symbols
        ));
        return "historicalCurrency";
    }
}
