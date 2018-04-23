import javax.swing.JOptionPane;


public class Islemler {
	
	private String girdi1,girdi2,sonuc = "";
	private int deger1=0,deger2=0,onluk,onluk_tam;
	
	private char[] rakamlar = {'I','V','X','L','C','D','M'};
	private int[] degerler = {1,5,10,50,100,500,1000};
	private int[] tekrarlar1 = {0,0,0,0,0,0,0};
	private int[] tekrarlar2 = {0,0,0,0,0,0,0};
	
	
	public Islemler(){
	
	}
	
	// Setter Methods
	public void setGirdi1(String girdi1){
		this.girdi1 = girdi1;
	}
	public void setGirdi2(String girdi2){
		this.girdi2 = girdi2;
	}
	
	// Getter Methods
	public String getGirdi1(){
		return this.girdi1;
	}
	public String getGirdi2(){
		return this.girdi2;
	}
	

	// Girilen değerin doğru bir değer olup olmadığını kontrol eder ve doğru değerse 10'luk tabana çevirir.
	public boolean Hesaplama_Yapilabilir1(String girdi1){
		deger1=0;
		int i,j,temp=0;
		boolean a = false;
		//JOptionPane.showMessageDialog(null, girdi1);
		for(i=girdi1.length()-1;i>=0;i--){
			//JOptionPane.showMessageDialog(null, String.valueOf(deger1));
			for(j=0;j<=6;j++){
				if(a==false){
					temp = degerler[j];
					a = true;
				}
				//JOptionPane.showMessageDialog(null, String.valueOf(girdi1.charAt(i)+" - "+String.valueOf(rakamlar[j])));
				if(girdi1.charAt(i)==rakamlar[j]){
					//JOptionPane.showMessageDialog(null, String.valueOf(girdi1.charAt(i)+" - "+String.valueOf(rakamlar[j])));
					if(deger1!=0 && degerler[j]*10<deger1){
						deger1 = 0;
						return false;
					}
					else if(degerler[j]<temp){
						if(rakamlar[j]=='V' || rakamlar[j]=='L'){
							return false;
						}
						deger1-=degerler[j];	
						tekrarlar1[j]+=1;
						if(tekrarlar1[j]==4){
							return false;
						}
					}
					else{
						deger1 += degerler[j];
						tekrarlar1[j]+=1;
						if(tekrarlar1[j]==4){
							return false;
						}
					}
					temp = degerler[j];
					break;
				}
			}
		}
		//JOptionPane.showMessageDialog(null, String.valueOf(deger1));
		return true;
	}
	
	public boolean Hesaplama_Yapilabilir2(String girdi2){
		int i,j,temp=0;
		deger2=0;
		boolean a = false;
		//JOptionPane.showMessageDialog(null, String.valueOf(girdi1.length()));
		for(i=girdi2.length()-1;i>=0;i--){
			//JOptionPane.showMessageDialog(null, String.valueOf(deger1));
			for(j=0;j<=6;j++){
				if(a==false){
					temp = degerler[j];
					a = true;
				}
				//JOptionPane.showMessageDialog(null, String.valueOf(girdi1.charAt(i)+" - "+String.valueOf(rakamlar[j])));
				if(girdi2.charAt(i)==rakamlar[j]){
					//JOptionPane.showMessageDialog(null, String.valueOf(girdi1.charAt(i)+" - "+String.valueOf(rakamlar[j])));
					if(deger2!=0 && degerler[j]*10<deger2){
						deger2 = 0;
						return false;
					}
					else if(degerler[j]<temp){
						if(rakamlar[j]=='V' || rakamlar[j]=='L'){
							return false;
						}
						deger2-=degerler[j];	
						tekrarlar2[j]+=1;
						if(tekrarlar2[j]==4){
							return false;
						}
					}
					else{
						deger2 += degerler[j];
						tekrarlar2[j]+=1;
						if(tekrarlar2[j]==4){
							return false;
						}
					}
					temp = degerler[j];
					break;
				}
			}
		}
		//JOptionPane.showMessageDialog(null, String.valueOf(deger2));
		return true;
	}
	
	
	
	public int getOnluk(){
		return onluk_tam;
	}
	
	private void ASD(){
		deger1 = 0;
		deger2 = 0;
		int i;
		for(i=0;i<7;i++){
			tekrarlar1[i] = 0;
			tekrarlar2[i] = 0;
		}
	}
	
	public String getSonuc(){
		return sonuc;
	}
	
	
	// Yapılabilir işlemlerin olduğu kısım
	public void Topla(){
		onluk = deger1+deger2;
		onluk_tam = onluk;
		sonuc = ROMA();
		ASD();
	}
	public void Cikart(){
		if(deger1<deger2){
			sonuc = "Çıkartma yapılamıyor.";
			onluk_tam = deger1-deger2;
			ASD();
		}
		else{
			onluk = deger1-deger2;
			onluk_tam = onluk;
			sonuc = ROMA();
			ASD();
		}
		
	}
	public void Carp(){
		onluk = deger1*deger2;
		onluk_tam = onluk;
		sonuc = ROMA();ASD();
	}
	public void Bol(){
		onluk = deger1 / deger2;
		onluk_tam = onluk;
		sonuc = ROMA();ASD();
	}
	
	
	// Sayıyı Roma rakamına dönüştüren metot
	public String ROMA(){
		int i,j,x;
		String yeni = "";
		for(i=6;i>=0;i--){
			if(onluk==0){
				break;
			}
			x = onluk / degerler[i];	
					
			for(j=0;j<i;j++){
				if(onluk == degerler[i]-degerler[j]){
					if(Hesaplama_Yapilabilir1(yeni+String.valueOf(rakamlar[j])+String.valueOf(rakamlar[i]))){
						yeni += String.valueOf(rakamlar[j])+String.valueOf(rakamlar[i]);
						return yeni;
					}
					break;
				}
			}	
			for(j=0;j<x;j++){
				yeni+=rakamlar[i];
			}
			onluk = onluk%degerler[i];
		}
		return yeni;
	}	
}
