import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class stock_request extends JFrame {

	private JPanel contentPane;
	private  JTable table;
	private JTextField med_name;
	private JTextField quantity;
	private JTable table_1;
	private  DefaultTableModel tblmodel1;
	private  Connection con=null;
	private  Statement stmt=null;
	private  ResultSet rs=null;
	private  String driverName="com.mysql.jdbc.Driver";
	private  String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock_request frame = new stock_request();
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
	public stock_request() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 753);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.YELLOW);
		panel.setBounds(286, 0, 395, 55);
		contentPane.add(panel);
		
		JLabel lblCustomerRequests = new JLabel("Customer  Requests");
		lblCustomerRequests.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerRequests.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblCustomerRequests.setBackground(Color.MAGENTA);
		lblCustomerRequests.setBounds(69, 13, 261, 29);
		panel.add(lblCustomerRequests);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 87, 984, 119);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Request Date"
			}
		));
		
		
		//display customer request
		
		DefaultTableModel tblmodel=(DefaultTableModel)table.getModel();
		String find="select med_name,req_date from customer_request";
		try
		{
			Class.forName(driverName);
			con=DriverManager.getConnection(url,"root","root");
			stmt=con.createStatement();
			rs=stmt.executeQuery(find);
			while(rs.next())
			{
				String med=rs.getString(1);
				String date=rs.getString(2);
				String array[]= {med,date};
				tblmodel.addRow(array);
			}
		}
		catch(Exception e2)
		{
			JOptionPane.showMessageDialog(null, e2);
		
		}

	
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(286, 229, 395, 55);
		contentPane.add(panel_1);
		
		JLabel lblPlaceYourOrder = new JLabel("place your stock  order");
		lblPlaceYourOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceYourOrder.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblPlaceYourOrder.setBackground(Color.MAGENTA);
		lblPlaceYourOrder.setBounds(69, 13, 261, 29);
		panel_1.add(lblPlaceYourOrder);
		
		med_name = new JTextField();
		med_name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		med_name.setBounds(163, 353, 192, 32);
		contentPane.add(med_name);
		med_name.setColumns(10);
		
		JLabel lblMedicineName = new JLabel("Medicine Name");
		lblMedicineName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblMedicineName.setBounds(0, 350, 163, 32);
		contentPane.add(lblMedicineName);
		
		JLabel lblMedicineQuantity = new JLabel("Medicine Quantity");
		lblMedicineQuantity.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblMedicineQuantity.setBounds(385, 350, 175, 32);
		contentPane.add(lblMedicineQuantity);
		
		quantity = new JTextField();
		quantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		quantity.setColumns(10);
		quantity.setBounds(572, 353, 192, 32);
		contentPane.add(quantity);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setToolTipText("click to place order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				PreparedStatement stmt=null;
				ResultSet rs=null;
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				String s="Not Availible";
				String sql="insert into stock_request values(?,?,now(),'Not Availible')";
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					stmt=con.prepareStatement(sql);
					stmt.setString(1, med_name.getText().toString());
					stmt.setInt(2, Integer.parseInt(quantity.getText()));
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record placed");
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
				
			
		});
		btnPlaceOrder.setBackground(Color.GREEN);
		btnPlaceOrder.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnPlaceOrder.setBounds(809, 350, 163, 32);
		contentPane.add(btnPlaceOrder);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("click to see request table");
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				tblmodel1=(DefaultTableModel)table_1.getModel();
				tblmodel1.setRowCount(0);
				String find1="select med_name,quantity,req_date,req_status from stock_request";
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					stmt=con.createStatement();
					rs=stmt.executeQuery(find1);
					while(rs.next())
					{
						String med=rs.getString(1);
						String qun=String.valueOf(rs.getInt(2));
						String date=rs.getString(3);
						String status=rs.getString(4);
						String array[]= {med,qun,date,status};
						tblmodel1.addRow(array);
					}
					rs.close();
					stmt.close();
					con.close();
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		panel_2.setLayout(null);
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(0, 469, 984, 32);
		contentPane.add(panel_2);
		
		JLabel lblDisplayOrderRequests = new JLabel("Display Order Requests");
		lblDisplayOrderRequests.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayOrderRequests.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblDisplayOrderRequests.setBackground(Color.MAGENTA);
		lblDisplayOrderRequests.setBounds(362, 0, 261, 29);
		panel_2.add(lblDisplayOrderRequests);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 546, 984, 131);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Medicine Quantity", "Request Date", "Request Status"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\arrow_back.jpg"));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Store_Screen sto=new Store_Screen();
				sto.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setToolTipText("Click to go back screen");
		lblNewLabel.setBounds(0, 0, 63, 42);
		contentPane.add(lblNewLabel);
		
				
	}
}
