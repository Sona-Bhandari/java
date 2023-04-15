package com.assignment.studentmanagement.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePanel frame = new FramePanel();
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
	public FramePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton adminButton = new JButton("Admin");
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminSigIn().setVisible(true);;
			}
		});
		adminButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adminButton.setBounds(143, 152, 155, 35);
		contentPane.add(adminButton);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignInForm().setVisible(true);
				
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCustomer.setBounds(143, 95, 155, 35);
		contentPane.add(btnCustomer);
		
		JLabel lblNewLabel = new JLabel("Welcome to ABC bank");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(49, 21, 307, 43);
		contentPane.add(lblNewLabel);
	}
}
