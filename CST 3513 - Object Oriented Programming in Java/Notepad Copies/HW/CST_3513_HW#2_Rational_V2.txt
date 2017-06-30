package Rational;
public class Rational {
    private int num; //numerator
    private int den; //denominator

    //initialize Rational object
    public Rational(int numerator, int denominator) {
    	num = numerator;
        den = denominator;
        reduction();
    }

    //reduces(m, n)
    private void reduction() {	
    	int num1 = num;
		int num2 = den;
		
		//find GCD
	    while(num1 != 0 && num2 != 0){
	    	int temp = num2;
	    	num2 = num1 % num2;
	    	num1 = temp;
	    }
		int common = num1 + num2; //either num1 or num2 is 0, therefore the other is the common divisor
		
		//actual reduction
		num = num / common;
		den = den / common;	

    }

    //return (this + b)
    public void Addition(Rational b) {
        int numer = (this.num * b.den) + (this.den * b.num);
        int denom = this.den * b.den;
        
        Rational add = new Rational(numer, denom);
        System.out.println(this + " + " + b  + " = " + add);
        
    	double n = numer;
    	double d = denom;
        double dAdd = n / d;
        System.out.println(add + " = " + dAdd);
    }
    
    //return (this - b)
    public void Subtraction(Rational b) {
        int numer = (this.num * b.den) - (this.den * b.num);
        int denom = this.den * b.den;
        
        Rational sub = new Rational(numer, denom);
        System.out.println(this + " - " + b  + " = " + sub);
        
    	double n = numer;
    	double d = denom;
        double dSub = n / d;
        System.out.println(sub + " = " + dSub);
    }

    //return (this * b)
    public void Multiplication(Rational b) {
    	int numer = this.num * b.num;
    	int denom = this.den * b.den;
    	
    	Rational mul =  new Rational(numer, denom);
        System.out.println(this + " * " + b  + " = " + mul);
        
    	double n = numer;
    	double d = denom;
        double dMul = n / d;
        System.out.println(mul + " = " + dMul);
    }
    
    
    //return (this / b)
    public void Division(Rational b) {
    	int numer = this.num * b.den;
    	int denom = this.den * b.num;
    	
    	Rational div = new Rational(numer, denom);
        System.out.println(this + " / " + b  + " = " + div);
        
        double n = numer;
    	double d = denom;
        double dDiv = n / d;
        System.out.println(div + " = " + dDiv);
    }
    
    //return string representation
    public String toString() {
        return num + "/" + den;
    }
    
    public static void main(String[] args) {
    	//declaring two instances of Rational to test methods
    	Rational x = new Rational(1, 3);
    	Rational y = new Rational(7, 8);
        
        x.Addition(y);
        x.Subtraction(y);
        x.Multiplication(y);
        x.Division(y);
    }
}
