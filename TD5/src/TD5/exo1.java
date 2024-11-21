package TD5;
import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.interfaces.*;
import java.security.KeyPairGenerator;
import java.math.BigInteger ;
import java.security.spec.RSAPublicKeySpec;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.io.*;

public class exo1 {
    public static void main(String[] args) throws Exception {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair pair = generator.generateKeyPair();
            java.security.PrivateKey privateKey = pair.getPrivate();
            java.security.PublicKey publicKey = pair.getPublic();
//            System.out.println(privateKey.getEncoded().length);
//            System.out.println(publicKey.getEncoded().length);
            RSAPublicKey rsaPub = (RSAPublicKey)publicKey;
            BigInteger publicKeyModulus = rsaPub.getModulus();
            BigInteger publicKeyExponent = rsaPub.getPublicExponent();
            System.out.println("publicKeyModulus: " + publicKeyModulus);
            System.out.println("publicKeyExponent: " + publicKeyExponent);
            RSAPublicKeySpec newKey = new RSAPublicKeySpec(publicKeyModulus, publicKeyExponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey key2 = keyFactory.generatePublic(newKey);
//            System.out.println(key2.toString());
            try {
                    FileOutputStream f_o = new FileOutputStream("D:\\4A\\New folder\\4A-Java-Advanced\\TD5\\save\\Example.rsa");
            } catch (FileNotFoundException e){
                    System.out.println("hahahahaha");
            }

    }
}