package cmSerializable;

import java.io.Serializable;

public class ObjetSimple implements Serializable{
	
	public static final long serialVersionUID = 2L;
	
	public int unEntier;
	public String uneString;
	public double unReel;
	//public String uneDeuxiemeString;
	
	public ObjetSimple(int i, String s, double d) {
		this.unEntier = i;
		this.uneString = s;
		this.unReel = d;
	}
	
	public ObjetSimple(int i, String s, double d, String c) {
		this.unEntier = i;
		this.uneString = s;
		this.unReel = d;
		//this.uneDeuxiemeString = c;
	}
	
	public String afficher() {
		return "i : "+this.unEntier+" "+this.uneString+" "+" d : "+this.unReel+" ";//+this.uneDeuxiemeString;
	}

}
