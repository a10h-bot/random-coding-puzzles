import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class cipherSample {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // byte[] keyBytes = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        // 14, 15 };
        // String algorithm = "RawBytes";
        // SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 256;
        keyGenerator.init(keyBitSize, secureRandom);

        SecretKey secretKey = keyGenerator.generateKey();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] plainText = "abcdefghijklmnopqrstuvwxyz".getBytes("UTF-8");
        byte[] cipherText = cipher.doFinal(plainText);
        for (int i = 0; i < plainText.length; i++) {
            System.out.print(plainText[i] + " " + plainText.length);
        }
        System.out.println("|");
        for (int i = 0; i < cipherText.length; i++) {
            System.out.print(cipherText[i] + " " + cipherText.length);
        }

    }
}