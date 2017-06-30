package Polymorphism_Project;

import java.text.NumberFormat;

public class CommissionEmployee extends Employee{
	private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String first, String last, String ssn, double sales, double rate){
        super(first, last, ssn);
        setGrossSales(sales);
        setCommissionRate(rate);
    }

    //set methods for commission rate & gross sales
    public void setCommissionRate(double rate){
        if(rate > 0.0 && rate < 1.0)
        	commissionRate = rate;
        else
        	commissionRate = 0.0;
    }
    public void setGrossSales(double sales){
        if(sales < 0.0)
        	grossSales = 0.0;
        else
        	grossSales = sales;
    }

    //get methods for commission rate & gross sales
    public double getCommissionRate(){ return commissionRate; }
    public double getGrossSales(){ return grossSales; }

    //override abstract method earnings in Employee
    public double earnings(){ return getCommissionRate() * getGrossSales(); }

    //overridden toString method
    public String toString(){
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "Commission Employee" + super.toString() +
        	   "\nGross Sales: " + formatter.format(getGrossSales()) +
        	   "\nCommission Rate: " + formatter.format(getCommissionRate());
    }
}