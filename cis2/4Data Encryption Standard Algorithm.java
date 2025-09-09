import javax.crypto.*;
import java.util.Base64;

public class Prac4 {
    Cipher ecipher, dcipher;

    Prac4(SecretKey key) throws Exception {
        ecipher = Cipher.getInstance("DES");
        dcipher = Cipher.getInstance("DES");
        ecipher.init(Cipher.ENCRYPT_MODE, key);
        dcipher.init(Cipher.DECRYPT_MODE, key);
    }

    String encrypt(String str) throws Exception {
        byte[] enc = ecipher.doFinal(str.getBytes("UTF8"));
        return Base64.getEncoder().encodeToString(enc);
    }

    String decrypt(String str) throws Exception {
        byte[] dec = Base64.getDecoder().decode(str);
        return new String(dcipher.doFinal(dec), "UTF8");
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        Prac4 obj = new Prac4(key);

        String text = "Mountain";
        String enc = obj.encrypt(text);
        String dec = obj.decrypt(enc);

        System.out.println("Original: " + text);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}