import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Store_login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store_login frame = new Store_login();
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
	public Store_login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 874, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\store1.jpg"));
		lblNewLabel.setBounds(346, 0, 510, 480);
		contentPane.add(lblNewLabel);
		
		JLabel lblCvsPharmacy = new JLabel("CVS Pharmacy");
		lblCvsPharmacy.setHorizontalAlignment(SwingConstants.CENTER);
		lblCvsPharmacy.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 27));
		lblCvsPharmacy.setBackground(Color.CYAN);
		lblCvsPharmacy.setBounds(23, 13, 301, 42);
		contentPane.add(lblCvsPharmacy);
		
		JLabel label = new JLabel("Login ID");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(0, 110, 156, 27);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setToolTipText("Enter Login ID");
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBounds(155, 107, 186, 33);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Login Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(0, 180, 109, 22);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter Login Name\r\n");
		textField_1.setColumns(10);
		textField_1.setBounds(155, 181, 186, 33);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(0, 257, 156, 33);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Password except Customers");
		passwordField.setBounds(155, 263, 186, 33);
		contentPane.add(passwordField);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					stmt.setString(1, "#2");
					rs=stmt.executeQuery();
					String s1=textField.getText().toString();
					String s2=textField_1.getText().toString();
					String s3=String.valueOf(passwordField.getText());
					if(rs.next())
					{
						if(s1.equals(rs.getString(1)) && s2.equals(rs.getString(2)) && s3.equals(rs.getString(3)))
						{
							Store_Screen sto=new Store_Screen();
							sto.setVisible(true);
							JOptionPane.showMessageDialog(sto,"Login Successful");
							dispose();
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
		button.setBackground(new Color(255, 153, 255));
		button.setBounds(12, 334, 301, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ex s=new Ex();
				s.setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		button_1.setBackground(new Color(255, 153, 255));
		button_1.setBounds(12, 408, 301, 42);
		contentPane.add(button_1);
	}
}
