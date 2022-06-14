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
            System.out.println("Exception caught : "+ex.getMessage());
       }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);          
    }
}