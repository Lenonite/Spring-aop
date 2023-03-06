package com.demo;

import com.demo.ds.CurrencyType;
import com.demo.service.AlterCurrencyService;
import com.demo.service.CurrentcyService;
import com.demo.service.MyCurrencyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        CurrentcyService currentcyService=context.getBean(CurrentcyService.class);


        AlterCurrencyService alterCurrencyService=context.getBean(AlterCurrencyService.class);
        MyCurrencyService myCurrencyService=context.getBean(MyCurrencyService.class);
        currentcyService.changeCurrency(100,1.2);
        alterCurrencyService.changeCurrency(500,2.5);

        myCurrencyService.changeCurrency();
        myCurrencyService.changeCurrency(1000,2.6);
        myCurrencyService.currencyLongName(CurrencyType.US);
        myCurrencyService.currencyLongName(CurrencyType.EURO);
        myCurrencyService.currencyCountryName(CurrencyType.US);
        try {
            myCurrencyService.currencyCountryName(CurrencyType.EURO);
        }catch (IllegalArgumentException e){
            System.out.println("Exception caught");
        }


    }
}
