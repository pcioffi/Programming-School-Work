package Polymorphism_Project;

public abstract class Employee{
	private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee(String first, String last, String ssn){
    	firstName = first;
        lastName = last;
        socialSecurityNumber = ssn;
    }

    //set methods for firstName, lastName, & socialSecurityNumber
    public void setFirstName(String first){ firstName = first; }
    public void setLastName(String last){ lastName = last; }
    public void setSocialSecurityNumber(String ssn){ socialSecurityNumber = ssn; }
    
    //get methods for firstName, lastName, & socialSecurityNumber
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getSocialSecurityNumber(){ return socialSecurityNumber; }

    //toString method of Employee object
    public String toString(){
        return "\nName: " + getFirstName() + " " + getLastName() +
        	   "\nSocial Security Number: " + getSocialSecurityNumber();
    }

    // abstract method overridden by subclasses
    public abstract double earnings();
}