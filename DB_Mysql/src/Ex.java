import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Ex extends JFrame {

	private JPanel contentPane;
	private static Ex frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Ex();
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
	public Ex() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 826, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel label = new JLabel(new ImageIcon("I:\\java ex\\DB_Mysql\\src\\pharmacy.jpg"));
		label.setBackground(Color.CYAN);
		label.setBounds(161, 0, 497, 178);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Pharmacy Management System");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(105, 191, 576, 42);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("Supplier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{ 
				Supplier_login s=new Supplier_login();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setToolTipText("click to open Supplier database");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(new Color(139, 0, 139));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(84, 298, 177, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Store");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Store_login sto=new Store_login();
			sto.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setToolTipText("Click to open Store database");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(544, 298, 177, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Customer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Customer_login c=new Customer_login();
				c.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 0, 255));
		btnNewButton_2.setToolTipText("Click to open customer portal");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setForeground(new Color(139, 0, 139));
		btnNewButton_2.setBounds(314, 358, 177, 60);
		contentPane.add(btnNewButton_2);
		
	}
}
