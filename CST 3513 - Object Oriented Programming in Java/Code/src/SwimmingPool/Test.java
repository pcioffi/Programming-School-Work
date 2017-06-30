package SwimmingPool;

public class Test {
	public static void main(String[] args){
		swimmingPool myPool = new swimmingPool(5,5,7,16,12);
		
		System.out.println("The amount of water that can fill the pool is: ");
		System.out.println(myPool.waterAmount());
		
		System.out.println("The time it takes to fill the pool is: ");
		System.out.println(myPool.timeFillPool());
		
		System.out.println("The time it takes to drain the pool is: ");
		System.out.println(myPool.timeDrainPool());
		
		System.out.println("Filling the pool for 8 minutes adds: ");
		System.out.println(myPool.addWater(8));
		
		System.out.println("Draining the pool for 10 minutes removes: ");
		System.out.println(myPool.removeWater(10));
	}
}