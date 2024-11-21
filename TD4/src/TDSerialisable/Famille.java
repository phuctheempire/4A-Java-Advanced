package TDSerialisable;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Famille implements Serializable {
    private ArrayList<Personne> famille = new ArrayList<Personne>(2);

    public Famille(Personne per1, Personne per2){
        famille.add(per1);
        famille.add(per2);
    }

    @Override
    public String toString() {
        return "Famille: \n"+"Personne1: "+famille.get(0).toString()+"\n"+famille.get(1).toString();
    }
}
