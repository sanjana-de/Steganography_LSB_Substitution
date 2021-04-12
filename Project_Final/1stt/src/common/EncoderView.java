package common;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EncoderView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public JPasswordField passwordField;
	private JButton btnProceed;
	
	public char[] key;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncoderView frame = new EncoderView();
					frame.setVisible(true);
					//key=passwordField.getPassword();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EncoderView() 
	{
		
		initComonents();
		createEvents();
		
	}

	
	//to initialize the components
	private void initComonents() 
	{
		
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(EncoderView.class.getResource("/resources/bulb-curvy-flat.png")));
		setTitle("Encoder's End");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 392);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(0, 139, 139)));
		setContentPane(contentPane);
		
		JLabel lblEnterUserName = new JLabel("Enter User Name : ");
		lblEnterUserName.setForeground(new Color(152, 251, 152));
		lblEnterUserName.setBackground(new Color(144, 238, 144));
		lblEnterUserName.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 21));
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 235, 205));
		textField.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 20));
		textField.setColumns(10);
		
		JLabel lblEnterSeedkey = new JLabel("Enter Key : ");
		lblEnterSeedkey.setForeground(new Color(152, 251, 152));
		lblEnterSeedkey.setBackground(new Color(255, 255, 255));
		lblEnterSeedkey.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 21));
		
		passwordField = new JPasswordField();

		passwordField.setBackground(new Color(255, 239, 213));
		passwordField.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 20));
		
		btnProceed = new JButton("Proceed");
		btnProceed.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 23));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(203)
							.addComponent(btnProceed, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
							.addGap(75))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterUserName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnterSeedkey, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
									.addGap(17)))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
					.addGap(21))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEnterUserName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(textField))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(lblEnterSeedkey, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(104)
					.addComponent(btnProceed, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
	//to create the events for the components
	private void createEvents() 
	{
		
		
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				EncodeHere eh = new EncodeHere();
				eh.setVisible(true);
				
				key= passwordField.getPassword();
			}
		});
		
	
		
	}
}
