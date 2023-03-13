package com.nextstep.Java.first;

import java.util.Scanner;

import org.w3c.dom.ls.LSOutput;

public class Assignment5 {
	Scanner sc=new Scanner(System.in);
	String name,address,gender;
	int age;
	long contact;
	public void getValue() {
		System.out.println("enter name");
		name=sc.nextLine();
		System.out.println("enter address");
		address=sc.nextLine();
		System.out.println("enter gender");
		gender=sc.nextLine();
		System.out.println("enter age");
		age=sc.nextInt();
		System.out.println("enter contact");
		contact=sc.nextLong();
	}
	public void displayValue() {
		System.out.println("name is"+name);
		System.out.println("address is"+address);
		System.out.println("gender is"+gender);
		System.out.println("age is"+age);
		System.out.println("contact is"+contact);
		
		
	}
	
	public static void main(String[] args) {
		Assignment5 a =new Assignment5();
		a.getValue();
		a.displayValue();
	}
		
		
		
	}


