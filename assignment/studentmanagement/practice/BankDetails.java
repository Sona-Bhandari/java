
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
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BankDetails extends JFrame {

	private JPanel contentPane;
	private JTextField searchBox;
	private JTable table;
	Bank bank=new BankImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankDetails frame = new BankDetails();
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
	public BankDetails() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(510, 37, 103, 35);
		contentPane.add(lblNewLabel);
		
		searchBox = new JTextField();
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			
			
			public void keyPressed(KeyEvent e) {
				String name=searchBox.getText();
				if(name==null ||name.isEmpty()) {
					loadDataInTable();
				}
				else {
					searchDataInTable(name);
				}
			}
		});
		
		searchBox.setBounds(602, 26, 215, 42);
		contentPane.add(searchBox);
		searchBox.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
				int row=table.getSelectedRow();
				Object id =tableModel.getValueAt(row, 0);//id is variable name
				int status=JOptionPane.showConfirmDialog(BankDetails.this, "do you really wanted to delete","Delete",JOptionPane.YES_NO_OPTION);
				if(status==0) {
					bank.delete(Integer.parseInt(id.toString()));//object,string ,interger
					loadDataInTable();//refresh
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(473, 523, 103, 35);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(270, 523, 96, 35);
		contentPane.add(btnEdit);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BankForm().setVisible(true);
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNew.setBounds(693, 523, 102, 35);
		contentPane.add(btnNew);
		
		table = new JTable();
		table.setBounds(10, 76, 837, 426);
		contentPane.add(table);
		String [] columnName={"id","name","address","contact","gender","accountnum","balance"};
		DefaultTableModel tableModel=new DefaultTableModel(columnName,0);
		table.setModel(tableModel);
		loadDataInTable();
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(10, 76, 837, 426);//for x-axis
		contentPane.add(scrollPane);//for increase scroll
		
		JButton detailBox = new JButton("Deposit/WithDraw");
		detailBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
				int row =table.getSelectedRow();
				Object accObject=tableModel.getValueAt(row, 5);
				Object nameObject=tableModel.getValueAt(row, 1);
				
				DepositLogin depositLogin=new DepositLogin();
				depositLogin.accountNumtextField_1.setText(accObject.toString());
				depositLogin.nametextField.setText(nameObject.toString());
				
				dispose();
				depositLogin.setVisible(true);
				
			}

		});
		detailBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		detailBox.setBounds(36, 523, 195, 35);
		contentPane.add(detailBox);
		
		
			
		
	}
	public void loadDataInTable(){
		Bank bank=new BankImpl();//new instance of studentImpl
		ArrayList<BankDTO> studentList=bank.getDetail();//call method student obj
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for (BankDTO studentDTO : studentList) {
			//System.out.println( studentDTO );
			tableModel.addRow(new Object[] {
					studentDTO.getId(),
					studentDTO.getName(),
					studentDTO.getAddress(),
					
					studentDTO.getContact(),
					studentDTO.getGender(),
					studentDTO.getAccountnumber(),
					studentDTO.getBalance()
					
			});
			
		}
		
	}
	
	//for search with name
	public void searchDataInTable(String name){
		 bank=new BankImpl();//new instance of studentImpl
		ArrayList<BankDTO> studentList=bank.getSearchDetail(name);//call method student obj
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for (BankDTO studentDTO : studentList) {
			//System.out.println( studentDTO );
			tableModel.addRow(new Object[] {
					studentDTO.getId(),
					studentDTO.getName(),
					studentDTO.getAddress(),
					
					studentDTO.getContact(),
					studentDTO.getGender(),
					studentDTO.getAccountnumber(),
					studentDTO.getBalance()
					
			});
			
		}
		
	}
}
