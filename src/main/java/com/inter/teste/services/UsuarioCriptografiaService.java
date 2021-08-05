package com.inter.teste.services;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import org.springframework.stereotype.Service;

@Service
public class UsuarioCriptografiaService {

	private static final String ALGORITHM = "RSA";

	private PublicKey getPublicKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {

		byte[] publicBytes = Base64.getDecoder().decode(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);

		return keyFactory.generatePublic(keySpec);
	}

	private PrivateKey getPrivateKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {

		byte[] privateBytes = Base64.getDecoder().decode(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(privateBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
		return keyFactory.generatePrivate(keySpec);

	}

	public String criptografa(String texto, String publicKey) {

		try {
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
			return new String(cipher.doFinal(texto.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String decriptografa(String texto, String privateKey) {

		try {
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(privateKey));
			return new String(cipher.doFinal(texto.getBytes()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

}
