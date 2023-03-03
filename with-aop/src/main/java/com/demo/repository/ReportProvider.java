package com.demo.repository;

import com.demo.annotation.Logger;
import com.demo.ds.Report;
import org.springframework.stereotype.Component;

@Component @Logger
public class ReportProvider {

   public Report reportProvide(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Report Provider provide");
        return new Report();
    }
}
