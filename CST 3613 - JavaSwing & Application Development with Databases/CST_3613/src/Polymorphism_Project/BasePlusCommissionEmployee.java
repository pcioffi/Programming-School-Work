package Polymorphism_Project;

import java.text.NumberFormat;

public class BasePlusCommissionEmployee extends CommissionEmployee{
	private double baseSalary;

    public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double salary){
        super(first, last, ssn, sales, rate);
        setBaseSalary(salary);
    }

    //set method for base salary
    public void setBaseSalary(double salary){
        if(salary < 0.0)
        	baseSalary = 0.0;
        else
        	baseSalary = salary;
    }

    //get method for base salary
    public double getBaseSalary(){ return baseSalary; }

    //override method earnings in CommissionEmployee
    public double earnings(){ return getBaseSalary() + super.earnings(); }

    //overridden toString method
    public String toString(){
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "Base-Salaried " + super.toString() +
        	   "\nBase Salary: " + formatter.format(getBaseSalary());
    }
}