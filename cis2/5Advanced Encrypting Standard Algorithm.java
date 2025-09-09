import javax.crypto.*;
import java.util.Base64;

public class Prac5 {
    Cipher ec, dc;

    Prac5(SecretKey key) throws Exception {
        ec = Cipher.getInstance("AES");
        dc = Cipher.getInstance("AES");
        ec.init(Cipher.ENCRYPT_MODE, key);
        dc.init(Cipher.DECRYPT_MODE, key);
    }

    String encrypt(String s) throws Exception {
        return Base64.getEncoder().encodeToString(ec.doFinal(s.getBytes("UTF8")));
    }

    String decrypt(String s) throws Exception {
        return new String(dc.doFinal(Base64.getDecoder().decode(s)), "UTF8");
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        Prac5 aes = new Prac5(key);

        String text = "Mountain";
        String enc = aes.encrypt(text);
        String dec = aes.decrypt(enc);

        System.out.println("Original: " + text);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}