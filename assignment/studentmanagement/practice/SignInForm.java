package com.assignment.studentmanagement.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignInForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInForm frame = new SignInForm();
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
	public SignInForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 46, 98, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AccountNumber");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 102, 168, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(188, 51, 168, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 107, 168, 28);
		contentPane.add(textField_1);
		
		JButton logInButton = new JButton("LogIn");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				long accountNum=Long.parseLong(textField_1.getText());
				Bank bank=new BankImpl();
				boolean result=bank.login(name, accountNum) ;
				if(result) {
					BankDTO response =bank.getUserDetail(accountNum);//function call
					UserDetail obj=new UserDetail();
					obj.idNewLabel.setText(String.valueOf(response.getId()));
					obj.nameNewLabel.setText(response.getName());
					obj.addressNewLabel.setText(response.getAddress());
					obj.contactNewLabel.setText(String.valueOf(response.getContact()));
					obj.genderNewLabel.setText(response.getGender());
					obj.AccountNumberNewLabel.setText(String.valueOf(response.getAccountnumber()));
					obj.BalanceNewLabel.setText(String.valueOf(response.getBalance()));
					dispose();
					obj.setVisible(true);
					
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Name and AccountNum don't match!","success" ,JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		logInButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logInButton.setBounds(169, 179, 98, 28);
		contentPane.add(logInButton);
	}

}
