package common;

import java.awt.BorderLayout;

import common.EncoderView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class DecoderView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnProceed;
	
	public char[] key1;
	public char[] key2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecoderView frame = new DecoderView();
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
	public DecoderView() 
	{

		initComponents();
		createEvents();
	
	}

	//initializing components
	private void initComponents() 
	{

		setTitle("Decoder's End");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DecoderView.class.getResource("/resources/bulb-curvy-flat.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(211, 211, 211)));
		setContentPane(contentPane);
		
		JLabel lblEnterName = new JLabel("Enter Name : ");
		lblEnterName.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 21));
		
		textField = new JTextField();
		textField.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		textField.setColumns(10);
		
		JLabel lblEnterSeedkey = new JLabel("Enter Key :");
		lblEnterSeedkey.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 21));
		
		passwordField = new JPasswordField();

		passwordField.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		
		btnProceed = new JButton("Proceed");
		btnProceed.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 23));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(lblEnterName))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(27)
									.addComponent(lblEnterSeedkey)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(129)
							.addComponent(btnProceed, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterSeedkey)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(btnProceed, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	
	//to create events for the components
	public void createEvents() 
	{
		
		
		
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				key2 = passwordField.getPassword();
				
				EncoderView eh = new EncoderView();
				key1 = eh.key;
				
				
				//if(key1.equals(key2))
				//if(Arrays.equals(eh.passwordField.getPassword(),passwordField.getPassword()))
				{
					//JOptionPane.showMessageDialog(null, "Password matches!!");
					DecodeHere dh = new DecodeHere();
					dh.setVisible(true);
				}
				
				/**else
				{
					JOptionPane.showMessageDialog(null, "Your key doesn't match with the sender's key.");
				}**/
			}
		});

		
	}

}
