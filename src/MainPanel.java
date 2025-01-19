import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





public class MainPanel extends JPanel implements MouseListener{

		int flag;
		boolean collision = false;
		int score;
		int highScore;
		
		
		BufferedImage startImage;
		String startP;
		
		int x = 220, y=338; 
		int a=-90,b=-440,c=-660,d=-20,e=-340,f=-660;
		int m=-45,h=-220,i=-660,j=-20,k=-340,l=-660;
		public int sx1=0, sy1=300, sx2, sy2; 
		
		
		MainCar car;
		
		BufferedImage buffImage,buffCar,buffCar1,buffCar2,buffCar3,buffCar4,buffCar5,buffCar6,buffCar7;
		String path,carPath,car1,car2,car3,car4,car5,car6,car7;
		BufferedImage buffCar01,buffCar02,buffCar03,buffCar04,buffCar05,buffCar06,buffCar07;
		String car01,car02,car03,car04,car05,car06,car07;
	
		public Rectangle playBtn =new Rectangle(125,160,135,50);
		public Rectangle scoreBtn =new Rectangle(115,260,150,50);
		public Rectangle quitBtn =new Rectangle(140,360,100,50);
		
		
		
		public MainPanel() {
			
			addLisToPanel();
			this.setFocusable(true);
	        this.requestFocusInWindow();
	        this.addMouseListener(this);
	        
	        
	        
	        this.startP = "/image/startPage.png";
	        this.path = "/image/roadMain.png";
	        this.carPath="image/car.PNG";
			this.car1="/image/blueCar.png";
			this.car2="/image/orangeCar.png";
			this.car3="/image/yellowCar.png";
			this.car4="/image/greenCar.png";
			this.car5="/image/darkBlueCar.png";
			this.car6="/image/whiteCar.png";
			this.car7="/image/lightBlueCar.png";
			this.car01="/image/blueCar 01.png";
			this.car02="/image/orangeCar02.png";
			this.car03="/image/yellowCar03.png";
			this.car04="/image/greenCar04.png";
			this.car05="/image/darkBlueCar05.png";
			this.car06="/image/whiteCar06.png";
			this.car07="/image/lightBlueCar07.png";
			
			
			
			try {
				startImage = ImageIO.read(getClass().getResource(this.startP));
				buffImage = ImageIO.read(getClass().getResource(this.path));
				
				buffImage.getWidth();
				sx2= buffImage.getHeight();
				sy2= buffImage.getHeight();
				buffCar  = ImageIO.read(getClass().getResource(this.carPath));
				buffCar1 = ImageIO.read(getClass().getResource(this.car1));
				buffCar2 = ImageIO.read(getClass().getResource(this.car2));
				buffCar3 = ImageIO.read(getClass().getResource(this.car3));
				buffCar4 = ImageIO.read(getClass().getResource(this.car4));
				buffCar5 = ImageIO.read(getClass().getResource(this.car5));
				buffCar6 = ImageIO.read(getClass().getResource(this.car6));
				buffCar7 = ImageIO.read(getClass().getResource(this.car7));
				buffCar01 = ImageIO.read(getClass().getResource(this.car01));
				buffCar02 = ImageIO.read(getClass().getResource(this.car02));
				buffCar03 = ImageIO.read(getClass().getResource(this.car03));
				buffCar04 = ImageIO.read(getClass().getResource(this.car04));
				buffCar05 = ImageIO.read(getClass().getResource(this.car05));
				buffCar06 = ImageIO.read(getClass().getResource(this.car06));
				buffCar07 = ImageIO.read(getClass().getResource(this.car07));
				
			} catch (IOException e) {			
				System.out.println("Can not load Image");
				e.printStackTrace();			
			}
			
			this.car = new MainCar();
			addLisToPanel();
			this.setFocusable(true);
	        this.requestFocusInWindow();      
		}
		
		
		
		
		public void reset(){
			x = 220; y=338; 
			a=-90;b=-440;c=-660;d=-20;e=-340;f=-660;
			m=-45;h=-220;i=-660;j=-20;k=-340;l=-660;
			sx1=0; sy1=300; sx2= buffImage.getHeight();
			sy2= buffImage.getHeight();
		}
		
		
		private void addLisToPanel() {
			this.addKeyListener(new KeyListener() {		
				
				public void keyTyped(KeyEvent e) {
				}
				public void keyReleased(KeyEvent e) {	
				}
				
				public void keyPressed(KeyEvent e) {
					System.out.println(e.getKeyChar());
					int code = e.getKeyCode();
					if(code==KeyEvent.VK_UP){
						System.out.println("Up arrow");
				
					}else if(code==KeyEvent.VK_DOWN){

						
					}else if(code == KeyEvent.VK_LEFT){
						System.out.println("left arrow");
						if(x>95){
						x-=5; car.repaint();
						}
						
					}else if(code == KeyEvent.VK_RIGHT){
						System.out.println("right arrow");
						if(x<248){
							x+=5; car.repaint();
						}
						
					}else if(code==KeyEvent.VK_SPACE){
						System.out.println("Space");
					}
					else if(code==KeyEvent.VK_ESCAPE){
						System.out.println("Escape");
						if(flag==1){
						flag=2;
						collision=true;
						repaint();
						}
					}
					
				}
			});		
		}
		
		





		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(flag==0){
				g.drawImage(startImage, 0, 0, this.getWidth(), this.getHeight(), null);
				Font fnt0 = new Font("arial",Font.BOLD,50);
				g.setFont(fnt0);
				g.setColor(Color.WHITE);
				g.drawString("Traffic Racer",50 ,50);
			

				Graphics2D g2d = (Graphics2D) g;
			
				Font fnt1 = new Font("arial",Font.BOLD,25);
				g.setFont(fnt1);
			
				g2d.draw(playBtn);
				g.drawString("Play",playBtn.x+35 ,playBtn.y+30);
				g2d.draw(scoreBtn);
				g.drawString("High Score",scoreBtn.x+10 ,scoreBtn.y+30);
				g2d.draw(quitBtn);
				g.drawString("Quit",quitBtn.x+19 , quitBtn.y+30);
				}
			if(flag==1){
				
				if(sy1>0){
					g.drawImage(buffImage, 0, 0, this.getWidth()+168, this.getHeight(), sx1, sy1, sx2, sy2, null);		
					g.drawImage(buffCar, x, y, 40, 75, null);
					score++;
					
					Font fnt = new Font("arial",Font.BOLD,25);
					g.setFont(fnt);
					g.setColor(Color.RED);	
					g.drawString("Score",310,45);
					g.drawString(Integer.toString(score),310 ,70);
					}

				if(sy1==0){
					sy1=300; sy2=587;
					g.drawImage(buffImage, 0, 0, this.getWidth()+168, this.getHeight(), sx1, sy1, sx2, sy2, null);
					g.drawImage(buffCar, x, y, 40, 75, null);
					score++;
					Font fnt = new Font("arial",Font.BOLD,25);
					g.setFont(fnt);
					g.setColor(Color.RED);
					g.drawString("Score",310,45);
					g.drawString(Integer.toString(score),310 ,70);
					}
					
					
				if(a>-95 && a<1050){
					g.drawImage(buffCar1, 98, a, 40, 75, null);
					a+=6;
					g.drawImage(buffCar2, 140, b, 40, 75, null);
					b+=10;
					g.drawImage(buffCar3, 98, c, 40, 75, null);
					c+=8;
					}
				if(a==1050 && f<490){
					g.drawImage(buffCar4, 98, d, 40, 75, null);
					d+=6;
					g.drawImage(buffCar5, 140, e, 40, 75, null);
					e+=6;
					g.drawImage(buffCar6, 98, f, 40, 75, null);
					f+=8;
					}
				if(f==492 && a==1050){
						d=-45; b=-220; c=-660; e=-660; f++;
					}
				if(f>492 && a==1050){
						g.drawImage(buffCar4, 98, d, 40, 75, null);
						d+=5;
						g.drawImage(buffCar2, 140, b, 40, 75, null);
						b+=5;							
						g.drawImage(buffCar5, 140, e, 40, 75, null);
						e+=25;
						
						}


				if(m>-95 && m<1050){
						g.drawImage(buffCar01, 197, m, 40, 75, null);
						m+=3;
						g.drawImage(buffCar02, 239, h, 40, 75, null);
						h+=3;
						g.drawImage(buffCar03, 197, i, 40, 75, null);
						i+=4;
						}
				if(m==1050 && l<490){
						g.drawImage(buffCar04, 197, j, 40, 75, null);
						j+=5;
						g.drawImage(buffCar05, 239, k, 40, 75, null);						
						k+=7;
						g.drawImage(buffCar06, 197, l, 40, 75, null);
						l+=9;
						}
						

				if(l>=490 && m==1050){
						m=-45; h=-220; i=-660;
						g.drawImage(buffCar01, 197, m, 40, 75, null);
						m+=5;
						g.drawImage(buffCar02, 239, h, 40, 75, null);
						h+=5;							
						g.drawImage(buffCar03, 197, i, 40, 75, null);
						i+=55;
						}

				
				}
			
			
			if(flag==2){
				g.drawImage(startImage, 0, 0, this.getWidth(), this.getHeight(), null);
				Font fnt0 = new Font("arial",Font.BOLD,50);
				g.setFont(fnt0);
				g.setColor(Color.WHITE);
				g.drawString("Traffic Racer",50 ,80);
				

				Graphics2D g2d = (Graphics2D) g;
				
				Font fnt1 = new Font("arial",Font.BOLD,25);
				g.setFont(fnt1);
				
				g2d.draw(playBtn);
				g.drawString("Resume",playBtn.x+5 ,playBtn.y+30);
				g2d.draw(scoreBtn);
				g.drawString("High Score",scoreBtn.x+10 ,scoreBtn.y+30);
				g2d.draw(quitBtn);
				g.drawString("Quit",quitBtn.x+19 , quitBtn.y+30);
				}
			
			
			if(collision==true && flag!=2){
				g.drawImage(startImage, 0, 0, this.getWidth(), this.getHeight(), null);
				Font fnt0 = new Font("arial",Font.BOLD,50);
				g.setFont(fnt0);
				g.setColor(Color.WHITE);
				g.drawString("Traffic Racer",50 ,50);
				
				Graphics2D g2d = (Graphics2D) g;
				
				Font fnt1 = new Font("arial",Font.BOLD,25);
				g.setFont(fnt1);
				
				
				g.drawString("Your Score",playBtn.x ,playBtn.y-60);
				g.drawString(Integer.toString(score),playBtn.x+35 ,playBtn.y-30);
				highScore();
				score=0;
				
				
				g2d.draw(playBtn);
				g.drawString("Play Again",playBtn.x+5 ,playBtn.y+30);
				g2d.draw(scoreBtn);
				g.drawString("High Score",scoreBtn.x+10 ,scoreBtn.y+30);
				g2d.draw(quitBtn);
				g.drawString("Quit",quitBtn.x+19 , quitBtn.y+30);
				}

		}
	

		
		public void collision(){
			Rectangle rect = new Rectangle(x,y,30,65);
			Rectangle rect1 = new Rectangle(98,a,35,65);
			Rectangle rect2 = new Rectangle(140,b,35,65);
			Rectangle rect3 = new Rectangle(98,c,35,65);
			Rectangle rect4 = new Rectangle(98,d,35,65);
			Rectangle rect5 = new Rectangle(140,e,35,65);
			Rectangle rect6 = new Rectangle(98,f,35,65);
			Rectangle rect01 = new Rectangle(197,m,35,65);
			Rectangle rect02 = new Rectangle(239,h,35,65);
			Rectangle rect03 = new Rectangle(197,i,35,65);
			Rectangle rect04 = new Rectangle(197,j,35,65);
			Rectangle rect05 = new Rectangle(239,k,35,65);
			Rectangle rect06 = new Rectangle(197,l,35,65);
			

			if(rect.intersects(rect1)){
				collision=true;
				reset();
				System.out.println("collision");
			}
			else if(rect.intersects(rect2)){
				collision=true;
				reset();
				System.out.println("collision");
			} 
			else if(rect.intersects(rect3)){
				collision=true;
				reset();
				System.out.println("collision");
			}
			else if(rect.intersects(rect4)){
				collision=true;
				reset();
				System.out.println("collision");
			}
			else if(rect.intersects(rect5)){
				collision=true;
				reset();
				System.out.println("collision");
			}
			else if(rect.intersects(rect6)){
				collision=true;
				reset();
				System.out.println("collision");
			}	
			else if(rect.intersects(rect01)){
				collision=true;
				reset();
				System.out.println("collision");
			}
			else if(rect.intersects(rect02)){
				collision=true;
				reset();
				System.out.println("collision");
			} 
			else if(rect.intersects(rect03)){
				collision=true;
				reset();
				System.out.println("collision");
			}
			else if(rect.intersects(rect04)){
				collision=true;
				reset();
				System.out.println("collision");
			}
			else if(rect.intersects(rect05)){
				collision=true;
				reset();
				System.out.println("collision");
			}
			else if(rect.intersects(rect06)){
				collision=true;
				reset();
				System.out.println("collision");
			}	
			else 
				collision= false;
		}


		
		
		
		public void mouseClicked(MouseEvent e) {			
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		
		
		public void mousePressed(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();

			if(mx >= 125 && mx <= 260){
				if(my >= 160 && my<= 210 ){	
			   flag=1;
			   collision=false;
			   repaint();
			  
			   Thread t = new Thread(new Runnable() {
					

					public void run() {
						while(!collision){
							sy1 -=5;
							sy2 -=5;
							collision();
							repaint();
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
					}
				});
			   
			   
			   	t.start();
			   	
			   }
				
			}

			if(mx >= 115 && mx <= 265){
				if(my >=260 && my <= 310 ){
					try{
						FileReader fr =new FileReader("highScore.txt");
						BufferedReader br = new BufferedReader(fr);
						String str;
						while((str = br.readLine()) != null){
							JOptionPane.showMessageDialog(this,str,"High Score",JOptionPane.PLAIN_MESSAGE);
						}
						
						
						
						
						br.close();
					}catch(IOException f){
						System.out.println("File not found");
					}
					
				}
			}
			if(mx >= 140 && mx <= 240){
				if(my >= 360 && my<= 410 ){
					System.exit(1);
				}
			}
		}





		public void mouseReleased(MouseEvent e) {	
		}
		
		
		public void highScore(){
			try{
				FileReader fr =new FileReader("highScore.txt");
				BufferedReader br = new BufferedReader(fr);
				String str;
				while((str = br.readLine()) != null){
					highScore=Integer.valueOf(str);
				}
				
				
				
				
				br.close();
			}catch(IOException f){
				System.out.println("File not found");
			}
			if(score>highScore){
				
				try{
				FileWriter fw =new FileWriter("highScore.txt");
				PrintWriter pw = new PrintWriter(fw);
				
				pw.println(Integer.toString(score));
				
				pw.close();
				
				}catch(IOException e){
					System.out.println("Error");
				}	
				
			}
		}

		


}
