import java.util.Scanner;

public class FinancialForecaster {
    public static double futureVal(double initVal, double[] rates, int periods) {
        if (periods == 0) {
            return initVal;
        }
      
        double currentGrowth = rates[periods - 1];
        double currentValue = initVal * (1 + currentGrowth);
        return futureVal(currentValue, rates, periods - 1);
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial value: ");
        double initialValue = sc.nextDouble();
        double[] growthRates = {0.05, 0.06, 0.04, 0.07};
        
        System.out.println("Financial Forecasting Results:");
        for (int periods = 1; periods <= growthRates.length; periods++) {
            double futureValue = futureVal(initialValue, growthRates, periods);
            System.out.printf("After %d periods future value: %.2f\n", periods, futureValue);
        }
        sc.close();
    }
}
