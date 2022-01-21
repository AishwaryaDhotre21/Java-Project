import java.awt.BorderLayout;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Store_DB extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField med;
	private JTextField qun;
	private JTextField com;
	private JTextField exp;
	private JTextField sell;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store_DB frame = new Store_DB();
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
	public Store_DB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 683);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 906, 636);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("DB Operations", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblMedicineName = new JLabel("Medicine Name");
		lblMedicineName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMedicineName.setBounds(25, 45, 147, 41);
		panel.add(lblMedicineName);
		
		med = new JTextField();
		med.setFont(new Font("Times New Roman", Font.BOLD, 17));
		med.setBounds(202, 51, 191, 30);
		panel.add(med);
		med.setColumns(10);
		
		JLabel lblMedicineQuantity = new JLabel("Medicine Quantity");
		lblMedicineQuantity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMedicineQuantity.setBounds(450, 45, 165, 41);
		panel.add(lblMedicineQuantity);
		
		qun = new JTextField();
		qun.setFont(new Font("Times New Roman", Font.BOLD, 17));
		qun.setColumns(10);
		qun.setBounds(631, 51, 191, 30);
		panel.add(qun);
		
		JLabel lblMedicineCompany = new JLabel("Medicine Company");
		lblMedicineCompany.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMedicineCompany.setBounds(25, 141, 165, 41);
		panel.add(lblMedicineCompany);
		
		com = new JTextField();
		com.setFont(new Font("Times New Roman", Font.BOLD, 17));
		com.setColumns(10);
		com.setBounds(202, 152, 191, 30);
		panel.add(com);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblExpiryDate.setBounds(450, 141, 147, 41);
		panel.add(lblExpiryDate);
		
		exp = new JTextField();
		exp.setFont(new Font("Times New Roman", Font.BOLD, 17));
		exp.setColumns(10);
		exp.setBounds(631, 147, 191, 30);
		panel.add(exp);
		
		JLabel lblSellPrice = new JLabel("Sell price");
		lblSellPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSellPrice.setBounds(25, 233, 165, 41);
		panel.add(lblSellPrice);
		
		sell = new JTextField();
		sell.setFont(new Font("Times New Roman", Font.BOLD, 17));
		sell.setColumns(10);
		sell.setBounds(202, 244, 191, 30);
		panel.add(sell);
		
		JLabel lblCostPrice = new JLabel("Cost Price");
		lblCostPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCostPrice.setBounds(450, 233, 147, 41);
		panel.add(lblCostPrice);
		
		JTextField cost = new JTextField();
		cost.setFont(new Font("Times New Roman", Font.BOLD, 17));
		cost.setColumns(10);
		cost.setBounds(631, 239, 191, 30);
		panel.add(cost);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con=null;
				ResultSet rs=null;
				Statement stmt=null;
				CallableStatement cstmt=null;
				String med_name=med.getText().toString();
				int quantity=Integer.parseInt(qun.getText());
				String company=com.getText().toString();
				String date=exp.getText().toString();
				int sp=Integer.parseInt(sell.getText());
				int cp=Integer.parseInt(cost.getText());
				String sql="select * from error";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				String driverName="com.mysql.jdbc.Driver";
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					cstmt=con.prepareCall("{call pk_exp_stock_table(?,?,?,?,?,?)}");
					cstmt.setString(1, med_name);
					cstmt.setString(2, company);
					cstmt.setInt(3, quantity);
					cstmt.setString(4, date);
					cstmt.setInt(5, sp);
					cstmt.setInt(6, cp);
					cstmt.execute();
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					String msg1="YES";
					String msg2="NO";
					while(rs.next())
					{
						if(msg1.equals(rs.getString("msg")))
						{
							JOptionPane.showMessageDialog(null, "Primary Key Constraint-Medicine Name already exists");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Data Inserted");
						}
					}
					med.setText("");com.setText("");exp.setText("");qun.setText("");sell.setText("");cost.setText("");
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Foreign Key Contraint-place the order at supplier for this medicine as it's not availible at supplier");
				}
				
			}
		});
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 27));
		btnInsert.setBounds(333, 341, 176, 41);
		panel.add(btnInsert);
		
		JLabel label_2 = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\arrow_back.jpg"));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Store_Screen sto=new Store_Screen();
				sto.setVisible(true);
				dispose();
			}
		});
		label_2.setToolTipText("Click to go back screen");
		label_2.setBounds(826, 564, 63, 42);
		panel.add(label_2);
		
		JLabel label = new JLabel("Medicine Name");
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setBounds(150, 493, 147, 41);
		panel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField.setColumns(10);
		textField.setBounds(333, 499, 191, 30);
		panel.add(textField);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				ResultSet rs=null;
				String find="select * from stock where Med_Name=?";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				String driverName="com.mysql.jdbc.Driver";
				String sql="delete from stock where Med_Name=?";
				PreparedStatement stmt=null;
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					stmt=con.prepareStatement(find);
					stmt.setString(1, textField.getText().toString());
					rs=stmt.executeQuery();
					if(rs.next())
					{
						stmt=con.prepareStatement(sql);
						stmt.setString(1, textField.getText().toString());
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record deleted ");
						textField.setText("");
					}else
					{
						JOptionPane.showMessageDialog(null, "Record not found ");
						textField.setText("");
					}
					con.close();
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 27));
		btnDelete.setBounds(567, 491, 176, 41);
		panel.add(btnDelete);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Show database", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnLoadDatabase = new JButton("Load Database");
		btnLoadDatabase.setBackground(new Color(153, 204, 255));
		btnLoadDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel tblmodel=(DefaultTableModel)table.getModel();
				tblmodel.setRowCount(0);
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				String find="select * from stock";
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
						String com=rs.getString(2);
						String qun=String.valueOf(rs.getInt(3));
						String exp=rs.getString(4);
						String sell=String.valueOf(rs.getInt(5));
						String cost=String.valueOf(rs.getInt(6));
						String ts=String.valueOf(rs.getInt(7));
						String tc=String.valueOf(rs.getInt(8));
						
						String array[]= {med,com,qun,exp,sell,cost,ts,tc};
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
		btnLoadDatabase.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnLoadDatabase.setBounds(317, 29, 268, 56);
		panel_3.add(btnLoadDatabase);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 122, 889, 317);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Company", "Quantity", "Expiry Date", "Sell Price", "Cost Price", "Total Sell Price", "Total Cost Price"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\arrow_back.jpg"));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Store_Screen sto=new Store_Screen();
				sto.setVisible(true);
				dispose();
			}
		});
		label_1.setToolTipText("Click to go back screen");
		label_1.setBounds(838, 564, 63, 42);
		panel_3.add(label_1);
	}
}
