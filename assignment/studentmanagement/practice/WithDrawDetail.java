package com.assignment.studentmanagement.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WithDrawDetail extends JFrame {
	Bank bank=new BankImpl();
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 WithDrawDetail frame = new  WithDrawDetail();
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
	public  WithDrawDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(408, 26, 103, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String name=textField.getText();
				if(name==null||name.isEmpty()) {
					data();
					
				}
				else {
					search(name);
				}
			}
		});
		textField.setBounds(550, 19, 215, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
					int row=table.getSelectedRow();
					Object id =tableModel.getValueAt(row, 0);//id is variable name
					int status=JOptionPane.showConfirmDialog( WithDrawDetail.this, "do you really wanted to delete","Delete",JOptionPane.YES_NO_OPTION);
					if(status==0) {
						bank.delete(Integer.parseInt(id.toString()));//object,string ,interger
						data();//refresh
						
						
					}
				}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(428, 649, 146, 35);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(10, 643, 128, 46);
		contentPane.add(btnEdit);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BankForm().setVisible(true);
			}
		
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNew.setBounds(636, 653, 128, 36);
		contentPane.add(btnNew);
		
		table = new JTable();
		table.setBounds(10, 84, 778, 512);
		contentPane.add(table);
		String[]columeName= {"id","name","address","contact","gender","accountnum","balance"};
		DefaultTableModel table1 =new DefaultTableModel(columeName,0);
		 table.setModel(table1);
		data();
		JScrollPane scrollPane =new JScrollPane(table);
		scrollPane.setBounds(10, 84, 778, 512);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("Deposited");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		        int row = table.getSelectedRow();
		        Object nameObject = tableModel.getValueAt(row, 1);//count from  zero in row
		       Object accObject = tableModel.getValueAt(row, 5);
		        DepositLogin depositLogin = new DepositLogin();//function of form class
		        depositLogin.nametextField.setText(nameObject.toString());//convert object to string
		        depositLogin.accountNumtextField_1.setText(accObject.toString());
		        depositLogin.setVisible(true);
		        
		        dispose();
		    }
		});

		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(202, 649, 146, 35);
		contentPane.add(btnNewButton_1);
		
	}
	public void data() {
		Bank bank=new BankImpl();
		ArrayList<BankDTO> userList = bank.getDetail();
		DefaultTableModel table1=(DefaultTableModel)table.getModel();
		table1.setRowCount(0);
		
		for(BankDTO bankDto:userList) {
		
			table1.addRow(new Object[] {
		bankDto.getId(),
		bankDto.getName(),
		bankDto.getAddress(),
		bankDto.getContact(),
		bankDto.getGender(),
		bankDto.getAccountnumber(),
		bankDto.getBalance()
		
			
		});
			
		}
		}
		public void search(String name) {
			Bank bank=new BankImpl();
			ArrayList<BankDTO>objArrayList=bank.getSearchDetail(name);
			DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
			tableModel.setRowCount(0);
			for(BankDTO bankDto:objArrayList) {
				tableModel.addRow(new Object[] {
						bankDto.getId(),
						bankDto.getName(),
						bankDto.getAddress(),
						bankDto.getContact(),
						bankDto.getGender(),
						bankDto.getAccountnumber(),
						bankDto.getBalance()
				});
						
				}
			}
		}
		
		
	

