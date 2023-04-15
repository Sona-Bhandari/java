package com.assignment.studentmanagement.practice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.temporal.TemporalAmount;
import java.awt.event.ActionEvent;

public class DepositLogin extends JFrame {

private JPanel contentPane;
JTextField nametextField;
JTextField accountNumtextField_1;
private String name;
    private String accountNum;
    PreparedStatement ps=null;
    private JTextField textField;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
DepositLogin frame = new DepositLogin();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public DepositLogin() {
	
	
	
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 417);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Name");
lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
lblNewLabel.setBounds(27, 55, 90, 30);
contentPane.add(lblNewLabel);

JLabel lblAccountnum = new JLabel("AccountNum");
lblAccountnum.setFont(new Font("Tahoma", Font.PLAIN, 18));
lblAccountnum.setBounds(10, 130, 106, 30);
contentPane.add(lblAccountnum);

nametextField = new JTextField();
nametextField.setEditable(false);
nametextField.setBounds(130, 55, 206, 29);
contentPane.add(nametextField);
nametextField.setColumns(10);

accountNumtextField_1 = new JTextField();
accountNumtextField_1.setEditable(false);
accountNumtextField_1.setColumns(10);
accountNumtextField_1.setBounds(143, 130, 193, 30);
contentPane.add(accountNumtextField_1);
JLabel lblNewLabel_1 = new JLabel("Amount");
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_1.setBounds(27, 206, 106, 30);
contentPane.add(lblNewLabel_1);
textField = new JTextField();
textField.setBounds(130, 200, 206, 36);
contentPane.add(textField);
textField.setColumns(10);
JButton deposit = new JButton("Deposit");
deposit.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		
		Bank bank=new BankImpl();
		
		name = nametextField.getText();
	    accountNum = accountNumtextField_1.getText();
	    
		double amount = Double.parseDouble(textField.getText());;
		bank.increaseBalance(name,amount);
		
		dispose();

		new BankDetails().setVisible(true);
		
		
		
	}
});





deposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
deposit.setBounds(118, 275, 99, 30);
contentPane.add(deposit);
JButton withDrawNewButton = new JButton("WithDraw");
withDrawNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
Bank bank=new BankImpl();
		
		name = nametextField.getText();
	    accountNum = accountNumtextField_1.getText();
	    
		double amount = Double.parseDouble(textField.getText());;
		bank.withdraw(name, amount);
		
		dispose();

		new WithDrawDetail().setVisible(true);
		
		
	}
});
withDrawNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
withDrawNewButton.setBounds(251, 275, 119, 30);
contentPane.add(withDrawNewButton);
}
}