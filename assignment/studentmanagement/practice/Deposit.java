package com.assignment.studentmanagement.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private JPanel contentPane;
	private JTextField DatetextField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to ABC Bank");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(257, 41, 524, 61);
		contentPane.add(lblNewLabel);
		
		JLabel accountNumber = new JLabel("AccountNumber");
		accountNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		accountNumber.setBounds(40, 124, 191, 42);
		contentPane.add(accountNumber);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setBounds(40, 207, 125, 35);
		contentPane.add(name);
		
		JLabel deposit = new JLabel("Deposit");
		deposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deposit.setBounds(10, 515, 125, 35);
		contentPane.add(deposit);
		
		JLabel date = new JLabel("Date");
		date.setFont(new Font("Tahoma", Font.PLAIN, 20));
		date.setBounds(25, 302, 125, 35);
		contentPane.add(date);
		
		
		JLabel balance = new JLabel("Balance");
		balance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		balance.setBounds(10, 392, 125, 35);
		contentPane.add(balance);
		
		DatetextField = new JTextField();
		DatetextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			     LocalDateTime now = LocalDateTime.now();  
			     String date = dtf.format(now);
			     
			     DatetextField. setText(date);
			}
		});
		DatetextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DatetextField.setBounds(337, 299, 178, 42);
		contentPane.add(DatetextField);
		DatetextField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
				   
				
			}
		});
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(337, 112, 178, 42);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(337, 200, 178, 42);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(337, 402, 178, 42);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(337, 512, 178, 42);
		contentPane.add(textField_4);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submitButton.setBounds(370, 608, 133, 42);
		contentPane.add(submitButton);
	}
	 
	    
}
