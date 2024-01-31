package com.practice.java8_17.opencv;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

public class Main {




public static void main(String[] args) throws IOException {
	OpenCV.loadShared();
//	String dir = System.getProperty("user.dir")+"\\Dataset";
//	Files.list(Paths.get(dir)).forEach(new Consumer<Path>() {
//
//		@Override
//		public void accept(Path t) {
//			System.out.println("^^"+t.toString());
//			
//		}
//	});
	Mat mat = new Mat();
	mat = Imgcodecs.imread("D:\\images\\face_neutral.jpg");
//	displayImage(Mat2BufferedImage(mat),"Normal");
//	Mat greyscale = new Mat();
//	Imgproc.Canny(mat, greyscale, 220, 225, 3, false);
//	displayImage(Mat2BufferedImage(greyscale), "Canny");
	Main main = new Main();
	main.extractFaces(mat);
}

public static void displayImage(Image img2,String name)
{  
    //BufferedImage img=ImageIO.read(new File("/HelloOpenCV/lena.png"));
    ImageIcon icon=new ImageIcon(img2);
    JFrame frame=new JFrame();
    frame.setTitle(name);
    frame.setLayout(new FlowLayout());        
    frame.setSize(img2.getWidth(null)+50, img2.getHeight(null)+50);     
    JLabel lbl=new JLabel();
    lbl.setIcon(icon);
    frame.add(lbl);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

public static BufferedImage Mat2BufferedImage(Mat m){
	// source: http://answers.opencv.org/question/10344/opencv-java-load-image-to-gui/
	// Fastest code
	// The output can be assigned either to a BufferedImage or to an Image

	    int type = BufferedImage.TYPE_BYTE_GRAY;
	    if ( m.channels() > 1 ) {
	        type = BufferedImage.TYPE_3BYTE_BGR;
	    }
	    int bufferSize = m.channels()*m.cols()*m.rows();
	    byte [] b = new byte[bufferSize];
	    m.get(0,0,b); // get all the pixels
	    BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
	    final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	    System.arraycopy(b, 0, targetPixels, 0, b.length);  
	    return image;

	}

private static void startEmotionsDetection(Mat inputimage)
{
	
}

private void extractFaces(Mat inputimage) {
	String path = System.getProperty("user.dir");
	System.out.println("Path= "+path);
	CascadeClassifier faceDet = new CascadeClassifier();
	CascadeClassifier faceDet_two = new CascadeClassifier();
	CascadeClassifier faceDet_three = new CascadeClassifier();
	CascadeClassifier faceDet_four = new CascadeClassifier();
	
	boolean check1 = faceDet.load("D:\\PracticeWorkspace\\Java Practice\\src\\Dataset\\haarcascades\\haarcascade_frontalface_default.xml");
	boolean check2 = faceDet_two.load("D:\\PracticeWorkspace\\Java Practice\\src\\Dataset\\haarcascades\\haarcascade_frontalface_alt2.xml");
	boolean check3 = faceDet_three.load("D:\\PracticeWorkspace\\Java Practice\\src\\Dataset\\haarcascades\\haarcascade_frontalface_alt.xml");
	boolean check4 = faceDet_four.load("D:\\PracticeWorkspace\\Java Practice\\src\\Dataset\\haarcascades\\haarcascade_frontalface_alt_tree.xml");

	Mat greyscale = inputimage.clone();
	Imgproc.cvtColor(inputimage, greyscale, Imgproc.COLOR_BGR2GRAY);
//	displayImage(Mat2BufferedImage(greyscale), "Grey Scale");
	String[] emotions = {"neutral", "anger", "contempt", "disgust", "fear", "happy", "sadness", "surprise"};
	MatOfRect rect1 = new MatOfRect();
	MatOfRect rect2 = new MatOfRect();
	MatOfRect rect3 = new MatOfRect();
	MatOfRect rect4 = new MatOfRect();
	
	if(check1) {
		faceDet.detectMultiScale(greyscale, rect1, 1.1, 10,Objdetect.CASCADE_SCALE_IMAGE , new Size(5, 5), greyscale.size());
		faceDet_two.detectMultiScale(greyscale, rect2, 1.1, 10,Objdetect.CASCADE_SCALE_IMAGE , new Size(5, 5), greyscale.size());
		faceDet_three.detectMultiScale(greyscale, rect3, 1.1, 10,Objdetect.CASCADE_SCALE_IMAGE , new Size(5, 5), greyscale.size());
		faceDet_four.detectMultiScale(greyscale, rect4, 1.1, 10,Objdetect.CASCADE_SCALE_IMAGE , new Size(5, 5), greyscale.size());
	}
	
	
	System.out.println("rect1= "+rect1);
	System.out.println("rect2= "+rect2);
	System.out.println("rect3= "+rect3);
	System.out.println("rect4= "+rect4);
	
	for(Rect rect:rect1.toArray()) {
		Imgproc.rectangle(greyscale, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                new Scalar(0, 255, 0));
	}
	Mat resized = new Mat();
	Imgproc.resize(greyscale, resized, new Size(350,350));
	displayImage(Mat2BufferedImage(resized), "Canny");
	Imgcodecs.imwrite("out.jpg", resized);
}

public void createSet() {
	
}
}
