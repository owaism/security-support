/**
 * Apache 2.0 License.
 * @author Owais Mohamed
 */
package info.owaism.security;


/**
 * Cipher to be used for encryption and decryption.
 */
public interface Cipher {
	/**
	 * Encrypts text.
	 * 
	 * @param plainText
	 *            Text to be encrypted
	 * @param encryptionKey
	 *            Key to use for encryption.
	 * @return Encrypted text
	 */
	String encrypt(String plainText, String encryptionKey);

	/**
	 * Decrypts text encrypted by {@link Cipher#encrypt(String, String, String)}
	 * .
	 * 
	 * @param encryptedText
	 *            Text to be decrypted
	 * @param decryptionKey
	 *            Key to used for encryption. 
	 * @return Plain Text.
	 */
	String decrypt(String encryptedText, String decryptionKey);

}
