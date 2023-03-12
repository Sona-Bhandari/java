package com.nextstep.Java.first;

import java.util.Scanner;

public class Assignment2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name,address,gender;
		int age;
		double salary;
		System.out.println("enter name");
		name=sc.nextLine();
		System.out.println("enter address");
		address=sc.nextLine();
		System.out.println("enter gender");
		gender=sc.nextLine();
		System.out.println("enter age");
		age=sc.nextInt();
		System.out.println("enter salary");
		salary=sc.nextDouble();
		System.out.println("name is "+name+"\naddress is "+address+"\ngender is "+gender+"\nage "+age+"\nsalary "+salary);
		
		
		
	}

}
