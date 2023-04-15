package com.assignment.studentmanagement.practice;

import java.util.ArrayList;



public interface Bank {
	public void saveDetail(BankDTO bankDTO);
	public ArrayList<BankDTO> getDetail();
	public ArrayList<BankDTO> getSearchDetail(String name);
	public void delete(int id);
	public long getGreatest();
	public boolean depositeAmount(BankDTO bankDTO);
	public double getTotalAmount() ;
	public boolean increaseBalance(String name, double amount);
	public void getadminLogIn(String name, String password);
	public boolean login(String name,long accountNum);
	public BankDTO getUserDetail(long accountNum);//for detail pass by accountnum
	public boolean withdraw(String name, double amount) ;
}
