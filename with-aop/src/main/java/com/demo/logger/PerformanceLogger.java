package com.demo.logger;

import org.springframework.stereotype.Component;

@Component
public class PerformanceLogger{

    public PerformanceInfo begin(String name){
        return new PerformanceInfo(name,System.currentTimeMillis());
    }
    public void end(PerformanceInfo info){
        long startTime=info.getTime();
        long endTime=System.currentTimeMillis();
        System.out.println(info.getName()+"take time :: "+(endTime-startTime)+"milliseconds");
    }
    public  static class PerformanceInfo{

        String name;
        long time;

        public PerformanceInfo(String name, long time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public long getTime() {
            return time;
        }
    }
}
