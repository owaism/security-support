/**
 * Apache 2.0 License.
 * @author Owais Mohamed
 */
package info.owaism.security.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.testng.util.Strings;

import com.google.common.base.Preconditions;

/**
 * AES Cipher to be used for encryption and decryption using the AES algorithm.
 */
public class AESCipher implements info.owaism.security.Cipher {

	private static final int ENCRYPTION_KEY_FACTOR = 16;
	private static final String ENCRYPTION_KEY_LENGTH_ERR_MESSAGE = "Length of the Passed in encryption key should be a multiple of "
			+ ENCRYPTION_KEY_FACTOR;
	private static final String ENCRYPTION_ALGORITHM = "AES";
	private static final String UTF_8 = "UTF-8";
	private static final String ENCRYPTION_TRANSFORMATION = "AES/CBC/PKCS5Padding";

	/**
	 * Initialization Vector for AES Encryption
	 */
	private static final IvParameterSpec INIT_VECTOR = new IvParameterSpec("ah67jdQWkj93bht4".getBytes());

	/**
	 * Creates an AES cipher.
	 */
	AESCipher() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see info.owaism.social.fb.sdk.security.Cipher#encrypt(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public String encrypt(final String plainText, final String key) {

		validateKey(key);

		Preconditions.checkArgument(!Strings.isNullOrEmpty(plainText),
				"Passed in plain text cannot be null or empty.");

		try {
			Cipher cipher = Cipher.getInstance(ENCRYPTION_TRANSFORMATION);
			SecretKeySpec speckey = new SecretKeySpec(key.getBytes(UTF_8),
					ENCRYPTION_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, speckey, INIT_VECTOR);
			return Base64.getEncoder().encodeToString(
					cipher.doFinal(plainText.getBytes(UTF_8)));
		} catch (NoSuchPaddingException | NoSuchAlgorithmException
				| UnsupportedEncodingException | InvalidKeyException
				| InvalidAlgorithmParameterException
				| IllegalBlockSizeException | BadPaddingException ex) {
			throw new IllegalArgumentException(String.format(
					"Error while encrypting plain text : %s", plainText), ex);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see info.owaism.social.fb.sdk.security.Cipher#decrypt(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public String decrypt(String encryptedText, String key) {
		validateKey(key);

		Preconditions.checkArgument(!Strings.isNullOrEmpty(encryptedText),
				"Passed in encrypted text cannot be null or empty.");

		Cipher cipher;
		try {
			cipher = Cipher.getInstance(ENCRYPTION_TRANSFORMATION);

			SecretKeySpec speckey = new SecretKeySpec(key.getBytes(UTF_8),
					ENCRYPTION_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, speckey, INIT_VECTOR);
			return new String(cipher.doFinal(Base64.getDecoder().decode(
					encryptedText)), UTF_8);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeyException | InvalidAlgorithmParameterException
				| UnsupportedEncodingException | IllegalBlockSizeException
				| BadPaddingException e) {
			throw new IllegalStateException(
					String.format("Error while decrypting encrypted text : %s",
							encryptedText), e);
		}
	}

	/**
	 * Validates that the key is atleast
	 * 
	 * @param key
	 * @return
	 */
	private static void validateKey(String key) {
		Preconditions.checkArgument(null != key,
				"Passed in encryption/decryption key cannot be null.");
		Preconditions.checkArgument(0 == key.length() % ENCRYPTION_KEY_FACTOR,
				ENCRYPTION_KEY_LENGTH_ERR_MESSAGE);
	}

}
