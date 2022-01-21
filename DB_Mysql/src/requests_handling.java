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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class requests_handling extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField del_med;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					requests_handling frame = new requests_handling();
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
	public requests_handling() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 762);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblmodel1=(DefaultTableModel)table.getModel();
				tblmodel1.setRowCount(0);
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				String driverName="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
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
		panel.setLayout(null);
		panel.setToolTipText("click to see request table");
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 13, 996, 32);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Display Order Requests");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		label.setBackground(Color.MAGENTA);
		label.setBounds(362, 0, 261, 29);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 79, 996, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine  Name", "Quantity", "Request Date", "Request Staus"
			}
		));
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		JLabel lblEnterMedicineName = new JLabel("Enter Medicine Name");
		lblEnterMedicineName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblEnterMedicineName.setBounds(162, 297, 217, 32);
		contentPane.add(lblEnterMedicineName);
		
		del_med = new JTextField();
		del_med.setFont(new Font("Times New Roman", Font.BOLD, 16));
		del_med.setColumns(10);
		del_med.setBounds(408, 300, 192, 32);
		contentPane.add(del_med);
		
		JButton btnConfirmOrder = new JButton("Confirm order");
		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con=null;
				ResultSet rs=null;
				String find="select * from stock_request where med_name=?";
				String url="jdbc:mysql://localhost:3306/mini_project_pharmacy_management_system";
				String driverName="com.mysql.jdbc.Driver";
				String sql="delete from stock_request where med_name=?";
				PreparedStatement stmt=null;
				try
				{
					Class.forName(driverName);
					con=DriverManager.getConnection(url,"root","root");
					stmt=con.prepareStatement(find);
					stmt.setString(1, del_med.getText().toString());
					rs=stmt.executeQuery();
					if(rs.next())
					{
						stmt=con.prepareStatement(sql);
						stmt.setString(1, del_med.getText().toString());
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record deleted ");
						del_med.setText("");
					}else
					{
						JOptionPane.showMessageDialog(null, "Record not found ");
						del_med.setText("");
					}
					con.close();
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnConfirmOrder.setToolTipText("click to place order");
		btnConfirmOrder.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnConfirmOrder.setBackground(Color.GREEN);
		btnConfirmOrder.setBounds(648, 297, 183, 32);
		contentPane.add(btnConfirmOrder);
		
		JButton button = new JButton(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\back_new.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Supplier_Screen f=new Supplier_Screen();
				f.setVisible(true);
				dispose();
			}
		});
		button.setBounds(931, 650, 61, 65);
		contentPane.add(button);
	}
}
