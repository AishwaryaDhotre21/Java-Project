import java.awt.BorderLayout;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
public class Customer_screen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField name;
	private JTextField phno;
	private JTextField addr;
	private JTextField med_name;
	private JTextField qun;
	private JTable table_2;
	private JTable table_3;
	private Connection con=null;
	private ResultSet rs=null;
	private Statement stmt=null;
	private PreparedStatement pstmt=null,pstmt1=null; 
	private String driverName="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
	private JLabel c,d,t,p,total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_screen frame = new Customer_screen();
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
	public Customer_screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1338, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 4, 3, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 13, 1320, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerPortal = new JLabel("Customer Portal");
		lblCustomerPortal.setForeground(new Color(255, 255, 0));
		lblCustomerPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerPortal.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblCustomerPortal.setBounds(558, 13, 239, 38);
		panel.add(lblCustomerPortal);
		
		JLabel label_1 = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\arrow_back.jpg"));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ex sto=new Ex();
				sto.setVisible(true);
				dispose();
			}
		});
		label_1.setBounds(1252, 13, 56, 38);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(64, 224, 208));
		panel_1.setBounds(0, 94, 1320, 670);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 204, 204));
		panel_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(61, 47, 371, 580);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Medicine Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(12, 27, 128, 16);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(152, 20, 195, 34);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String search=textField.getText().toString();
				String query="select Med_Name, Med_Sell_Price , Exp_Date from stock where Med_Name=?";
				DefaultTableModel tblmodel=(DefaultTableModel)table.getModel();
				tblmodel.setRowCount(0);
				try
				{	int flag=0;
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					pstmt=con.prepareStatement(query);
					pstmt.setString(1, search);
					rs=pstmt.executeQuery();
					while(rs.next())
					{
						String med=rs.getString(1);
						String sell=String.valueOf(rs.getInt(2));
						String date=rs.getString(3);
						String array[]= {med,sell,date};
						tblmodel.addRow(array);
						//flag=1;
					}
					/*if(!(flag==1))
					{
						JOptionPane.showMessageDialog(null, "Record Not found, You can place a medicine request through  place request button");
					}*/
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				textField.setText(" ");
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(127, 73, 97, 25);
		panel_2.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 133, 347, 105);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Price", "Expiry Date"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblEnterMedicineName = new JLabel("Enter Medicine Name");
		lblEnterMedicineName.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblEnterMedicineName.setBounds(0, 273, 195, 16);
		panel_2.add(lblEnterMedicineName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(186, 266, 173, 34);
		panel_2.add(textField_1);
		
		JLabel lblStoreResponses = new JLabel("Store Responses");
		lblStoreResponses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String search=textField.getText().toString();
				String query="select * from store_response";
				DefaultTableModel tblmodel=(DefaultTableModel)table_1.getModel();
				tblmodel.setRowCount(0);
				try
				{	
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					pstmt=con.prepareStatement(query);
					rs=pstmt.executeQuery();
					while(rs.next())
					{
						String med_name=rs.getString(1);
						String req_date=rs.getString(2);
						String fdate=rs.getString(3);
						String status=rs.getString(4);
						String datediff=String.valueOf(rs.getInt(5));
						String array[]= {med_name,req_date,fdate,status,datediff};
						tblmodel.addRow(array);
					}
				}catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		lblStoreResponses.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreResponses.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblStoreResponses.setBounds(95, 379, 173, 25);
		panel_2.add(lblStoreResponses);
		
		JLabel lblPlaceRequest = new JLabel("Place Request");
		lblPlaceRequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name=textField_1.getText().toString();
				String query="insert into customer_request values(?,curdate(),'NOT AVAILABLE')";
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					pstmt=con.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "Inserted");
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);;
				}
			}
		});
		lblPlaceRequest.setBounds(127, 323, 130, 26);
		panel_2.add(lblPlaceRequest);
		lblPlaceRequest.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceRequest.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 417, 347, 150);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "ReqDate", "FulfilDate", "Status", "DateDiff"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(0, 204, 204));
		panel_3.setBounds(485, 47, 371, 580);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(12, 13, 140, 23);
		lblCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 19));
		panel_3.add(lblCustomerName);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		name.setColumns(10);
		name.setBounds(164, 9, 195, 33);
		panel_3.add(name);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblPhoneNo.setBounds(12, 61, 140, 23);
		panel_3.add(lblPhoneNo);
		
		phno = new JTextField();
		phno.setFont(new Font("Tahoma", Font.BOLD, 15));
		phno.setColumns(10);
		phno.setBounds(164, 55, 195, 33);
		panel_3.add(phno);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAddress.setBounds(12, 104, 140, 23);
		panel_3.add(lblAddress);
		
		addr = new JTextField();
		addr.setFont(new Font("Tahoma", Font.BOLD, 15));
		addr.setColumns(10);
		addr.setBounds(164, 101, 195, 33);
		panel_3.add(addr);
		
		JLabel lblMedicineName = new JLabel("Medicine Name");
		lblMedicineName.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblMedicineName.setBounds(12, 150, 140, 23);
		panel_3.add(lblMedicineName);
		
		med_name = new JTextField();
		med_name.setFont(new Font("Tahoma", Font.BOLD, 15));
		med_name.setColumns(10);
		med_name.setBounds(164, 147, 195, 33);
		panel_3.add(med_name);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblQuantity.setBounds(12, 197, 140, 23);
		panel_3.add(lblQuantity);
		
		qun = new JTextField();
		qun.setFont(new Font("Tahoma", Font.BOLD, 15));
		qun.setColumns(10);
		qun.setBounds(164, 193, 195, 33);
		panel_3.add(qun);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 306, 347, 160);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine", "quantity", "Price", "Total"
			}
		));
		scrollPane_2.setViewportView(table_2);
		DefaultTableModel tblmodel=(DefaultTableModel)table_2.getModel();
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cust=name.getText().toString();
				int phone=Integer.parseInt(phno.getText());
				String address=addr.getText().toString();
				String medname=med_name.getText().toString();
				int quantity=Integer.parseInt(qun.getText());
				String price_query="select Med_Sell_Price from stock where Med_Name=?";
				String insert_query="insert into customer values(?,?,?,?,?,?,curdate(),?)";
				int price=0;
				int totalprice=0;
				String show="select Med_Name,Med_Quantity,Med_Price,Total_Price from customer where Cust_Name=? and Purchase_Date=curdate()";
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					pstmt=con.prepareStatement(price_query);
					pstmt.setString(1, medname);
					rs=pstmt.executeQuery();
					if(rs.next())
					{
						price=rs.getInt(1);
					}
					totalprice=price*quantity;
					pstmt=con.prepareStatement(insert_query);
					pstmt.setString(1,cust);
					pstmt.setInt(2,phone);
					pstmt.setString(3, address);
					pstmt.setString(4, medname);
					pstmt.setInt(5, quantity);
					pstmt.setInt(6, price);
					pstmt.setInt(7, totalprice);
					pstmt.execute();
					pstmt.close();
					med_name.setText("");
					qun.setText("");
					tblmodel.setRowCount(0);
					pstmt1=con.prepareStatement(show);
					pstmt1.setString(1,cust);
					rs=pstmt1.executeQuery();
					while(rs.next())
					{
						String m=rs.getString(1);
						String q=String.valueOf(rs.getInt(2));
						String p=String.valueOf(rs.getInt(3));
						String t=String.valueOf(rs.getInt(4));
						String array[]= {m,q,p,t};
						tblmodel.addRow(array);
						
					}
				}catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null, e3);
				}
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnAdd.setBounds(131, 263, 97, 25);
		panel_3.add(btnAdd);
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String customer=name.getText();
				c.setText(customer);
				String show="select Med_Name,Med_Quantity,Med_Price,Total_Price from customer where Cust_Name=? and Purchase_Date=curdate()";
				String phoneval=phno.getText().toString();
				p.setText(phoneval);
				SimpleDateFormat dformat=new SimpleDateFormat("dd-MM-yyyy");
				Date date=new Date();
				d.setText(dformat.format(date));
				DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalDateTime now=LocalDateTime.now();
				t.setText(dtf.format(now));
				DefaultTableModel tblmodel1=(DefaultTableModel)table_3.getModel();
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					tblmodel1.setRowCount(0);
					pstmt1=con.prepareStatement(show);
					pstmt1.setString(1,customer);
					rs=pstmt1.executeQuery();
					while(rs.next())
					{
						String m=rs.getString(1);
						String q=String.valueOf(rs.getInt(2));
						String p=String.valueOf(rs.getInt(3));
						String t=String.valueOf(rs.getInt(4));
						String array[]= {m,q,p,t};
						tblmodel1.addRow(array);
						
					}
					String sql1="select sum(Total_Price) from customer where Cust_Name=? and Purchase_Date=curdate()";
					pstmt=con.prepareStatement(sql1);
					pstmt.setString(1,customer );
					rs=pstmt.executeQuery();
					if(rs.next())
					{
						total.setText(String.valueOf(rs.getInt(1)));
		
					}
				}catch(Exception e4)
				{
					JOptionPane.showMessageDialog(null, e4);
				}
			}
		});
		btnGenerateBill.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnGenerateBill.setBounds(24, 501, 158, 33);
		panel_3.add(btnGenerateBill);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				phno.setText("");
				addr.setText("");
				med_name.setText("");
				qun.setText("");
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnCancel.setBounds(194, 501, 158, 33);
		panel_3.add(btnCancel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(903, 47, 371, 580);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("**************************");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(12, 13, 347, 16);
		panel_4.add(lblNewLabel_1);
		
		JLabel custname = new JLabel("Name");
		custname.setFont(new Font("Tahoma", Font.BOLD, 13));
		custname.setBounds(32, 48, 67, 33);
		panel_4.add(custname);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setBounds(32, 94, 33, 27);
		panel_4.add(lblDate);
		
		JLabel lblPhoneNo_1 = new JLabel("Phone No");
		lblPhoneNo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNo_1.setBounds(32, 173, 60, 27);
		panel_4.add(lblPhoneNo_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(23, 213, 325, 204);
		panel_4.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine", "Quantity", "Price", "Total"
			}
		));
		scrollPane_3.setViewportView(table_3);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=c.getText();
				String date=d.getText();
				String time=t.getText();
				String phone=String.valueOf(p.getText());
				String totalval=String.valueOf(total.getText());
				String path="I:\\DBMS Project\\Payment recipts\\";
				com.itextpdf.text.Document doc= new com.itextpdf.text.Document();
				try
				{
					PdfWriter.getInstance(doc, new FileOutputStream(path+""+name+" "+date+".pdf"));
					doc.open();
					Paragraph p1=new Paragraph("                                                                          CVS Pharmacy\n\n\n");
					doc.add(p1);
					Paragraph p2=new Paragraph("Date:"+date+"\nTime:"+time+"\nName:"+name+"\nPhone No:"+phone+"\n\n");
					doc.add(p2);
					PdfPTable tbl1=new PdfPTable(4);
					tbl1.addCell("Medicine Name");
					tbl1.addCell("Medicine Quantity");
					tbl1.addCell("Medicine Price");
					tbl1.addCell("Total Price");
					for(int i=0;i<table_3.getRowCount();i++)
					{
						String m=table_3.getValueAt(i, 0).toString();
						String q=table_3.getValueAt(i, 1).toString();
						String p=table_3.getValueAt(i, 2).toString();
						String t=table_3.getValueAt(i, 3).toString();
						tbl1.addCell(m);
						tbl1.addCell(q);
						tbl1.addCell(p);
						tbl1.addCell(t);
					}
					doc.add(tbl1);
					Paragraph p3=new Paragraph("\n\n\nAmount To be Paid:"+totalval+"\n\n\n\n THANK YOU !!!!"+"\n\n\n                                                               GET WELL SOON !!");
					doc.add(p3);
					JOptionPane.showMessageDialog(null, "Bill Generated");
					doc.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
	
			}
		});
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnPrint.setBounds(109, 490, 158, 33);
		panel_4.add(btnPrint);
		
		JLabel label = new JLabel("**************************");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(12, 551, 347, 16);
		panel_4.add(label);
		
		 d = new JLabel("");
		 d.setFont(new Font("Tahoma", Font.BOLD, 13));
		d.setBounds(88, 94, 281, 33);
		panel_4.add(d);
		
		 c = new JLabel("");
		 c.setFont(new Font("Tahoma", Font.BOLD, 13));
		c.setBounds(88, 48, 258, 33);
		panel_4.add(c);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTime.setBounds(32, 134, 33, 27);
		panel_4.add(lblTime);
		
		 t = new JLabel("");
		 t.setFont(new Font("Tahoma", Font.BOLD, 13));
		t.setBounds(88, 127, 281, 33);
		panel_4.add(t);
		
		 p = new JLabel("");
		 p.setFont(new Font("Tahoma", Font.BOLD, 13));
		p.setBounds(101, 167, 258, 33);
		panel_4.add(p);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalAmount.setBounds(32, 430, 107, 16);
		panel_4.add(lblTotalAmount);
		
		 total = new JLabel("");
		total.setBounds(151, 419, 176, 33);
		panel_4.add(total);
	}
}
