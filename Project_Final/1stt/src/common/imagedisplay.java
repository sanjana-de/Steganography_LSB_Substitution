package common;

import java.io.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class imagedisplay extends JPanel{

    private BufferedImage image;

    public imagedisplay() {
       try {                
          image = ImageIO.read(new File("G:\\workspace\\1stt\\src\\common\\cover.jpg"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}




/**port java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.net.URL;
//from   ww  w . j a v a 2  s  . co m
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class imagedisplay {

	  public static void main(String avg[]) throws Exception 
	  {
	    BufferedImage img = ImageIO.("cover.jpg");
	    ImageIcon icon = new ImageIcon(img);
	    JFrame frame = new JFrame();
	    frame.setLayout(new FlowLayout());
	    frame.setSize(200, 300);
	    JLabel lbl = new JLabel();
	    lbl.setIcon(icon);
	    frame.add(lbl);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
	}**/