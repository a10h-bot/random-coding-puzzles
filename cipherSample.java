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

public class cipherSample {

    public static void main(final String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // byte[] keyBytes = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        // 14, 15 };
        // String algorithm = "RawBytes";
        // SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
        final KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        final SecureRandom secureRandom = new SecureRandom();
        final int keyBitSize = 256;
        keyGenerator.init(keyBitSize, secureRandom);
        final SecretKey secretKey = keyGenerator.generateKey();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        final byte[] plainText = "abcdefghijklmnopqrstuvwxyz".getBytes("UTF-8");
        final byte[] cipherText = cipher.doFinal(plainText);
        for (int i = 0; i < plainText.length; i++) {
            System.out.print(plainText[i] + " " + plainText.length);
        }
        System.out.println("|");
        for (int i = 0; i < cipherText.length; i++) {
            System.out.print(cipherText[i] + " " + cipherText.length);
        }

    }
}

// 97 2698 2699 26100 26101 26102 26103 26104 26105 26106 26107 26108 26109
// 26110 26111 26112 26113 26114 26115 26116 26117 26118 26119 26120 26121 26122
// 26|
// -87 3253 32-114 32-15 3287 3218 32-83 32-54 32-3 3229 3225 3259 32-30 32-108
// 3215 32-108 32-113 32-118 32-66 32-38 32-25 32-20 32-4 32-112 3234 32-20
// 32118 32-71 32-59 32-102 32-89 3281 32