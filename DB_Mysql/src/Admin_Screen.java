import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Admin_Screen {

	private JFrame frame;
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
					Admin_Screen window = new Admin_Screen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.setBounds(100, 100, 770, 540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\pharmacy.jpg"));
		label.setBounds(146, 13, 497, 178);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Pharmacy Management System");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		label_1.setBackground(new Color(153, 50, 204));
		label_1.setBounds(122, 204, 576, 42);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Login ID");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(244, 259, 156, 27);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setToolTipText("Enter Login ID");
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBounds(408, 256, 186, 33);
		frame.getContentPane().add(textField);
		
		JLabel label_3 = new JLabel("Login Name");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(244, 313, 109, 22);
		frame.getContentPane().add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter Login Name\r\n");
		textField_1.setColumns(10);
		textField_1.setBounds(408, 314, 186, 33);
		frame.getContentPane().add(textField_1);
		
		JLabel label_4 = new JLabel("Password");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(244, 372, 156, 33);
		frame.getContentPane().add(label_4);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Password except Customers");
		passwordField.setBounds(408, 378, 186, 33);
		frame.getContentPane().add(passwordField);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

				
				Connection con=null;
				//Statement stmt=null;
				PreparedStatement pstmt;
				ResultSet rs=null;
				int flag=1;
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				 
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					pstmt=(PreparedStatement) con.prepareStatement("select * from Login where Login_Id=?");
					pstmt.setString(1, "#1");
					rs=pstmt.executeQuery();
					String idval=textField.getText().toString();
					String logName=textField_1.getText().toString();
					String passval=passwordField.getText().toString();
					  if(rs.next())
					  {
						if(idval.equals(rs.getString("Login_Id")) && logName.equals(rs.getString("Login_Name")) && passval.equals(rs.getString("Login_Password")))
						{
							//JOptionPane.showMessageDialog(null, "Login Successfull");
							//Main_Screen window = new Main_Screen();
							frame.dispose();
							Ex ob=new Ex();
							ob.setVisible(true);
						
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Login UnSuccessfull");
						}
					  }
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
			
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 19));
		button.setBounds(82, 438, 301, 42);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		button_1.setBounds(408, 438, 287, 42);
		frame.getContentPane().add(button_1);
	}
}
