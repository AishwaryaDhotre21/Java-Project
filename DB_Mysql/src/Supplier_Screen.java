import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Supplier_Screen extends JFrame {

	private JPanel contentPane;
	private JPanel p1,p2,p3;
	private JTextField txtWeAreDealers;
	private JTable table_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier_Screen frame = new Supplier_Screen();
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
	public Supplier_Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1124, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 327, 701);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 255, 47));
		panel_1.setBounds(0, 13, 327, 64);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDrugSuppliers = new JLabel("Drug Suppliers");
		lblDrugSuppliers.setBackground(new Color(124, 252, 0));
		lblDrugSuppliers.setForeground(new Color(255, 0, 0));
		lblDrugSuppliers.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblDrugSuppliers.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrugSuppliers.setBounds(27, 13, 259, 37);
		panel_1.add(lblDrugSuppliers);
		
		JPanel tab1 = new JPanel();
		tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				p1.setVisible(true);
				p2.setVisible(false);
				p3.setVisible(false);
			}
		});
		tab1.setBounds(0, 277, 327, 64);
		panel.add(tab1);
		tab1.setLayout(null);
		
		JLabel lblHome = new JLabel("About us");
		lblHome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(105, 23, 104, 28);
		tab1.add(lblHome);
		
		JPanel tab2 = new JPanel();
		tab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p1.setVisible(false);
				p2.setVisible(true);
				p3.setVisible(false);
			}
		});
		tab2.setBounds(0, 367, 327, 55);
		panel.add(tab2);
		tab2.setLayout(null);
		
		JLabel lblContactUs = new JLabel("Contact us");
		lblContactUs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContactUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactUs.setBounds(116, 13, 99, 29);
		tab2.add(lblContactUs);
		
		JPanel tab3 = new JPanel();
		tab3.setBounds(0, 450, 327, 55);
		panel.add(tab3);
		tab3.setLayout(null);
		
		JButton btnDatabase = new JButton("Database");
		btnDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Supplier_DB s=new Supplier_DB();
				s.setVisible(true);
				dispose();
			}
		});
		btnDatabase.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDatabase.setBounds(88, 13, 146, 29);
		tab3.add(btnDatabase);
		
		JLabel label = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\home.jpg"));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ex f=new Ex();
				f.setVisible(true);
				dispose();
			}
		});
		label.setBounds(72, 90, 185, 178);
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				requests_handling r=new requests_handling();
				r.setVisible(true);
				dispose();
			}
		});
		panel_2.setLayout(null);
		panel_2.setBounds(0, 532, 327, 55);
		panel.add(panel_2);
		
		JLabel lblRequests = new JLabel("Requests");
		lblRequests.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequests.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRequests.setBounds(116, 13, 99, 29);
		panel_2.add(lblRequests);
		
		p1 = new JPanel();
		p1.setBackground(Color.GREEN);
		p1.setBounds(328, 0, 778, 701);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JPanel p11 = new JPanel();
		p11.setBackground(Color.BLUE);
		p11.setBounds(0, 0, 778, 24);
		p1.add(p11);
		
		JPanel p12 = new JPanel();
		p12.setBackground(Color.BLUE);
		p12.setBounds(756, 13, 22, 688);
		p1.add(p12);
		
		JPanel p13 = new JPanel();
		p13.setBackground(Color.BLUE);
		p13.setBounds(0, 682, 766, 19);
		p1.add(p13);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\pharmacy_new.jpg"));
		lblNewLabel.setBounds(0, 60, 755, 522);
		p1.add(lblNewLabel);
		
		txtWeAreDealers = new JTextField();
		txtWeAreDealers.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		txtWeAreDealers.setBackground(new Color(238, 130, 238));
		txtWeAreDealers.setText("We are Dealers of Drugs in India,We supply the Generic Medicines throught the Country");
		txtWeAreDealers.setBounds(0, 583, 755, 49);
		p1.add(txtWeAreDealers);
		txtWeAreDealers.setColumns(10);
		
		p2 = new JPanel();
		p2.setBackground(Color.ORANGE);
		p2.setBounds(328, 0, 778, 701);
		contentPane.add(p2);
		table_2 = new JTable();
		table_2.setBackground(new Color(0, 255, 255));
		table_2.setForeground(new Color(153, 50, 204));
		table_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Company", "Address", "Phone Number"
			}
		));
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 109, 828, 475);
		p2.add(scrollPane_2);
		scrollPane_2.setViewportView(table_2);
		JButton btnLoadDatabase_1 = new JButton("Load Database");
		btnLoadDatabase_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tblmodel=(DefaultTableModel)table_2.getModel();
				tblmodel.setRowCount(0);
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				String find="select Company_Name,Address,Phone_no from Supplier";
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
						//String med=rs.getString(2);
						String addr=rs.getString(2);
						//String qun=String.valueOf(rs.getInt(4));
						String ph=String.valueOf(rs.getInt(3));
						
						String array[]= {com,addr,ph};
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
		p2.add(btnLoadDatabase_1);
		
		
		p3 = new JPanel();
		p3.setBackground(new Color(218, 112, 214));
		p3.setBounds(328, 0, 778, 701);
		contentPane.add(p3);
		p3.setLayout(null);
		
		
	}
}
