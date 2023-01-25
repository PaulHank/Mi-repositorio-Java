package com.liceolapaz.des.pae;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AESSimpleManager {

	public static Key obtenerclave (String password,int longitud) {
		Key clave = new SecretKeySpec(password.getBytes(),0,longitud,"AES");
		return clave;
	}
	
	public static String cifrar (String textoEnClaro, Key key) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
					IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE,key);
		byte[] cipherText = cipher.doFinal(textoEnClaro.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}
	
	public static String decypher(String txtoCdifrado, Key key) 
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, 
					IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE,key);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(txtoCdifrado));
		return new String(plainText);
	}
}
