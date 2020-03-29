package com.mwaseem.fp.profit;

/**
 * Created by mohd.waseem on 29/03/20.
 */
public class IncrementalCost implements QuantityOfInterest {
    private final FunctionOverTime valueFunction;

    public IncrementalCost(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

    @Override
    public String getName() {
        return "Incremental Cost";
    }

    @Override
    public double valueAt(int time) {
        return valueFunction.valueAt(time);
    }
}
