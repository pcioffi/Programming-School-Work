package Day;

public class Day {
	int day;
	
	//constructors
	public Day(){
		this.day = 0;
	}
	public Day(int day) {
		this.day = day;
	}

	//sets the day
	public void setDay(int day){
		this.day = day;
	}
	//prints the day
	public void printDay(){
		System.out.print(new Day(this.day));
	}
	//returns the current day
	public Day today(){
		return new Day(this.day);
	}
	//returns the next day
	public Day tomorrow(){
		return new Day(this.day + 1);
	}
	//returns the previous day
	public Day yesterday(){
		return new Day(this.day - 1);
	}
	//adding days to current day object
	public Day addDays(int day){
		return new Day((this.day + day) % 7);
	}
	//generates the int value of 'day' into a string format when declared
	public String toString(){
		String[] dayText = {"Sun", "Mon", "Tues", "Wed", "Thu", "Fri", "Sat"};
		return dayText[this.day];
	}
	
	//testing with main method
	public static void main(String[] args){
		Day day = new Day();
		System.out.println(day + " is the default day");
		System.out.println();
		
		day.setDay(3);
		day.printDay();
		System.out.println(" is what you get when you set the day to '3'");
		System.out.println();
		
		System.out.println("Today is " + day.today());
		System.out.println("Tomorrow is " + day.tomorrow());
		System.out.println("Yesterday was " + day.yesterday());
		System.out.println();
		
		Day monday = new Day(1);
		System.out.println("Four days after " + monday + " is " + monday.addDays(4));
		
		Day tuesday = new Day(2);
		System.out.println("Thirteen days after " + tuesday + " is " + tuesday.addDays(13));
	}
}