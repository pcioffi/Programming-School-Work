package QuadInheritance;

public class Square extends Rectangle{
	public Square(double x1, double x2, double y1){
		super(x1, x2, y1, Math.abs(x2 - x1) + y1);
		//y2 is determined by getting the length of x1 and x2, then adding it to y1
	}
	
	public double side(){
		return super.width();
	}
	
	public double getArea(){
		double area = side() * side();
		return area;
	}
	
	public String toString(){
		String output = 
				"Coordinates of Square are:\n(" +
				super.x1 + ", " +
				super.y1 + "), (" +
				super.x2 + ", " +
				super.y2 + "), (" +
				super.x3 + ", " +
				super.y3 + "), (" +
				super.x4 + ", " +
				super.y4 + ")\nSide is: " +
				side() + "\nArea is: " +
				getArea() +"\n"
		;
		return output;
	}
}
