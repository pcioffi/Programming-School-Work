package Polymorphism_Project;

public class PayrollSystemDemo{
	public static void main(String args[]){
	    //one of each subclass object
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 769.50);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Barbara", "Jules", "222-22-2222", 26.00, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Storm", "333-33-3333", 25650, .09);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Michael", "Lewis", "444-44-4444", 7000, .08, 250);
	
		//creating an Employee object array
		Employee employees[] = new Employee[4];
		
		//filling array with subclass objects
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
	
		//printing out each element of the 'employees' array
		for(int i = 0; i < employees.length; i++){
			System.out.println(employees[i]);
	
			//reward salaried-commission employees, adding 10%
			if(employees[i] instanceof BasePlusCommissionEmployee){
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) employees[i];
	
				double oldBaseSalary = employee.getBaseSalary();
				employee.setBaseSalary(1.10  * oldBaseSalary);
				System.out.printf("**New base salary with 10%% increase is: $%,.2f**\n", employee.getBaseSalary() );
			}
			
			System.out.printf("   Earned: $%,.2f\n\n", employees[i].earnings());
		}
	}
}