package QuadInheritance;

public class Quadrilateral {
	protected double x1, y1, x2, y2, x3, y3, x4, y4;
	
	public Quadrilateral(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4){
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.y4 = y4;
	}
	
	public String toString(){
		String output = 
				"Coordinates of Quadrilateral are:\n(" +
				x1 + ", " +
				y1 + "), (" +
				x2 + ", " +
				y2 + "), (" +
				x3 + ", " +
				y3 + "), (" +
				x4 + ", " +
				y4 + ")\n"
		;
		return output;
	}
}
