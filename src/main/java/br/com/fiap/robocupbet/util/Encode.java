package br.com.fiap.robocupbet.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encode {
	
	public static String sha256(String textoBase) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(textoBase.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hash.length == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch(NoSuchAlgorithmException | UnsupportedClassVersionError | UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
