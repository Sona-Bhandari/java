package com.assignment.studentmanagement.practice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.IntBinaryOperator;

import javax.accessibility.AccessibleRelationSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.nextstep.studentmanagementsystem.practice.DataBaseConn;
import com.nextstep.studentmanagementsystem.practice.StudentDTO;

public class BankImpl implements Bank {
	PreparedStatement ps=null;
	private JTextField nametextField;
	private JTextField passwordtextField_1;
	public void saveDetail(BankDTO bankDTO) {
		
		String sql ="insert into bank(name,address,contact,gender,accountnum,balance)value(?,?,?,?,?,?)";
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ps.setString(1,bankDTO.getName());
			ps.setString (2,bankDTO.getAddress());
			ps.setLong (3,bankDTO.getContact());
			ps.setString (4,bankDTO.getGender());
		
			ps.setLong (5,bankDTO.getAccountnumber());
		ps.setDouble(6,bankDTO .getBalance());
			ps.executeUpdate ();
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println(e);
		}
		
	}
	public ArrayList<BankDTO>getDetail(){
		String sqlString=("select * from bank");
		ArrayList<BankDTO>studentList=new ArrayList<>();
		try {
		ps=DataConnection.getConnection().prepareStatement(sqlString);
		ResultSet rSet=ps.executeQuery();
		while(rSet.next()) {
				
			BankDTO obj =new BankDTO();
			obj.setId(rSet.getInt("id"));
			obj.setName(rSet.getString("name"));
			obj.setAddress(rSet.getString("address"));
			obj.setContact(rSet.getLong("contact"));
			obj.setGender(rSet.getString("gender"));
			obj.setAccountnumber(rSet.getLong("accountnum"));
			obj.setBalance(rSet.getDouble("balance"));
			studentList.add(obj);
			
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return studentList;
		
	}
	public ArrayList<BankDTO> getSearchDetail(String name) {
		String sqlString="select * from bank where name like?";
		ArrayList<BankDTO>studentList =new ArrayList<>();
		try {
			ps=DataConnection.getConnection().prepareStatement(sqlString);
			ps.setString(1,"%"+name+"%" );
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()) {
				BankDTO objDto=new BankDTO();
				objDto.setId(rSet.getInt("id"));
				objDto.setName(rSet.getString("name"));
				objDto.setAddress(rSet.getString("address"));
				objDto.setContact(rSet.getLong("contact"));
				objDto.setGender(rSet.getString("gender"));
				objDto.setAccountnumber(rSet.getLong("accountnum"));
				objDto.setBalance(rSet.getDouble("balance"));
				studentList.add(objDto);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return studentList ;
		
	}
	
	public void delete(int id) {
		String sql="delete from bank where id=?";
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean depositeAmount(BankDTO bankDTO) {
	boolean success=false;
	String sql="update bank set amount=?where accountNumber=?";
	try {
		ps=DataConnection.getConnection().prepareStatement(sql);
		ps.setDouble(1,bankDTO.getBalance());
		ps.setDouble(2, bankDTO.getAccountnumber());
		ps.executeUpdate();
		success=true;
		
		} catch (Exception e) {
		success =false;
		e.printStackTrace();
	}
		return success;
	}
	
	public long getGreatest() {
		long accountNumber=0;
		String sql="SElECT max(accountnum)accountnum from bank";
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 accountNumber = rs.getLong("accountnum");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return accountNumber;
	}
	public double getTotalAmount() {
		ArrayList<BankDTO> bankDetails=new ArrayList<>();
		
	    double total = 0;
	   
		for (BankDTO bankDTO : bankDetails) {
	        total += bankDTO.getBalance();
	    }
	    return total;
	}
	public boolean increaseBalance(String name, double amount) {
	    String selectSql = "SELECT balance FROM bank WHERE name = ?";
	    String updateSql = "UPDATE bank SET balance = ? WHERE name = ?";
	    boolean success = false;
	    try {
	       
	         ps = DataConnection.getConnection().prepareStatement(selectSql);
	        ps.setString(1, name);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            double currentBalance = rs.getDouble("balance");
	        
	            double newBalance = currentBalance + amount;
	            
	            PreparedStatement updatePs = DataConnection.getConnection().prepareStatement(updateSql);
	            updatePs.setDouble(1, newBalance);
	            updatePs.setString(2, name);
	            updatePs.executeUpdate();
	            success = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}
	
	public void getadminLogIn(String name, String password) {
	    String sql = "select * from admin where name=? AND password=?";

	    try {
	        ps = DataConnection.getConnection().prepareStatement(sql);

	        ps.setString(1, name);

	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            JOptionPane.showMessageDialog(null, "Login success", "Success", JOptionPane.INFORMATION_MESSAGE);
	            new BankDetails().setVisible(true);
	        } else {
	            JOptionPane.showMessageDialog(null, "InValid", "Error", JOptionPane.ERROR_MESSAGE);
	        }

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
	public boolean login(String name, long accountNum) {
		boolean isUserExist=false;
		String sql="Select * from bank where name=? AND accountnum=?";
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ps.setString(1,name);
			ps.setLong(2, accountNum);
			ResultSet rsResultSet=ps.executeQuery();
			while(rsResultSet.next()) {
				isUserExist=true;
				
			}
			
			
		} catch (Exception e) {
		System.out.println(e);
		}
		return isUserExist;
	}
	@Override
	public BankDTO getUserDetail(long accountNum) {
		String sql="select * from bank where  accountnum=?";
		BankDTO studentDto=new BankDTO();
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ps.setLong(1, accountNum);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()) {
				studentDto.setId(rSet.getInt("id"));
				studentDto.setName(rSet.getString("name"));
				studentDto.setAddress(rSet.getString("address"));
				studentDto.setContact(rSet.getLong("contact"));
				studentDto.setGender(rSet.getString("gender"));
			
				studentDto.setAccountnumber(rSet.getLong("accountnum"));
				studentDto.setBalance(rSet.getDouble("balance"));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentDto;
	}
	public boolean withdraw(String name, double amount) {
	    String selectSql = "SELECT balance FROM bank  WHERE name = ?";
	    String updateSql = "UPDATE bank SET balance = ? WHERE name = ?";
	    boolean success = false;
	    try {
	       
	         ps = DataConnection.getConnection().prepareStatement(selectSql);
	        ps.setString(1, name);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            double currentBalance = rs.getDouble("balance");
	        
	            double newBalance = currentBalance - amount;
	            
	            PreparedStatement updatePs = DataConnection.getConnection().prepareStatement(updateSql);
	            updatePs.setDouble(1, newBalance);
	            updatePs.setString(2, name);
	            updatePs.executeUpdate();
	            success = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}
		
	



}

