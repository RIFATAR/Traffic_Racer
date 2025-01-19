import javax.swing.JFrame;



public class MainFrame extends JFrame{
		

	MainPanel mainPanel;


	
	
	public MainFrame() {

		this.setSize(400, 550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)	;		
		
		

		
		this.mainPanel = new MainPanel();
		this.add(this.mainPanel);
		
	
	}
	
	
	


}

