package com.nextstep.Java.first;

import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args) {
		//need to create obj to get input from user
		Scanner sc=new Scanner(System .in);
		int a,b,sum;
		System.out.println("enter any two number");
		a=sc.nextInt();
		b=sc.nextInt();
		sum=a+b;
		System.out.println("the sum of two num"+sum);
		
	}

}
