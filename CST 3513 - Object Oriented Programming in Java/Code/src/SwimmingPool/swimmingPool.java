package SwimmingPool;

public class swimmingPool {
	private double length;
	private double width;
	private double depth;
	private double rateFill; //gallons per minute
	private double rateDrain; //gallons per minute
	private static double gallonsInCubicFeet = 7.48;
	
	public swimmingPool(){
		this.length = 1;
		this.width = 1;
		this.depth = 1;
		this.rateFill = 1;
		this.rateDrain = 1;
	}
	
	public swimmingPool(double length, double width, double depth, double rateFill, double rateDrain){
		this.length = length;
		this.width = width;
		this.depth = depth;
		this.rateFill = rateFill;
		this.rateDrain = rateDrain;
	}
	
	//Determine the amount of water needed to fill an empty or partially filled pool
	public double waterAmount(){
		return area() * gallonsInCubicFeet;
	}
	public double waterAmount(double currentWater){
		return waterAmount() - currentWater;
	}
	
	//Determine the amount of time needed to completely or partially fill the pool
	public int timeFillPool(){
		int time = 0;
		double volume = waterAmount();
		while(volume > 0){
			volume= volume - this.rateFill;
			time++;
		}
		return time;
	}
	public int timeFillPool(double currentWater){
		int time = 0;
		double volume = waterAmount() - currentWater;
		while(volume > 0){
			volume= volume - this.rateFill;
			time++;
		}
		return time;
	}
	
	//Determine the amount of time needed to completely or partially empty the pool
	public int timeDrainPool(){
		int time = 0;
		double volume = waterAmount();
		while(volume > 0){
			volume= volume - this.rateDrain;
			time++;
		}
		return time;
	}
	public int timeDrainPool(double currentWater){
		int time = 0;
		double volume = currentWater;
		while(volume > 0){
			volume= volume - this.rateDrain;
			time++;
		}
		return time;
	}
	
	//Add water or drain for a specific amount of time.
	public double addWater(int time){
		double waterAdded = rateFill * time;
		if(waterAdded >= waterAmount())
			waterAdded = waterAmount();
		return waterAdded;
	}
	public double removeWater(int time){
		double waterRemoved = rateDrain * time;
		if(waterAmount() - waterRemoved <= 0)
			waterRemoved = waterAmount();
		return waterRemoved;
	}
	
	//Helper Methods
	private double area(){
		return this.length * this.width * this.depth;
	}
}
