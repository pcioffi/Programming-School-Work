package QuadInheritance;

public class Rectangle extends Parallelogram{
	public Rectangle(double x1, double x2, double y1, double y2){
		super(x1, x2, x1, y1, y2);
		//x3 = x1
	}
	
	public double getArea(){
		double area = super.height() * super.width();
		return area;
	}
	
	public String toString(){
		String output = 
				"Coordinates of Rectangle are:\n(" +
				super.x1 + ", " +
				super.y1 + "), (" +
				super.x2 + ", " +
				super.y2 + "), (" +
				super.x3 + ", " +
				super.y3 + "), (" +
				super.x4 + ", " +
				super.y4 + ")\nWidth is: " +
				super.width() + "\nHeight is: " +
				super.height() + "\nArea is: " +
				getArea() +"\n"
		;
		return output;
	}
}
