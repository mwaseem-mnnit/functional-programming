package com.mwaseem.fp.timing.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by mohd.waseem on 29/03/20.
 */
public class TimingExample {
static final Logger logger = LogManager.getLogger(TimingExample.class);
    public static void main(String[] args) {
        final double cost = Timing.timed("Cost Calculation", TimingExample::calculateCost);
        final double revenue = Timing.timed("Revenue Calculation", TimingExample::calculateRevenue);
        final double profit = Timing.timed("Profit Calculation", TimingExample::calculateProfit, logger::info);
        System.out.println( "revenue: " + revenue + ", cost: " + cost + ", profit: " + profit);
    }

    private static double calculateCost() {
        pretendToHardWork();
        return 70.7;
    }

    private static double calculateRevenue() {
        pretendToHardWork();
        return 90.7;
    }

    private static double calculateProfit() {
        pretendToHardWork();
        return 20.7;
    }

    private static void pretendToHardWork() {
        try {
            Thread.sleep((int)(Math.random()*((1000-10)+1))+10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
