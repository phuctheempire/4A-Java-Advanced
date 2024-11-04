package main;
import java.util.Date;

import CAF.*;
import SpecialTypes.Genre;

public class Main {
	public static void main( String[] args) {
		Personne mom, dad, son, daughter;
		Personne[] enfants = new Personne[2] ;		
		mom = new Personne( "", null, "Aniston", "Jennifer", Genre.Femme , enfants );
		dad = new Personne( "", null, "Brit", "Patt", Genre.Homme , enfants );
		son = new Personne("", null, "", "", Genre.Homme, mom, dad);
		daughter = new Personne("", null, "", "", Genre.Femme, mom, dad);
		son.getParents();
		
//		Question 4
		Personne bob = new Allocataire();
		bob.printInfo();
	};	
}
