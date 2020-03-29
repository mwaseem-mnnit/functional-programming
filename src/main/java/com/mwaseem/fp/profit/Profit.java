package com.mwaseem.fp.profit;

/**
 * Created by mohd.waseem on 29/03/20.
 */
public class Profit implements QuantityOfInterest {
    private final Sales sales;
    private final FixedCost fixedCost;
    private final IncrementalCost incrementalCost;

    public Profit(Sales sales, FixedCost fixedCost, IncrementalCost incrementalCost) {
        this.sales = sales;
        this.fixedCost = fixedCost;
        this.incrementalCost = incrementalCost;
    }

    @Override
    public String getName() {
        return "Profit";
    }

    @Override
    public double valueAt(int time) {
        return sales.valueAt(time) -
                (fixedCost.valueAt(time) + incrementalCost.valueAt(time));
    }
}
