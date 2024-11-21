package cmSerializable;


import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Personne3 implements java.io.Externalizable {
	private String           nom        = "";
	private String           prenom     = "";
	private int              taille     = 0;
	private Date             dateNaiss  = null;
	private transient String codeSecret = "";

	public Personne3() {
	}

	public Personne3(final String nom, final String prenom, final int taille, final String
			codeSecret, final Date dateNaiss) {
		this.nom = nom;
		this.taille = taille;
		this.prenom = prenom;
		this.codeSecret = codeSecret;
		this.dateNaiss = dateNaiss;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(final int taille) {
		this.taille = taille;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public String getCodeSecret() {
		return this.codeSecret;
	}

	public Date getDateNaiss() {
		return this.dateNaiss;
	}

	public void setDateNaiss(final Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	  @Override
	  public void writeExternal(final ObjectOutput out) throws IOException {
	    out.writeUTF(this.nom);
	    out.writeUTF(this.prenom);
	    out.writeObject(this.dateNaiss);
	    out.writeInt(this.taille);
	    
	    SecretKey key;
		try {
			key = getKeyFromPassword("pass", "1234");

	    byte[] b = new byte[16]; // empty IV
	    IvParameterSpec ivParameterSpec =  new IvParameterSpec(b);// generateIv();
	    String algorithm = "AES/CBC/PKCS5Padding";
	    //out.write(ivParameterSpec.getIV());	    
			out.writeUTF(encrypt(algorithm, this.codeSecret, key, ivParameterSpec));
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
		}

}

	  @Override
	  public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
	    this.nom = in.readUTF();
	    this.prenom = in.readUTF();
	    this.dateNaiss = (Date) in.readObject();
	    this.taille = in.readInt();
	    try {
	    	SecretKey key;
	    	key = getKeyFromPassword("pass", "1234");
	    	byte[] b = new byte[16]; // empty IV
	    	IvParameterSpec ivParameterSpec =  new IvParameterSpec(b);
	    	String algorithm = "AES/CBC/PKCS5Padding";

	    	this.codeSecret = decrypt(algorithm, in.readUTF(), key, ivParameterSpec);
	    } catch (Exception e) {

	    }
	  }
	
	public String toString() {
		return 	" nom : "+this.nom+"\n prenom : "+this.prenom+"\n taille : "+this.taille+"\n dateNaiss : "+this.dateNaiss+"\n codeSecret : "+this.codeSecret;
	}
	
	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(n);
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
	
	public static SecretKey getKeyFromPassword(String password, String salt)
		    throws NoSuchAlgorithmException, InvalidKeySpecException {
		    
		    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
		    SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
		        .getEncoded(), "AES");
		    return secret;
		}
	
	
	public static IvParameterSpec generateIv() {
	    byte[] iv = new byte[16];
	    new SecureRandom().nextBytes(iv);
	    return new IvParameterSpec(iv);
	}
	
	public static String encrypt(String algorithm, String input, SecretKey key,
		    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    byte[] cipherText = cipher.doFinal(input.getBytes());
		    return Base64.getEncoder()
		        .encodeToString(cipherText);
		}
	
	public static String decrypt(String algorithm, String cipherText, SecretKey key,
		    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    byte[] plainText = cipher.doFinal(Base64.getDecoder()
		        .decode(cipherText));
		    return new String(plainText);
		}


}