package com.demo.service;

import com.demo.dao.ReportDao;
import com.demo.ds.Report;
import com.demo.format.ReportFormatter;
import com.demo.logger.PerformanceLogger;
import com.demo.repository.ReportProvider;
import org.springframework.stereotype.Service;
import static com.demo.logger.PerformanceLogger.*;

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
        PerformanceLogger logger=new PerformanceLogger();
        PerformanceInfo performanceInfo=  logger.begin("ReportFormatter::formatReport(new Report())");
        Report formattedReport=reportFormatter.formatReport(new Report());
        logger.end(performanceInfo);

        performanceInfo=logger.begin("ReportDao ::save(formattedReport");
        reportDao.save(formattedReport);
        logger.end(performanceInfo);

        performanceInfo=logger.begin("ReportProvider::reportProvider()");
        Report report=reportProvider.reportProvide();
        logger.end(performanceInfo);


    }
}
