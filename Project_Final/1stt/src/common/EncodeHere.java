package common;
import java.io.*;

import common.LSB_encode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.MatteBorder;
import java.awt.*;

public class EncodeHere extends JFrame {

	private JPanel contentPane;
	private JButton btnEncode;
	private JButton btnNext;
	private JButton btnShowStegoImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncodeHere frame = new EncodeHere();
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
	public EncodeHere() 
	{
		
		initComponents();
		createEvents();
		
	
	}

	
	//initializing the components
	public void initComponents() 
	{

		setTitle("Encoding Image");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EncodeHere.class.getResource("/resources/bulb-curvy-flat.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(250, 240, 230)));
		setContentPane(contentPane);
		
		JLabel lblqstn = new JLabel("Do you wish to encode the existing message within the supplied image?");
		lblqstn.setForeground(new Color(139, 0, 0));
		lblqstn.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 24));
		lblqstn.setHorizontalAlignment(SwingConstants.CENTER);
		lblqstn.setBackground(new Color(173, 255, 47));
		
		btnEncode = new JButton("Encode");
		btnEncode.setForeground(new Color(0, 0, 139));
		btnEncode.setBackground(new Color(250, 235, 215));
		btnEncode.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 24));
		
		
		btnNext = new JButton("Next");
		btnNext.setForeground(new Color(0, 128, 128));
		btnNext.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 20));
		
		btnShowStegoImage = new JButton("Show Stego Image");
		btnShowStegoImage.setForeground(new Color(0, 128, 128));
		btnShowStegoImage.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 21));

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addComponent(btnShowStegoImage, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addGap(283)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(92, Short.MAX_VALUE))
				.addComponent(lblqstn, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(343, Short.MAX_VALUE)
					.addComponent(btnEncode, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(323))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblqstn, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(btnEncode, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShowStegoImage, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	public void createEvents() 
	{
		
		btnShowStegoImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				

				SwingOpenImage sp = new SwingOpenImage();
				SwingOpenImage.main(null);
				
				
			}
		});
		
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DecoderView dv = new DecoderView();
				dv.setVisible(true);
			}
		});
		
		
		
		
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try {
					LSB_encode.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Your mesage has been encoded within the given image!");
			}
		});
		// actual code to be called from here somewhere
		
	}

}
