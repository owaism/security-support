/**
 * Apache 2.0 License.
 * @author Owais Mohamed
 */
package info.owaism.security;

import org.hibernate.validator.constraints.NotBlank;

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
	String encrypt(@NotBlank String plainText, @NotBlank String encryptionKey);

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
	String decrypt(@NotBlank String encryptedText, @NotBlank String decryptionKey);

}
