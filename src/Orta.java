import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
public class Orta extends JPanel{
	private JLabel bilgi,sonuc;
	public Orta(){
		this.setLayout(new GridLayout(1,2));
		this.setBackground(Color.DARK_GRAY);
		bilgi = new JLabel("   Hesaplanan Sonuc:   ",SwingConstants.RIGHT);
		bilgi.setForeground(Color.LIGHT_GRAY);
		
		
		sonuc = new JLabel("  Henüz işlem yapmadın.");
		sonuc.setForeground(Color.GREEN);
		
		this.add(bilgi);
		this.add(sonuc);
	}
		
	// Sonuc labelinin text ini değiştirir
	public void setSonuc(String s){
		sonuc.setText(s);
	}
	
	public JPanel getPanel(){
		return this;
	}
}
