package common;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Canvas;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

public class welcomepage extends JFrame {

	private JPanel contentPane;
	private JButton btnEncode;
	private JButton btnDecode;
	private final JLabel label = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcomepage frame = new welcomepage();
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
	public welcomepage() 
	{
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 204));		
		initComponents();
		createEvents();
		
	}

	//methods to initialize components
	private void initComponents() 
	{
		
		setTitle("Welcome Page");
		setIconImage(Toolkit.getDefaultToolkit().getImage(welcomepage.class.getResource("/common/bulb-curvy-flat.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(153, 0, 51)));
		setContentPane(contentPane);
		
		
		JLabel lblWelcome = new JLabel("Welcome to the Home Page");
		lblWelcome.setToolTipText("");
		lblWelcome.setLabelFor(this);
		lblWelcome.setBackground(new Color(255, 255, 255));
		lblWelcome.setForeground(new Color(255, 204, 255));
		lblWelcome.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 24));
		
		
		JPanel login = new JPanel();
		   login.setLayout(null);
		   login.setSize(400, 350);
		   login.setBackground(new Color(255,255,255,70));
		   login.setBounds(250, 175, 400, 350);

	    JLabel lblDoYouWant = new JLabel("Do you wish to encode or decode?");
		lblDoYouWant.setForeground(new Color(204, 255, 255));
		lblDoYouWant.setBackground(new Color(255, 255, 255));
		lblDoYouWant.setBounds(45, 50, 300, 50);
		lblDoYouWant.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 22));
		
		btnEncode = new JButton("Encode");
		btnEncode.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 20));
		btnEncode.setBackground(new Color(250, 235, 215));

		btnDecode = new JButton("Decode");
		btnDecode.setBackground(new Color(250, 235, 215));
		btnDecode.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 20));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(btnEncode, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDecode, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDoYouWant, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(403, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWelcome))
					.addGap(29)
					.addComponent(lblDoYouWant)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEncode)
						.addComponent(btnDecode))
					.addGap(45))
		);
		contentPane.setLayout(gl_contentPane);
	}

	//method to create events for the components
	private void createEvents() 
	{
		btnDecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "You are being taken to the Decoder's Page");
				DecoderView dv = new DecoderView();
				dv.setVisible(true);
			}
		});
		
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "You are being taken to the Encoder's Page");
				EncoderView ev = new EncoderView();
				ev.setVisible(true);
			}
		});
	}
}
