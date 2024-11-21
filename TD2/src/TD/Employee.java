package TD;

public class Employee {
    private int numeroEmp;
    private static int nombreEmp;
    private String nom;
    private String prenom;
    private double salaireMensuel;
    private double primeAnnuel;

    public int getNumeroEmp(){
        return this.numeroEmp;
    }
    public String getNomPrenom(){
        return this.nom + " " + this.prenom;
    }
    public double getSalaireAnnuel(){
        return this.salaireMensuel * 12 + this.primeAnnuel;
    }
    public static int getNombreEmp(){
        return nombreEmp;
    }
    public Employee ( String nom, String prenom, Double salaireMensuel, double primeAnnuel){
        this.nom = nom;
        this.prenom = prenom;
        this.salaireMensuel = salaireMensuel;
        this.primeAnnuel = primeAnnuel;
        this.numeroEmp = nombreEmp++;
    }

}
