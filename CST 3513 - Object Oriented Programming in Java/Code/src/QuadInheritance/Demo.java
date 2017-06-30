package QuadInheritance;

public class Demo {
	public static void main(String[] args){
		Quadrilateral quad = new Quadrilateral(1.1, 6.6, 6.2, 2.2, 1.2, 2.8, 9.9, 7.4);
		System.out.println(quad);
		
		Trapezoid trap = new Trapezoid(0, 10, 8, 3.3, 0, 5);
		System.out.println(trap);
		
		Parallelogram para = new Parallelogram(5, 11, 6 ,5, 20);
		System.out.println(para);

		Rectangle rect = new Rectangle(17, 30, 14, 28);
		System.out.println(rect);
		
		Square sqre = new Square(4, 8, 0);
		System.out.println(sqre);
	}
}
