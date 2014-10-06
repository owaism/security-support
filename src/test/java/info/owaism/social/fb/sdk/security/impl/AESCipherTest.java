package info.owaism.social.fb.sdk.security.impl;

import info.owaism.security.Cipher;
import info.owaism.security.impl.CipherFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AESCipherTest {
	@Test
	public void cipherTest() {

		String textToEncrypt = "Text to encrypt";
		String encryptionKey = "1234567890123456";
		
		Cipher cipher = CipherFactory.aesCipher();
		String encryptedText = cipher.encrypt(textToEncrypt, encryptionKey);
		Assert.assertEquals(cipher.decrypt(encryptedText, encryptionKey),textToEncrypt);
	}
	
	
}
