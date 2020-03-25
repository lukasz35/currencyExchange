package com.cantorBest.currencyExchange.controller;

import com.cantorBest.currencyExchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/latest")
    public String getCurrencyDataAsObject(Model model){
        model.addAttribute("currency", currencyService.getCurrencyDataAsObject());
        return "currency";
    }

    @GetMapping("/adam")
    public String dupa(Model model){
        return "hello";
    }

    @GetMapping("/day/{date}")
    public String getHistoricalDataFromDay(@PathVariable("date") String dateString, Model model){
        System.out.println(dateString);
        model.addAttribute("currency", currencyService.getHistoricalDataFromDay(dateString));
        return "currency";
    }

    @GetMapping("/symbols/{symbols}")
    public String getlDataForSymbols(@PathVariable("symbols") String symbolsString, Model model){

        model.addAttribute("currency", currencyService.getlDataForSymbols(symbolsString));
        return "currency";
    }
    @GetMapping("/base/{currency}")
    public String getlDataForCurrency(@PathVariable("currency") String currencyString, Model model){
        model.addAttribute("currency", currencyService.getlDataForCurrency(currencyString));
        return "currency";
    }




}
