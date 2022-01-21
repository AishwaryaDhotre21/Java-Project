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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Customer_login extends JFrame {

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
					Customer_login frame = new Customer_login();
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
	public Customer_login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1248, 592);
		contentPane = new JPanel();
		contentPane.setToolTipText("no need to enter password");
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\Screenshot .jpg"));
		lblNewLabel.setBounds(-35, 0, 801, 545);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Login ID");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(812, 140, 156, 27);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setToolTipText("Enter Login ID #3");
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBounds(980, 137, 186, 33);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Login Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(808, 250, 109, 22);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter Login Name as Customer\r\n");
		textField_1.setColumns(10);
		textField_1.setBounds(980, 246, 186, 33);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(812, 340, 156, 33);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Password except Customers");
		passwordField.setBounds(980, 346, 186, 33);
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
					stmt.setString(1, "#3");
					rs=stmt.executeQuery();
					String s1=textField.getText().toString();
					String s2=textField_1.getText().toString();

					if(rs.next())
					{
						if(s1.equals(rs.getString(1)) && s2.equals(rs.getString(2)) )
						{	Customer_screen s=new Customer_screen();
							s.setVisible(true);
							JOptionPane.showMessageDialog(s,"Login Successful");
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
		button.setBackground(new Color(255, 153, 255));
		button.setFont(new Font("Tahoma", Font.BOLD, 19));
		button.setBounds(836, 428, 301, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.setBackground(new Color(255, 153, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ex s=new Ex();
				s.setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		button_1.setBounds(836, 490, 301, 42);
		contentPane.add(button_1);
		
		JLabel lblCustomerPortal = new JLabel("Customer Portal");
		lblCustomerPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerPortal.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 27));
		lblCustomerPortal.setBackground(Color.CYAN);
		lblCustomerPortal.setBounds(820, 36, 301, 42);
		contentPane.add(lblCustomerPortal);
	}

}
