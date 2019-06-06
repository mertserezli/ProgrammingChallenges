package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class EncryptDecrypt {

    private static KeyPair pair;

    static{
        KeyPairGenerator keyPairGen = null;
        try {//wont throw
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGen.initialize(2048);
        pair = keyPairGen.generateKeyPair();
    }

    public static byte[] encrypt(String plainText) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {

        //Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        //Adding data to the cipher
        cipher.update(plainText.getBytes());

        //encrypting the data
        byte[] cipherText = cipher.doFinal();
        return cipherText;
    }


    public static String decrypt(byte[] cipherText) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        //Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing a Cipher object
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        //Adding data to the cipher
        cipher.update(cipherText);

        //encrypting the data
        byte[] plainText = cipher.doFinal();
        return new String(plainText);
    }

}
