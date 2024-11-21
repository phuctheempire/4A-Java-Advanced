package TD5;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

public class RSAKeySaver {
    private KeyPair keypair = null;
    private String source = null;
    public RSAKeySaver ( KeyPair key, String path){
        this.keypair = key;
        this.source = path;
    }
    public void savePublicKeysToFile(){
        try {
            FileOutputStream fis = new FileOutputStream(this.source);
            RSAPublicKey publicKey =(RSAPublicKey)this.keypair.getPublic();
            byte[] modulus = publicKey.getModulus().toByteArray();
            byte[] exponent = publicKey.getPublicExponent().toByteArray();
            fis.write(modulus.length + exponent.length);
            fis.write(modulus);
            fis.write(exponent);
            fis.flush();
            fis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
