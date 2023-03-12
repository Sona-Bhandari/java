package com.nextstep.Java.first;

public class Assignment3 {
	final static int TOTAL_NUMBER=30;//constant
	int totalNumber=100;//instance variable
	static String name="Next Step";

	public void sum() {//non static function
		int a=10;//a is local variable
		System.out.println(a);
		
	}
	/*non static:member of obj
	we need to create object to access non static members
	static:member of class
	we can call static member with class name
	*/
	public static void main(String[]args) {
		//creating obj of class
		Assignment3 obj=new Assignment3();
		System.out.println(	Assignment3.TOTAL_NUMBER);//static
		System.out.println(obj.totalNumber);//non static
		obj.sum();//calling non static function
		
	}
	
	
	

}
