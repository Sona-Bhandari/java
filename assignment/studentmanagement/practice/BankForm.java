package com.assignment.studentmanagement.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.nextstep.studentmanagementsystem.practice.Student;
import com.nextstep.studentmanagementsystem.practice.StudentDTO;
import com.nextstep.studentmanagementsystem.practice.StudentDetails;
import com.nextstep.studentmanagementsystem.practice.StudentImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankForm extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;
	private JTextField addresstextField;
	private JTextField contacttextField;
	private JTextField accountnumbertextField;
	private JTextField balancetextField;
	Bank bank=new BankImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankForm frame = new BankForm();
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
	public BankForm() {
		long accountNumber=bank.getGreatest();
		String currentAccountNumberString=String.valueOf(accountNumber+1);
		
		setTitle("Form");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 281, 100, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(10, 48, 115, 39);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(10, 127, 86, 25);
		contentPane.add(lblAddress);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContact.setBounds(10, 196, 115, 30);
		contentPane.add(lblContact);
		
		nametextField = new JTextField();
		nametextField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nametextField.setColumns(10);
		nametextField.setBounds(213, 37, 168, 39);
		contentPane.add(nametextField);
		
		addresstextField = new JTextField();
		addresstextField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		addresstextField.setColumns(10);
		addresstextField.setBounds(213, 113, 168, 39);
		contentPane.add(addresstextField);
		
		contacttextField = new JTextField();
		contacttextField.setColumns(10);
		contacttextField.setBounds(213, 187, 168, 39);
		contentPane.add(contacttextField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male", "Other"}));
		comboBox.setBounds(224, 272, 157, 39);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("AccountNumber");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 351, 148, 39);
		contentPane.add(lblNewLabel_1);
		
		accountnumbertextField = new JTextField();
		accountnumbertextField.setEditable(false);
		accountnumbertextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		accountnumbertextField.setBounds(224, 351, 157, 39);
		contentPane.add(accountnumbertextField);
		accountnumbertextField.setColumns(10);
		accountnumbertextField.setText(currentAccountNumberString);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelButton.setBounds(32, 592, 142, 45);
		contentPane.add(cancelButton);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=nametextField.getText();
				String address=addresstextField.getText();
				long contact=Long.parseLong(contacttextField.getText());
				String gender=(String) comboBox.getSelectedItem();
				long accountNumber=Long.parseLong(accountnumbertextField.getText());
				double balance=Double.parseDouble(balancetextField.getText());
				BankDTO obj=new BankDTO();//class of another which is non-static
				obj.setName(name);
				obj.setAddress(address);//after  setting  we can get value
				obj.setGender(gender);
				obj.setContact(contact);
				obj.setAccountnumber(accountNumber);
obj.setBalance(balance);
				Bank bank=new BankImpl();
				bank.saveDetail(obj);
				dispose();
				new BankDetails().setVisible(true);
			}
		});
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submitButton.setBounds(224, 592, 142, 45);
		contentPane.add(submitButton);
		
		JLabel lblNewLabel_2 = new JLabel("Balace");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 429, 115, 30);
		contentPane.add(lblNewLabel_2);
		
		balancetextField = new JTextField();
		balancetextField.setBounds(213, 429, 168, 40);
		contentPane.add(balancetextField);
		balancetextField.setColumns(10);
		
		JButton btnNewButton = new JButton("TotalAmount");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bank bank=new BankImpl();
				bank.getTotalAmount();
				dispose();
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(423, 592, 171, 45);
		contentPane.add(btnNewButton);
	}

	
}
