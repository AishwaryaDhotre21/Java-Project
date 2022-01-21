import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Start_Screen {

	private static final ItemListener ItemListener = null;
	private JFrame frame;
	private JTextField id;
	private JPasswordField pass;
	private JTextField loginName;
	String str="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start_Screen window = new Start_Screen();
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
	public Start_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setForeground(Color.CYAN);
		frame.setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 837, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pharmacy Management System");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(183, 213, 576, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblLoginId = new JLabel("Login ID");
		lblLoginId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginId.setBounds(287, 271, 156, 27);
		frame.getContentPane().add(lblLoginId);
		
		id = new JTextField();
		id.setToolTipText("Enter Login ID");
		id.setFont(new Font("Tahoma", Font.BOLD, 16));
		id.setBounds(454, 268, 186, 33);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(286, 381, 156, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setToolTipText("Enter Password except Customers");
		pass.setBounds(454, 382, 186, 33);
		frame.getContentPane().add(pass);
		
		JLabel lblLoginName = new JLabel("Login Name");
		lblLoginName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginName.setBounds(287, 333, 109, 22);
		frame.getContentPane().add(lblLoginName);
		
		loginName = new JTextField();
		loginName.setToolTipText("Enter Login Name\r\n");
		loginName.setBounds(454, 329, 186, 33);
		frame.getContentPane().add(loginName);
		loginName.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				int flag=1;
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				String sql="select * from login";
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					while(rs.next())
					{ 	
						String idval=id.getText().toString();
						String passval=pass.getText().toString();
						String logName=loginName.getText().toString();
						//String type=comboBox.getItem();
						if(idval.equals(rs.getString("Login_Id")) && logName.equals(rs.getString("Login_Name")) && passval.equals(rs.getString("Login_Password")))
						{
							flag=1;
							break;
						}
						else
						{
							flag=0;
						}
					}

					if (flag==1)
					{
						JOptionPane.showMessageDialog(null, "Login Successfull");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Login Unsuccessfull");
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(157, 447, 301, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1.setBounds(494, 447, 287, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\pharmacy.jpg"));
		label.setBounds(198, 13, 497, 178);
		frame.getContentPane().add(label);
		
	}
	
}
