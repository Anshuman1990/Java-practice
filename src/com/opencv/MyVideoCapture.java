package com.opencv;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class MyVideoCapture {
	VideoCapture capture;
	Mat mat = new Mat();
	
	public MyVideoCapture() {
		capture = new VideoCapture();
		capture.open(0);
	}
	static{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	

BufferedImage getOneFrame() {
	capture.read(mat);
    return Mat2BufferedImage(mat);
}

public static BufferedImage Mat2BufferedImage(Mat m)
{
    int type = BufferedImage.TYPE_BYTE_GRAY;
    if (m.channels() > 1)
    {
        type = BufferedImage.TYPE_3BYTE_BGR;
    }
    int bufferSize = m.channels()*m.cols()*m.rows();
    byte[] b = new byte[bufferSize];
    m.get(0, 0, b); // get all the pixels
    BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
    final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    System.arraycopy(b, 0, targetPixels, 0, b.length);  
    return image;
}

public static BufferedImage videoMat2BufferedImage(Mat mat){
	byte[] dat = null;
	BufferedImage img = null;
    int w = mat.cols(), h = mat.rows();
    if (dat == null || dat.length != w * h * 3)
        dat = new byte[w * h * 3];
    if (img == null || img.getWidth() != w || img.getHeight() != h
        || img.getType() != BufferedImage.TYPE_3BYTE_BGR)
            img = new BufferedImage(w, h, 
                        BufferedImage.TYPE_3BYTE_BGR);
    mat.get(0, 0, dat);
    img.getRaster().setDataElements(0, 0, 
                       mat.cols(), mat.rows(), dat);
return img;

}
public static void displayImage(Image img)
{   
    ImageIcon icon = new ImageIcon(img);
    JFrame frame = new JFrame();
    frame.setLayout(new FlowLayout());        
    frame.setSize(img.getWidth(null)+50, img.getHeight(null)+50);     
    JLabel lbl = new JLabel();
    lbl.setIcon(icon);
    frame.add(lbl);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}
