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
import java.awt.event.ActionEvent;

public class AdminSigIn extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;
	private JTextField passwordtextField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSigIn frame = new AdminSigIn();
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
	public AdminSigIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 53, 85, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(22, 116, 104, 22);
		contentPane.add(lblNewLabel_1);
		
		nametextField = new JTextField();
		nametextField.setBounds(159, 53, 174, 34);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		passwordtextField_1 = new JTextField();
		passwordtextField_1.setColumns(10);
		passwordtextField_1.setBounds(159, 116, 174, 34);
		contentPane.add(passwordtextField_1);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				String name = nametextField.getText();
			    String password = passwordtextField_1.getText();
				Bank bank=new BankImpl();
				
				
				bank.getadminLogIn( name,password) ;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(170, 181, 116, 34);
		contentPane.add(btnNewButton);
	}

}
