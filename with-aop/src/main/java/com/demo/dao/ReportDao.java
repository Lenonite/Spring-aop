package com.demo.dao;

import com.demo.ds.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportDao {

    public void save(Report report){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException() ;

        }

        System.out.println(report.getClass().getSimpleName()+"saved.");

    }
}
