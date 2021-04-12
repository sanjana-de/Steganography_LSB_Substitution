package common; 

//import javax.swing.SwingUtilities;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
//import 
public class SwingOpenImage 
{
	private JFrame frame;
	//constructing frame
	public SwingOpenImage(String filepath)
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				frame = new JFrame(filepath);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				BufferedImage img = null;
				try {
					img= ImageIO.read(new File(filepath));
				} catch (Exception e) {
					e.printStackTrace();
				}
				//putting icons directly in labels
				JLabel lbl = new JLabel();
				lbl.setIcon(new ImageIcon(img));
				frame.getContentPane().add(lbl, BorderLayout.CENTER);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			
		});

}
	
	public SwingOpenImage() {
		
		
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		new SwingOpenImage("G:\\workspace\\1stt\\src\\common\\steg.png");
	}
}

	