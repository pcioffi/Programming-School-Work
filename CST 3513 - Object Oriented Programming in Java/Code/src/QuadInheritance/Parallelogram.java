package QuadInheritance;

public class Parallelogram extends Trapezoid{
	public Parallelogram(double x1, double x2, double x3, double y1, double y2){
		super(x1, x2, x3, Math.abs(x2 - x1) + x3, y1, y2);
		//x4 is determined by getting the length of x1 and x2 and then adding it to x3
		//y4 = y3
	}
	
	public double width(){
		return super.LengthA();
	}
	
	public double getArea(){
		double area = width() * super.height();
		return area;
	}
	
	public String toString(){
		String output = 
				"Coordinates of Parallelogram are:\n(" +
				super.x1 + ", " +
				super.y1 + "), (" +
				super.x2 + ", " +
				super.y2 + "), (" +
				super.x3 + ", " +
				super.y3 + "), (" +
				super.x4 + ", " +
				super.y4 + ")\nWidth is: " +
				width() + "\nHeight is: " +
				super.height() + "\nArea is: " +
				getArea() +"\n"
		;
		return output;
	}
}
