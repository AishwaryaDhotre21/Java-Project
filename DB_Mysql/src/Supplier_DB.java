import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Supplier_DB extends JFrame {

	private JPanel contentPane;
	private JTextField company;
	private JTextField med_name;
	private JTextField phone;
	private JTextField quantity;
	private JTable table;
	private JTextField delete_text;
	private JTable table_1;
	private JCheckBox c1,c2,c3,c4,c5;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier_DB frame = new Supplier_DB();
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
	public Supplier_DB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1395, 932);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 51));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 51, 255), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 102, 255));
		tabbedPane.setForeground(new Color(255, 0, 0));
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 153, 204), new Color(204, 255, 0), new Color(153, 204, 255), new Color(153, 0, 204)));
		tabbedPane.setBounds(263, 30, 837, 627);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(102, 153, 0));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 0, 255), null, null, null));
		panel.setBackground(new Color(255, 153, 204));
		tabbedPane.addTab("Insert Drug ", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblMedicineCompany = new JLabel("Medicine Company");
		lblMedicineCompany.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblMedicineCompany.setBounds(12, 13, 146, 22);
		panel.add(lblMedicineCompany);
		
		company = new JTextField();
		company.setBounds(170, 14, 178, 22);
		panel.add(company);
		company.setColumns(10);
		
		JLabel lblMedicineName = new JLabel("Medicine Name");
		lblMedicineName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblMedicineName.setBounds(391, 13, 146, 22);
		panel.add(lblMedicineName);
		
		med_name = new JTextField();
		med_name.setColumns(10);
		med_name.setBounds(544, 14, 178, 22);
		panel.add(med_name);
		
		JLabel lblCompanyAddress = new JLabel("Company Address");
		lblCompanyAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblCompanyAddress.setBounds(391, 78, 146, 22);
		panel.add(lblCompanyAddress);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(170, 79, 178, 22);
		panel.add(phone);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblPhoneNumber.setBounds(12, 78, 146, 22);
		panel.add(lblPhoneNumber);
		
		JTextArea address = new JTextArea();
		address.setBounds(544, 65, 178, 92);
		panel.add(address);
		
		JLabel lblMedicineQuantity = new JLabel("Medicine Quantity");
		lblMedicineQuantity.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblMedicineQuantity.setBounds(12, 135, 146, 22);
		panel.add(lblMedicineQuantity);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(170, 135, 178, 22);
		panel.add(quantity);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//code to load data in jtable
				if(company.getText().equals("") || phone.getText().equals("") || med_name.getText().equals("") || address.getText().equals("") || quantity.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "All fields are mandatory please fill it");
				}
				else
				{
					//insert data into jtable
					String data[]= {company.getText(),med_name.getText(),address.getText(),quantity.getText(),phone.getText()};
					DefaultTableModel tblmodel=(DefaultTableModel)table.getModel();
					tblmodel.addRow(data);
					JOptionPane.showMessageDialog(null, "Data Added successfully");
					company.setText(" ");
					med_name.setText("");
					phone.setText("");
					address.setText("");
					quantity.setText("");
					
				}
			}
		});
		btnInsert.setBounds(289, 197, 188, 35);
		panel.add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 295, 663, 213);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Company Name", "Medicine Name", "Address", "Medicine Quantity", "Phone Number"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tblmodel=(DefaultTableModel)table.getModel();
				if(tblmodel.getRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Table is empty");
				}
				else
				{
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					String driverName="com.mysql.jdbc.Driver";
					String query="insert into Supplier(Company_Name,Med_Name,Address,Quantity,Phone_no) values(?,?,?,?,?)";
					String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
					try
					{ 
						String med,com,addr;
						int ph;
						int qun;
						Class.forName(driverName);
						con=DriverManager.getConnection(url,"root","root");
						for (int i=0;i<tblmodel.getRowCount();i++)
						{
							com=tblmodel.getValueAt(i, 0).toString();
							med=tblmodel.getValueAt(i, 1).toString();
							addr=tblmodel.getValueAt(i, 2).toString();
							qun=Integer.parseInt((String) tblmodel.getValueAt(i, 3));
							ph=Integer.parseInt((String) tblmodel.getValueAt(i, 4));
							
							pstmt=(PreparedStatement) con.prepareStatement(query);
							pstmt.setString(1,com);
							pstmt.setString(2,med);
							pstmt.setString(3,addr);
							pstmt.setInt(4, qun);
							pstmt.setInt(5,ph);
							pstmt.execute();
						}
						con.close();
						
						JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
						tblmodel.setRowCount(0);
					}catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
						tblmodel.setRowCount(0);
					}
					
				}
			}
		});
		btnSave.setBounds(289, 536, 188, 35);
		panel.add(btnSave);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 255));
		panel_1.setBackground(Color.GREEN);
		tabbedPane.addTab("Delete Drug", null, panel_1, null);
		tabbedPane.setForegroundAt(1, new Color(255, 0, 51));
		tabbedPane.setBackgroundAt(1, new Color(204, 102, 255));
		panel_1.setLayout(null);
		
		JLabel lblMedicineName_1 = new JLabel("Medicine Name");
		lblMedicineName_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblMedicineName_1.setBounds(31, 56, 146, 22);
		panel_1.add(lblMedicineName_1);
		
		delete_text = new JTextField();
		delete_text.setFont(new Font("Times New Roman", Font.BOLD, 21));
		delete_text.setColumns(10);
		delete_text.setBounds(189, 56, 211, 48);
		panel_1.add(delete_text);
		
		JLabel lblEnterMedicineName = new JLabel("Enter Medicine Name to delete from Database");
		lblEnterMedicineName.setForeground(Color.BLUE);
		lblEnterMedicineName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblEnterMedicineName.setBounds(12, 13, 476, 16);
		panel_1.add(lblEnterMedicineName);
		
		JButton delete = new JButton("Delete Record");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				String query="delete from Supplier where Med_Name=?";
				String find="select * from Supplier where Med_Name=?";
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					pstmt=(PreparedStatement) con.prepareStatement(find);
					pstmt.setString(1, delete_text.getText().toString());
					rs=pstmt.executeQuery();
					if(rs.next())
					{
						pstmt=(PreparedStatement) con.prepareStatement(query);
						pstmt.setString(1, delete_text.getText().toString());
						pstmt.execute();
						JOptionPane.showMessageDialog(null, "Record deleted ");
						delete_text.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Record not found ");
						delete_text.setText("");
					}
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		delete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		delete.setBounds(412, 56, 248, 37);
		panel_1.add(delete);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 257, 828, 151);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBackground(Color.YELLOW);
		table_1.setForeground(Color.BLACK);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Company", "Medicine Name", "Address", "Quantity", "Phone Number"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnLoadDatabase = new JButton("Load Database");
		btnLoadDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tblmodel=(DefaultTableModel)table_1.getModel();
				tblmodel.setRowCount(0);
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				String find="select * from Supplier";
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
						String com=rs.getString(1);
						String med=rs.getString(2);
						String addr=rs.getString(3);
						String qun=String.valueOf(rs.getInt(4));
						String ph=String.valueOf(rs.getInt(5));
						
						String array[]= {com,med,addr,qun,ph};
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
		btnLoadDatabase.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnLoadDatabase.setBounds(240, 207, 248, 37);
		panel_1.add(btnLoadDatabase);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(153, 102, 255));
		panel_2.setBackground(Color.CYAN);
		tabbedPane.addTab("Update Drug", null, panel_2, null);
		tabbedPane.setBackgroundAt(2, Color.YELLOW);
		panel_2.setLayout(null);
		JLabel lblMedicineCompany1 = new JLabel("Medicine Company");
		lblMedicineCompany1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblMedicineCompany1.setBounds(59, 185, 146, 22);
		panel_2.add(lblMedicineCompany1);
		
		JTextField company1 = new JTextField();
		company1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		company1.setBounds(211, 185, 178, 22);
		panel_2.add(company1);
		company1.setColumns(10);
		
		JLabel lblMedicineName1 = new JLabel("Medicine Name");
		lblMedicineName1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblMedicineName1.setBounds(416, 185, 146, 22);
		panel_2.add(lblMedicineName1);
		
		JTextField med_name1 = new JTextField();
		med_name1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		med_name1.setColumns(10);
		med_name1.setBounds(565, 186, 178, 22);
		panel_2.add(med_name1);
		
		JLabel lblCompanyAddress1 = new JLabel("Company Address");
		lblCompanyAddress1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblCompanyAddress1.setBounds(416, 233, 146, 22);
		panel_2.add(lblCompanyAddress1);
		
		JTextField phone1 = new JTextField();
		phone1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phone1.setColumns(10);
		phone1.setBounds(211, 234, 178, 22);
		panel_2.add(phone1);
		
		JLabel lblPhoneNumber1 = new JLabel("Phone Number");
		lblPhoneNumber1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblPhoneNumber1.setBounds(59, 233, 146, 22);
		panel_2.add(lblPhoneNumber1);
		
		JTextArea address1= new JTextArea();
		address1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		address1.setBounds(565, 234, 178, 92);
		panel_2.add(address1);
		
		JLabel lblMedicineQuantity1 = new JLabel("Medicine Quantity");
		lblMedicineQuantity1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblMedicineQuantity1.setBounds(59, 290, 146, 22);
		panel_2.add(lblMedicineQuantity1);
		
		JTextField quantity1 = new JTextField();
		quantity1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		quantity1.setColumns(10);
		quantity1.setBounds(211, 291, 178, 22);
		panel_2.add(quantity1);
		
		JButton button = new JButton("");
		button.setBackground(new Color(204, 102, 204));
		button.setBounds(0, 0, 828, 22);
		panel_2.add(button);
		
		JButton button_3 = new JButton("");
		button_3.setBackground(new Color(204, 0, 153));
		button_3.setBounds(0, 559, 828, 25);
		panel_2.add(button_3);
		
		JButton btnUpdateDrug = new JButton("Update Drug");
		btnUpdateDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				PreparedStatement stmt=null,stmt1=null,stmt2=null,stmt3=null,stmt4=null;
				ResultSet rs=null;
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				String med_name=med_name1.getText();
				try
				{
				
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					if(c1.isSelected())
					{
						String com=company1.getText();
						String sql="update Supplier set Company_Name=? where Med_Name=?";
						stmt=(PreparedStatement) con.prepareStatement(sql);
						stmt.setString(1,com);
						stmt.setString(2, med_name);
						stmt.execute();
						stmt.close();
					}
					if(c2.isSelected())
					{
						String med=med_name1.getText();
						String sql1="update Supplier set Med_Name=? where Med_Name=?";
						stmt1=(PreparedStatement) con.prepareStatement(sql1);
						stmt1.setString(1, med);
						stmt1.setString(2, med_name);
						stmt1.execute();
						stmt1.close();
					}
					if(c3.isSelected())
					{
						String addr=address1.getText();
						String sql2="update Supplier set Address=? where Med_Name=?";
						stmt2=(PreparedStatement) con.prepareStatement(sql2);
						stmt2.setString(1,addr);
						stmt2.setString(2, med_name);
						stmt2.execute();
						stmt2.close();
					}
					if(c4.isSelected())
					{
						int quan=Integer.parseInt(quantity1.getText());
						String sql3="update Supplier set Quantity=? where Med_Name=?";
						stmt3=(PreparedStatement) con.prepareStatement(sql3);
						stmt3.setInt(1,quan);
						stmt3.setString(2, med_name);
						stmt3.execute();
						stmt3.close();
					}
					if(c5.isSelected())
					{
						int ph=Integer.parseInt(phone1.getText());
						String sql4="update Supplier set Phone_no=? where Med_Name=?";
						stmt4=(PreparedStatement) con.prepareStatement(sql4);
						stmt4.setInt(1,ph);
						stmt4.setString(2, med_name);
						stmt4.executeUpdate();
						stmt4.close();
					}
					con.close();
					JOptionPane.showMessageDialog(null, "Data updated");
					company1.setText(" ");
					med_name1.setText(" ");
					address1.setText(" ");
					phone1.setText(" ");
					quantity1.setText(" ");
				}catch(Exception i)
				{
					JOptionPane.showMessageDialog(null, i);
				}
				
			}
		});
		btnUpdateDrug.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 23));
		btnUpdateDrug.setBounds(305, 344, 224, 55);
		panel_2.add(btnUpdateDrug);
		
		 c1 = new JCheckBox("Company ");
		c1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		c1.setBackground(new Color(255, 102, 204));
		c1.setBounds(59, 79, 113, 43);
		panel_2.add(c1);
		
		 c2 = new JCheckBox("Medicine");
		c2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		c2.setBackground(new Color(255, 102, 204));
		c2.setBounds(205, 79, 113, 43);
		panel_2.add(c2);
		
		 c3 = new JCheckBox("Address");
		c3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		c3.setBackground(new Color(255, 102, 204));
		c3.setBounds(345, 79, 113, 43);
		panel_2.add(c3);
		
		 c4 = new JCheckBox("Quantity");
		c4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		c4.setBackground(new Color(255, 102, 204));
		c4.setBounds(491, 79, 113, 43);
		panel_2.add(c4);
		
		 c5 = new JCheckBox("Phone number");
		c5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		c5.setBackground(new Color(255, 102, 204));
		c5.setBounds(630, 79, 138, 43);
		panel_2.add(c5);
		
		JLabel lblTickMarkThe = new JLabel("Tick mark the checkbox which fields do you want to update");
		lblTickMarkThe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblTickMarkThe.setBounds(59, 54, 709, 16);
		panel_2.add(lblTickMarkThe);
		
		JTextArea txtrEnterTheDetails = new JTextArea();
		txtrEnterTheDetails.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtrEnterTheDetails.setForeground(new Color(0, 0, 204));
		txtrEnterTheDetails.setText("Enter the details of the fields which you have choosen above But Kindly mention the name of Medicine");
		txtrEnterTheDetails.setRows(3);
		txtrEnterTheDetails.setBounds(0, 142, 828, 30);
		panel_2.add(txtrEnterTheDetails);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(255, 215, 0));
		panel_3.setBackground(new Color(255, 0, 255));
		tabbedPane.addTab("Show Database", null, panel_3, null);
		tabbedPane.setForegroundAt(3, new Color(255, 0, 0));
		tabbedPane.setBackgroundAt(3, new Color(173, 255, 47));
		panel_3.setLayout(null);
		
		JButton btnLoadDatabase_1 = new JButton("Load Database");
		btnLoadDatabase_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tblmodel=(DefaultTableModel)table_2.getModel();
				tblmodel.setRowCount(0);
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				String find="select * from Supplier";
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
						String com=rs.getString(1);
						String med=rs.getString(2);
						String addr=rs.getString(3);
						String qun=String.valueOf(rs.getInt(4));
						String ph=String.valueOf(rs.getInt(5));
						
						String array[]= {com,med,addr,qun,ph};
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
		btnLoadDatabase_1.setForeground(new Color(0, 0, 205));
		btnLoadDatabase_1.setBackground(new Color(255, 153, 255));
		btnLoadDatabase_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnLoadDatabase_1.setBounds(277, 33, 277, 48);
		panel_3.add(btnLoadDatabase_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 109, 828, 475);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setBackground(new Color(0, 255, 255));
		table_2.setForeground(new Color(153, 50, 204));
		table_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Company", "Medicine Name", "Address", "Quantity", "Phone Number"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(199, 21, 133));
		panel_4.setBounds(0, 0, 143, 750);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(199, 21, 133));
		panel_5.setBounds(0, 748, 1243, 137);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(199, 21, 133));
		panel_6.setBounds(1241, 0, 136, 885);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
	
		
		JButton btnNewButton = new JButton(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\back_new.jpg"));
		btnNewButton.setBounds(63, 807, 61, 65);
		panel_6.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Ex f=new Ex();
				Supplier_Screen f=new Supplier_Screen();
				f.setVisible(true);
				dispose();
			}
		});
	}
}
