package com.mwaseem.fp.profit;

/**
 * Created by mohd.waseem on 29/03/20.
 */
public class Sales implements QuantityOfInterest {
    private final FunctionOverTime valueFunction;

    public Sales(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

    @Override
    public String getName() {
        return "Sales";
    }

    @Override
    public double valueAt(int time) {
        return valueFunction.valueAt(time);
    }
}
