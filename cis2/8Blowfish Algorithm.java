import javax.crypto.*;
import javax.swing.*;

public class Prac8 {
    public static void main(String[] args) throws Exception {
        SecretKey key = KeyGenerator.getInstance("Blowfish").generateKey();
        Cipher c = Cipher.getInstance("Blowfish");

        String input = JOptionPane.showInputDialog("Enter text:");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc = c.doFinal(input.getBytes());

        c.init(Cipher.DECRYPT_MODE, key);
        String dec = new String(c.doFinal(enc));

        JOptionPane.showMessageDialog(null, "Encrypted: " + new String(enc) + "\nDecrypted: " + dec);
    }
}