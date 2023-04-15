package com.assignment.studentmanagement.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;

public class UserDetail extends JFrame {
public JLabel idNewLabel ;
public JLabel nameNewLabel;
public JLabel addressNewLabel;
public JLabel contactNewLabel;
public JLabel genderNewLabel;
public JLabel AccountNumberNewLabel;
public JLabel BalanceNewLabel;
//public JLabel  idBox ,idBox_1,lblName, lblAddress,lblContact,lblGender,lblAccountnumber,lblBalance;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetail frame = new UserDetail();
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
	public UserDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idBox = new JLabel("id");
		idBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		idBox.setBounds(20, 33, 124, 35);
		contentPane.add(idBox);
		
		JLabel idBox_1 = new JLabel("id");
		idBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		idBox_1.setBounds(-18, 33, 124, 35);
		contentPane.add(idBox_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(20, 94, 124, 35);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(10, 162, 124, 35);
		contentPane.add(lblAddress);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContact.setBounds(10, 235, 124, 35);
		contentPane.add(lblContact);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(20, 309, 124, 35);
		contentPane.add(lblGender);
		
		JLabel lblAccountnumber = new JLabel("AccountNumber");
		lblAccountnumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccountnumber.setBounds(10, 380, 155, 35);
		contentPane.add(lblAccountnumber);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBalance.setBounds(20, 458, 124, 35);
		contentPane.add(lblBalance);
		
		 idNewLabel = new JLabel("");
		idNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		idNewLabel.setBounds(197, 36, 149, 28);
		contentPane.add(idNewLabel);
		
		nameNewLabel = new JLabel("");
		nameNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameNewLabel.setBounds(197, 101, 149, 28);
		contentPane.add(nameNewLabel);
		
		 addressNewLabel = new JLabel("");
		addressNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addressNewLabel.setBounds(186, 165, 149, 28);
		contentPane.add(addressNewLabel);
		
		contactNewLabel = new JLabel("");
		contactNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contactNewLabel.setBounds(186, 238, 149, 28);
		contentPane.add(contactNewLabel);
		
		genderNewLabel = new JLabel("");
		genderNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		genderNewLabel.setBounds(197, 312, 149, 28);
		contentPane.add(genderNewLabel);
		
		AccountNumberNewLabel = new JLabel("");
		AccountNumberNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AccountNumberNewLabel.setBounds(197, 383, 149, 28);
		contentPane.add(AccountNumberNewLabel);
		
		BalanceNewLabel = new JLabel("");
		BalanceNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BalanceNewLabel.setBounds(197, 461, 149, 28);
		contentPane.add(BalanceNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FramePanel().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(236, 540, 99, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FramePanel().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(411, 547, 92, 47);
		contentPane.add(btnNewButton_1);
	}
}
