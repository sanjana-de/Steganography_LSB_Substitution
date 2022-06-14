package common;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class DecodeHere extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnDecode;
	private JButton btnFinish;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecodeHere frame = new DecodeHere();
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
	public DecodeHere() 
	{
		setTitle("Decoding Image");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DecodeHere.class.getResource("/resources/bulb-curvy-flat.png")));
		initComponents();
		createEvents();
	
	}

	//to initialize components
	private void initComponents() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(250, 250, 210)));
		setContentPane(contentPane);
		
		JLabel lblDoYouWish = new JLabel("Do you wish to decode the secret message?");
		lblDoYouWish.setForeground(new Color(0, 0, 0));
		lblDoYouWish.setBackground(new Color(60, 179, 113));
		lblDoYouWish.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 24));
		
		btnDecode = new JButton("Decode");
		btnDecode.setForeground(new Color(0, 128, 0));
		btnDecode.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 24));

		
		JLabel lblDecodedText = new JLabel("Decoded text :");
		lblDecodedText.setForeground(new Color(25, 25, 112));
		lblDecodedText.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 245, 238));
		textField.setForeground(new Color(0, 0, 139));
		textField.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 21));
		textField.setEditable(false);
		textField.setColumns(10);
		
		btnFinish = new JButton("Finish");
		btnFinish.setForeground(new Color(0, 128, 0));
		btnFinish.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 24));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(52)
								.addComponent(lblDoYouWish))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblDecodedText)
								.addGap(58)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(41)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(245)
							.addComponent(btnDecode))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(258)
							.addComponent(btnFinish)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(lblDoYouWish)
					.addGap(52)
					.addComponent(btnDecode)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDecodedText))
					.addGap(59)
					.addComponent(btnFinish)
					.addGap(34))
		);
		contentPane.setLayout(gl_contentPane);

		
	}

	//to create events for the components
	private void createEvents() 
	{
		

		
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		// The decoding code to be linked here
		
		btnDecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					LSB_decode.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Your message has been decoded!");
				String s= LSB_decode.msg;
				if(s.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "No message has been encoded");
					textField.setText(null);
				}
				
				else
				textField.setText(s);
				
			}
		});	
	}

}
