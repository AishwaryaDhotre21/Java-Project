import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Store_Screen extends JFrame {

	private JPanel contentPane,panel_7;
	private JTable table;
	private JTable table_1,table_2;
	private JPanel tab1,tab2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store_Screen frame = new Store_Screen();
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
	public Store_Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 255));
		panel.setBounds(0, 0, 395, 699);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 0));
		panel_1.setBounds(0, 0, 395, 55);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblStorePortal = new JLabel("CVS Pharmacy ");
		lblStorePortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStorePortal.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblStorePortal.setBounds(122, 13, 182, 29);
		panel_1.add(lblStorePortal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ex s=new Ex();
				s.setVisible(true);
				dispose();
			}
		});
		panel_2.setBounds(0, 130, 395, 55);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblHome.setBounds(106, 13, 182, 29);
		panel_2.add(lblHome);
		
		table = new JTable();
		table.setBounds(394, 41, 605, 197);
		panel_2.add(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Store_DB sto=new Store_DB();
				sto.setVisible(true);
				dispose();
			}
		});
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 225, 395, 55);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblStoreDatabase = new JLabel("Store Database");
		lblStoreDatabase.setBounds(115, 13, 164, 28);
		lblStoreDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreDatabase.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_3.add(lblStoreDatabase);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tab1.setVisible(true);
				tab2.setVisible(false);
			}
		});
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(0, 314, 395, 55);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblCustomer = new JLabel("Customer Requests");
		lblCustomer.setBounds(69, 13, 261, 29);
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_4.add(lblCustomer);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stock_request s=new stock_request();
				s.setVisible(true);
				
				dispose();
			}
		});
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(null);
		panel_5.setBounds(0, 420, 395, 55);
		panel.add(panel_5);
		
		JLabel lblOrderDrugSuppliy = new JLabel("Order Drug Suppliy");
		lblOrderDrugSuppliy.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderDrugSuppliy.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblOrderDrugSuppliy.setBounds(69, 13, 261, 29);
		panel_5.add(lblOrderDrugSuppliy);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tab1.setVisible(false);
				tab2.setVisible(true);
			}
		});
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setLayout(null);
		panel_6.setBounds(0, 529, 395, 55);
		panel.add(panel_6);
		
		JLabel lblSupplierResponse = new JLabel("Supplier Response");
		lblSupplierResponse.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupplierResponse.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSupplierResponse.setBounds(69, 13, 261, 29);
		panel_6.add(lblSupplierResponse);
		
		tab1 = new JPanel();
		tab1.setBackground(new Color(255, 255, 255));
		tab1.setBounds(392, 0, 606, 699);
		contentPane.add(tab1);
		tab1.setLayout(null);
		
		
		JPanel panel_8 = new JPanel();
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel tblmodel=(DefaultTableModel)table_1.getModel();
				tblmodel.setRowCount(0);
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				String find="select med_name,req_date from customer_request";
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
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
		panel_8.setBackground(new Color(255, 255, 0));
		panel_8.setLayout(null);
		panel_8.setBounds(104, 38, 395, 55);
		tab1.add(panel_8);
		
		JLabel lblShowCustomerRequests = new JLabel("Show Customer Requests");
		lblShowCustomerRequests.setBackground(new Color(255, 0, 255));
		lblShowCustomerRequests.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowCustomerRequests.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblShowCustomerRequests.setBounds(69, 13, 261, 29);
		panel_8.add(lblShowCustomerRequests);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 172, 606, 239);
		tab1.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Request Date"
			}
		));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 51));
		panel_9.setBounds(0, 443, 606, 47);
		tab1.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter medicine name whose request has been fulfilled");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 606, 47);
		panel_9.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				String query="delete from customer_request where med_name=?";
				String find="select * from customer_request where med_name=?";
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				Store_Screen obj=new Store_Screen();
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					pstmt=(PreparedStatement) con.prepareStatement(find);
					pstmt.setString(1, textField.getText().toString());
					rs=pstmt.executeQuery();
					if(rs.next())
					{
						pstmt=(PreparedStatement) con.prepareStatement(query);
						pstmt.setString(1, rs.getString(1));
						pstmt.execute();
						JOptionPane.showMessageDialog(obj, "Record deleted ");
						textField.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(obj, "Record not found ");
						textField.setText("");
					}
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(350, 524, 207, 55);
		tab1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField.setToolTipText("Enter medicine name");
		textField.setBounds(54, 530, 284, 47);
		tab1.add(textField);
		textField.setColumns(10);
		
		
		tab2 = new JPanel();
		tab2.setBackground(Color.WHITE);
		tab2.setBounds(392, 0, 606, 699);
		contentPane.add(tab2);
		tab2.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 172, 606, 239);
		tab2.add(scrollPane1);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane1.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "med_name", "quantity" ," req_date ", " fulfil_date "," date_diff ","req_status"
			}
		));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 0));
		panel_10.setLayout(null);
		panel_10.setBounds(104, 38, 395, 55);
		tab2.add(panel_10);
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel tblmodel1=(DefaultTableModel)table_2.getModel();
				tblmodel1.setRowCount(0);
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				String find="select med_name , quantity , req_date , fulfil_date , date_diff , req_status from supplier_response";
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					stmt=con.createStatement();
					rs=stmt.executeQuery(find);
					while(rs.next())
					{
						String med=rs.getString(1);
						String qun=String.valueOf(rs.getInt(2));
						String rdate=rs.getString(3);
						String fdate=rs.getString(4);
						String dtdiff=String.valueOf(rs.getInt(5));
						String rstatus=rs.getString(6);
						String array[]= {med,qun,rdate,fdate,dtdiff,rstatus};
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
		
		JLabel lblShowSupplierResponse = new JLabel("Show Supplier Response");
		lblShowSupplierResponse.setBackground(new Color(255, 0, 255));
		lblShowSupplierResponse.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowSupplierResponse.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblShowSupplierResponse.setBounds(69, 13, 261, 29);
		panel_10.add(lblShowSupplierResponse);
		
	}
}
