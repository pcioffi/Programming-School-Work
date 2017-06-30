package QuadInheritance;

public class Trapezoid extends Quadrilateral{
	public Trapezoid(double x1, double x2, double x3, double x4, double y1, double y2){
		super(x1, x2, x3, x4, y1, y1, y2, y2);
		//y1 and y2 are the same
		//y3 and y4 are the same
	}
	
	//length of bottom side
	public double LengthA(){
		return Math.abs(x2 - x1);
	}
	//length of top side
	public double LengthB(){
		return Math.abs(x4 - x3);
	}
	public double height(){
		return Math.abs(y3 - y1);
	}
	
	public double getArea(){
		double area = (((LengthA() + LengthB()) / 2) * height());
		return area;
	}
	
	public String toString(){
		String output = 
				"Coordinates of Trapezoid are:\n(" +
				super.x1 + ", " +
				super.y1 + "), (" +
				super.x2 + ", " +
				super.y2 + "), (" +
				super.x3 + ", " +
				super.y3 + "), (" +
				super.x4 + ", " +
				super.y4 + ")\nBottom Length is: " +
				LengthA() + "\nTop Length is: " +
				LengthB() + "\nHeight is: " +
				height() + "\nArea is: " +
				getArea() +"\n"
		;
		return output;
	}
}
