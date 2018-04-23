
import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
public class Alt extends JPanel{
	private JLabel isim , uni;
	public Alt(){
		this.setLayout(new GridLayout(2,1));
		this.setBackground(Color.BLACK);
		isim = new JLabel("   Şerif İnanır - 160204057 - sinanir.com",SwingConstants.CENTER);
		isim.setForeground(Color.RED);
		uni = new JLabel("   Alanya Alaaddin Keykubat Üniversitesi",SwingConstants.CENTER);
		uni.setForeground(Color.RED);
		this.add(isim);
		this.add(uni);
	}
	public JPanel getPanel(){
		return this;
	}
}
