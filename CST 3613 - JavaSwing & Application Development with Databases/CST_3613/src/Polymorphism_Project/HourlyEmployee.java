package Polymorphism_Project;

import java.text.NumberFormat;

public class HourlyEmployee extends Employee{
	private double wage;
    private double hours;

    public HourlyEmployee(String first, String last, String ssn, double hourlyWage, double hoursWorked){
    	super(first, last, ssn);
        setWage(hourlyWage);
        setHours(hoursWorked);
    }

    //set methods for wage and hours
    public void setWage(double hourlyWage){
        if(hourlyWage < 0.0)
        	wage = 0.0;
        else
        	wage = hourlyWage;
    }   
    public void setHours(double hoursWorked){
        if(hoursWorked >= 0.0 && hoursWorked <= 168.0)
        	hours = hoursWorked;
        else
        	hours = 0.0;
    }

    //get methods for wage and hours
    public double getWage(){ return wage; }
    public double getHours(){ return hours; }

    //override abstract method earnings in Employee
    public double earnings(){
    	if (getHours() <= 40) // no overtime
           return getWage() * getHours();
        else
           return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
    }

    //overridden toString method
    public String toString(){
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "Hourly Employee" + super.toString() +
        	   "\nHourly Wage: " + formatter.format(getWage()) +
        	   "\nHours Worked: " + formatter.format(getHours());
     }
  }