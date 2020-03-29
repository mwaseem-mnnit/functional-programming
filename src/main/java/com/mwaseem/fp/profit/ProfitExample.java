package com.mwaseem.fp.profit;

/**
 * Created by mohd.waseem on 28/03/20.
 */
public class ProfitExample {
    final static double[] EXPECTED_SALES = new double[]{ 42.00, 45.00, 52.50, 51.50, 43.90 , 39.89,
                                                         61.00, 54.12, 39.99, 54.80, 78.60, 47.50 };
    public static void main(String[] args) {
        /*Without type safety*/
        withoutTypeSafety();

        /*with type safety*/
        withTypeSafety();
    }

    public static void withTypeSafety() {
        final Sales sales = new Sales(FunctionOverTime.monthByMonth(EXPECTED_SALES));
        final IncrementalCost incrementalCost = new IncrementalCost(FunctionOverTime.line(5.1, 0.15));
        final FixedCost fixedCost = new FixedCost(FunctionOverTime.constant(15.0));
        final Profit profit = new Profit(sales, fixedCost, incrementalCost);
        for( int time=1; time <= 12; time++) {
            System.out.print(profit.valueAt(time)+" ");
        }
        System.out.println("");
    }

    public static void withoutTypeSafety() {
        final FunctionOverTime sales = FunctionOverTime.monthByMonth(EXPECTED_SALES);
        final FunctionOverTime incrementalCost = FunctionOverTime.line(5.1, 0.15);
        final FunctionOverTime fixedCost = FunctionOverTime.constant(15.0);
        final FunctionOverTime profit =
                FunctionOverTime.combinationOf3(sales, incrementalCost, fixedCost,
                        (s, ic, fc)-> s - ( ic + fc ));
        for( int time=1; time <= 12; time++) {
            System.out.print(profit.valueAt(time)+" ");
        }
        System.out.println();
    }
}
