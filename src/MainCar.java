import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MainCar extends JPanel{
	
	public int x = 220, y=340; 

	
	BufferedImage buffCar;
	String carPath;
	public MainCar() {

		this.carPath = "/image/car.PNG";

		try {
			
			buffCar = ImageIO.read(getClass().getResource(this.carPath));

			
		} catch (IOException e) {			
			System.out.println("Can not load Image");
			e.printStackTrace();			
		}
		
		this.setFocusable(true);
        this.requestFocusInWindow();

	}
	

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(buffCar, x, y, 40, 75, null);	
	
	}


	
}














