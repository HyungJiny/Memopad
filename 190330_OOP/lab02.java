interface INumber {
	public int value;
	public int add();
	public int subtract();
	public int multiply();
	public int getValue();
	public void setValue();
	public void printValue();
}

public class IntClass implements INumber {
	public IntClass(int value){
		this.value = value;
	}

	@Override
	public int add(int number){
		return this.value += number;
	}

	@Override
	public int subtract(int number){
		return this.value -= number;
	}

	@Override
	public int multiply(int number){
		return this.value *= number;
	}
	
	@Override
	public int getValue(){
		return this.value;
	}

	@Override
	public void setValue(int number){
		this.value = number;
	}
	
	@Override
	public void printValue(){
		System.out.println(this.value);
	}
}

public class NatClass implements INumber {
	public IntClass(int value){
		if(isNat(value)){ this.value = value; }
		else{ this.value = 0; }
	}

	private boolean isNat(int number){
		if(number >= 0) { return true; }
		else { return false; }
	}

	private void error(){
		System.out.println("wrong number!");
		System.exit(0);
	}

	@Override
	public int add(int number){
		this.value += number;
		if(isNat(this.value)){ return this.value; }
		else{ error(); return -1; }
	}

	@Override
	public int subtract(int number){
		this.value -= number;
		if(isNat(this.value)){ return this.value; }
		else{ error(); return -1; }
	}

	@Override
	public int multiply(int number){
		this.value *= number;
		if(isNat(this.value)){ return this.value; }
		else{ error(); return -1; }
	}
	
	@Override
	public int getValue(){
		return this.value;
	}

	@Override
	public void setValue(int number){
		this.value = number;
	}
	
	@Override
	public void printValue(){
		System.out.println(this.value);
	}
}

class Equation{
	private INumber number; 
	private int a;
	private int b;
	private int c;
	private int root1;
	private int root2;

	public Equation(INumber number){
		// a*x*x + b*x + c
		this.number = number;
	}

	public void setA(int a){
		this.number.setValue(a);
		this.a = this.number.getValue();
	}	
	
	public void setB(int b){
		this.number.setValue(b);
		this.b = this.number.getValue();
	}

	public void setC(int c){
		this.number.setValue(c);
		this.c = this.number.getValue();
	}

	public void solve(){
		discriminant = Math.pow(this.b, 2) - (4 * this.a * this.c);
		this.root1 = ((-1 * this.b) + Math.sqrt(discriminant)) / (2*this.a);
		this.root2 = ((-1 * this.b) - Math.sqrt(discriminant)) / (2*this.a);
	}

	public INumber getRoot1(){
		return this.root1;
	}

	public INumber getRoot2(){
		return this.root2;
	}
}

class Test{
	public static void main(String[] args){
		// main
	}
}
