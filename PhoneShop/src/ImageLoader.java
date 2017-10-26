
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class ImageLoader {
    
    public static ImageIcon importImage(String url, int width, int height) {
        try {
            BufferedImage bi = ImageIO.read(new File(url));
            Image img = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void attachImage(String url, JLabel label) {
        label.setIcon(importImage(url, label.getWidth(), label.getHeight()));
    }
    
    public static void attachImageFitWidth(String url, JLabel label) {
        label.setIcon(importImage(url, label.getWidth(), -1));
    }
    
    public static void attachImageFitHeight(String url, JLabel label) {
        label.setIcon(importImage(url, -1, label.getHeight()));
    }
    
    public static void smartAttaching(String url, JLabel label) {
        try {
            BufferedImage bi = ImageIO.read(new File(url));
            double imgRatio = 1.0*bi.getWidth()/bi.getHeight();
            double lblRatio = 1.0*label.getWidth()/label.getHeight();
            int w, h;
            if (imgRatio > lblRatio) {
                if (bi.getWidth() < label.getWidth()) w = -1;
                else w = label.getWidth();
                h = -1;
            } else {
                w = -1;
                if (bi.getHeight() < label.getHeight()) h = -1;
                else h = label.getHeight();
            }
            Image img = bi.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
