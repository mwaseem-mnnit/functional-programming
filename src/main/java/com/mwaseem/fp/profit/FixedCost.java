package com.mwaseem.fp.profit;

/**
 * Created by mohd.waseem on 29/03/20.
 */
public class FixedCost implements QuantityOfInterest {
    private final FunctionOverTime valueFunction;

    public FixedCost(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

    @Override
    public String getName() {
        return "Fixed Cost";
    }

    @Override
    public double valueAt(int time) {
        return valueFunction.valueAt(time);
    }
}
