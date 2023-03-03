package com.demo.service;

import com.demo.dao.ReportDao;
import com.demo.ds.Report;
import com.demo.format.ReportFormatter;
import com.demo.logger.PerformanceLogger;
import com.demo.repository.ReportProvider;
import org.springframework.stereotype.Service;

import static com.demo.logger.PerformanceLogger.PerformanceInfo;

@Service
public class ComplexAction {
    private ReportDao reportDao;
    private ReportFormatter reportFormatter;

    private ReportProvider reportProvider;

    public ComplexAction(ReportDao reportDao, ReportFormatter reportFormatter, ReportProvider reportProvider) {
        this.reportDao = reportDao;
        this.reportFormatter = reportFormatter;
        this.reportProvider = reportProvider;
    }
    public void takeAction(){

        Report formattedReport=reportFormatter.formatReport(new Report());



        reportDao.save(formattedReport);



        Report report=reportProvider.reportProvide();



    }
}
