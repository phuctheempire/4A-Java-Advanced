package cmFichiers;

public class MainFileWriter {

	public static void main(String[] args) throws Exception {
		TestPrintWriter f = new TestPrintWriter("c:/tmp/sortie1.txt");
		f.traitement();
	}

}
