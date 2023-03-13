package com.nextstep.Java.first;

public class Function2 {
public void sumValue(int a,int b) {
	int s=a+b;

	System.out.println("sum is:"+s);
}

public void diffValue(int a,int b) {
	int d=a-b;
	System.out.println("diff is:"+d);
}
public void prodValue(int a,int b) {
	int p=a*b;
	System.out.println("product is:"+p);
}
public void divValue(int a,int b) {
	double v=(double)a/b;
	System.out.println("Div is:"+v);
}
public static void main(String[]args) {
	Function2 obj=new Function2();
	obj.sumValue(5, 2);
	obj.diffValue(10,5);
	obj.prodValue(2,4);
	obj.divValue(10,5);

			
}
}
	
	


