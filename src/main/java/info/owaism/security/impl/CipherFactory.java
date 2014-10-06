/**
 * Apache 2.0 License.
 * @author Owais Mohamed
 */
package info.owaism.security.impl;

import info.owaism.security.Cipher;

/**
 * Factory which provides various types of Ciphers.
 */
public final class CipherFactory {
	/**
	 * AES Cipher.
	 */
	private static final AESCipher AES_CIPHER = new AESCipher();

	/**
	 * Utility Class. Should not be instantiated.
	 */
	private CipherFactory() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Provides an AES cyclic no padding cipher.
	 * @return AES Cipher
	 */
	public static Cipher aesCipher(){
		return AES_CIPHER;
	}

}
