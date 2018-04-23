
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ust extends JPanel{
	
	private JLabel bir,iki,bilgi;
	private JTextField birinci,ikinci;
	private JButton topla,cikar,carp,bol;
	private JPanel islemler = new JPanel();
	private Islemler islem = new Islemler();
	private Orta orta_kisim;
	
	public Ust(Orta o){
		this.setLayout(new GridLayout(3,2));
		this.setBackground(Color.BLACK);
		orta_kisim = o;
		addComp();
	}
	
	// Arayüz elemanlarının eklendiği metot
	private void addComp(){
		bir = new JLabel("Birinci Rakam: ",SwingConstants.CENTER);
		bir.setForeground(Color.RED);
		this.add(bir);
		
		birinci = new JTextField(7);
		this.add(birinci);
		
		iki = new JLabel("İkinci Rakam: ",SwingConstants.CENTER);
		iki.setForeground(Color.RED);
		this.add(iki);
		
		ikinci = new JTextField(7);
		this.add(ikinci);
		
		bilgi = new JLabel("İşlemler: ",SwingConstants.CENTER);
		bilgi.setForeground(Color.WHITE);
		this.add(bilgi);
		
		islemlerComp();
		ButtonListeners();
	}
	
	private void islemlerComp(){
		islemler.setLayout(new GridLayout(1,4));
		topla = new JButton("+");
		islemler.add(topla);
		cikar = new JButton("-");
		islemler.add(cikar);
		carp = new JButton("x");
		islemler.add(carp);
		bol = new JButton("/");
		islemler.add(bol);
		this.add(islemler);
	}
	
	// Getter metotlar
	public String getText1(){
		return birinci.getText();
	}
	public String getText2(){
		return ikinci.getText();
	}
	
	// Yazı girdilerini temizleyen metot
	private void clearTextFields(){
		birinci.setText("");
		ikinci.setText("");
	}
	
	// Düğme dinleyicileri
	private void ButtonListeners(){
		topla.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  if(textGirildi()==true){
	    		  if(islem.Hesaplama_Yapilabilir1(birinci.getText()) && islem.Hesaplama_Yapilabilir2(ikinci.getText())){
	    			  islem.Topla();
	    			  orta_kisim.setSonuc(birinci.getText()+" + "+ikinci.getText()+" = "+islem.getSonuc()+" ("+islem.getOnluk()+")");
	    		  }
	    		  else{
	    			  JOptionPane.showMessageDialog(null, "Girdiğiniz rakamlarla bu işlem yapılamaz.");
	    		  }
	    	  }
	    	  
	      }
	    });
		
		cikar.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  if(textGirildi()==true){
	    		  if(islem.Hesaplama_Yapilabilir1(birinci.getText()) && islem.Hesaplama_Yapilabilir2(ikinci.getText())){
	    			  islem.Cikart();
	    			  orta_kisim.setSonuc(birinci.getText()+" - "+ikinci.getText()+" = "+islem.getSonuc()+" ("+islem.getOnluk()+")");
	    		  }
	    		  else{
	    			  JOptionPane.showMessageDialog(null, "Girdiğiniz rakamlarla bu işlem yapılamaz.");
	    		  }
	    	  }
	      }
	    });
		
		carp.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  if(textGirildi()==true){
	    		  if(islem.Hesaplama_Yapilabilir1(birinci.getText()) && islem.Hesaplama_Yapilabilir2(ikinci.getText())){
	    			  islem.Carp();
	    			  orta_kisim.setSonuc(birinci.getText()+" * "+ikinci.getText()+" = "+islem.getSonuc()+" ("+islem.getOnluk()+")");
	    		  }
	    		  else{
	    			  JOptionPane.showMessageDialog(null, "Girdiğiniz rakamlarla bu işlem yapılamaz.");
	    		  }
	    	  }
	      }
	    });
		
		bol.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  if(textGirildi()==true){
	    		  if(islem.Hesaplama_Yapilabilir1(birinci.getText()) && islem.Hesaplama_Yapilabilir2(ikinci.getText())){
	    			  islem.Bol();
	    			  orta_kisim.setSonuc(birinci.getText()+" / "+ikinci.getText()+" = "+islem.getSonuc()+" ("+islem.getOnluk()+")");
	    		  }
	    		  else{
	    			  JOptionPane.showMessageDialog(null, "Girdiğiniz rakamlarla bu işlem yapılamaz.");
	    		  }
	    	  }
	      }
	    });
		clearTextFields();
	}
	
	// TextField'ler boş mu diye bakar.
	private boolean textGirildi(){
		if(birinci.getText().equals("") || ikinci.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Boş alan bıraktın.\nİşlem yapabilmek için 2 girdi girmelisin.","Hatalı Girdi",2);
			clearTextFields();
			return false;
		}
		//clearTextFields();
		return true;
	}
	
	// Bu sınıfın, ana sınıfta layout a eklenmesi için
	public JPanel getPanel(){
		return this;
	}
	
}
