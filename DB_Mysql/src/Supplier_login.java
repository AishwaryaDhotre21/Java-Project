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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Supplier_login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private static Supplier_login frame ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new Supplier_login();
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
	public Supplier_login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 843, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSupplierLoginScreen = new JLabel("Supplier login Screen");
		lblSupplierLoginScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupplierLoginScreen.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 20));
		lblSupplierLoginScreen.setBackground(Color.CYAN);
		lblSupplierLoginScreen.setBounds(258, 13, 301, 42);
		contentPane.add(lblSupplierLoginScreen);
		
		JLabel label = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\pharmacy.jpg"));
		label.setBounds(165, 57, 497, 178);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Login ID");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(258, 268, 156, 27);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setToolTipText("Enter Login ID");
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBounds(417, 265, 186, 33);
		contentPane.add(textField);
		
		JLabel label_2 = new JLabel("Login Name");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(258, 312, 109, 22);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setToolTipText("Enter Login Name\r\n");
		textField_1.setColumns(10);
		textField_1.setBounds(417, 313, 186, 33);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(258, 355, 156, 33);
		contentPane.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Password except Customers");
		passwordField.setBounds(417, 359, 186, 33);
		contentPane.add(passwordField);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				Connection con=null;
				PreparedStatement stmt=null;
				ResultSet rs=null;
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					stmt=con.prepareStatement("select * from  login where Login_Id=?");
					stmt.setString(1, "#4");
					rs=stmt.executeQuery();
					String s1=textField.getText().toString();
					String s2=textField_1.getText().toString();
					String s3=String.valueOf(passwordField.getText());
					if(rs.next())
					{
						if(s1.equals(rs.getString(1)) && s2.equals(rs.getString(2)) && s3.equals(rs.getString(3)))
						{
							Supplier_Screen s=new Supplier_Screen();
							s.setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(s,"Login Successful");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Login UnSuccessful");
						}
					}
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
			});
		
		button.setFont(new Font("Tahoma", Font.BOLD, 19));
		button.setBounds(121, 415, 301, 42);
		contentPane.add(button);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ex e1=new Ex();
				e1.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnBack.setBounds(417, 415, 287, 42);
		contentPane.add(btnBack);
	}
	
	
	
}
