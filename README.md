Security Support
================

Contains Utilities for Security Support


# Cipher Utilites
## AES Encryption with padding
Example:
```
String textToEncrypt = "Text to encrypt";
String encryptionKey = "1234567890123456";
		
Cipher cipher = CipherFactory.aesCipher();
String encryptedText = cipher.encrypt(textToEncrypt, encryptionKey);
Assert.assertEquals(cipher.decrypt(encryptedText, encryptionKey),textToEncrypt);
```		