Security Support
================

Contains Utilities for Security Support


## Cipher Utilites
### AES Encryption with padding
Example:
```
String textToEncrypt = "Text to encrypt";
String encryptionKey = "1234567890123456";
		
Cipher cipher = CipherFactory.aesCipher();
String encryptedText = cipher.encrypt(textToEncrypt, encryptionKey);
Assert.assertEquals(cipher.decrypt(encryptedText, encryptionKey),textToEncrypt);
```		
*Please note that the length of the encryption key should always be 16 with this encryption strength and algorithm.*