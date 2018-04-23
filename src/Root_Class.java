
import javax.swing.*;
import java.awt.*;

public class Root_Class  extends JFrame{

	
	private Alt alt_kisim = new Alt();
	private Orta orta_kisim = new Orta();
	private Ust ust_kisim = new Ust(orta_kisim);
	
	public static void main(String[] args) {
		Root_Class rc = new Root_Class();
	}
	
	public Root_Class(){
		this.setSize(755, 450);
		this.setTitle("Roma Rakamları");
		addPanels();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
	}
	
	private void addPanels(){
		this.add(ust_kisim.getPanel(),BorderLayout.PAGE_START);
		this.add(alt_kisim.getPanel(),BorderLayout.PAGE_END);
		this.add(orta_kisim.getPanel(),BorderLayout.CENTER);
	}

}
