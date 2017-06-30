package Polymorphism_Project;

import java.text.NumberFormat;

public class SalariedEmployee extends Employee{
	private double weeklySalary;

    //SalariedEmployee Constructor
    public SalariedEmployee(String first, String last, String ssn, double salary){
    	super(first, last, ssn);
        setWeeklySalary(salary);
    }

    // set method of weekly salary
    public void setWeeklySalary(double salary){
    	if(salary < 0.0)
    		weeklySalary = 0.0;
    	else
    		weeklySalary = salary;
    }

    //get method of weekly salary
    public double getWeeklySalary(){ return weeklySalary; }

    //override abstract method earnings in Employee
    public double earnings(){ return getWeeklySalary(); }

    //overridden toString method
    public String toString(){
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "Salaried Employee" + super.toString() +
        	   "\nWeekly Salary: " + formatter.format(getWeeklySalary());
    }
}