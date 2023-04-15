package com.assignment.studentmanagement.practice;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Color;

public class BakingSystem extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BakingSystem frame = new BakingSystem();
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
	public BakingSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JProgressBar	progressBar = new JProgressBar(0,100);
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(32, 106, 458, 54);
		contentPane.add(progressBar);
		
		Thread thread=new Thread(
				()
						->{
							for(int i=0;i<=100;i++) {
								progressBar.setValue(i);
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
							if(i==100) {
								dispose();
								new FramePanel().setVisible(true);
							}
								
							}
						}
								);
			
		thread.start();
		JLabel lblNewLabel = new JLabel("Loading...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(202, 170, 112, 27);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setIcon(new ImageIcon("D:\\image\\background-results.jpg"));
		lblNewLabel_1.setBounds(0, 0, 548, 387);
		contentPane.add(lblNewLabel_1);
	}


	}

