import java.util.*;

public class Prac1C {
    static char[] p = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] ch = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();

    static String encrypt(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray())
            res.append(ch[new String(p).indexOf(c)]);
        return res.toString();
    }

    static String decrypt(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray())
            res.append(p[new String(ch).indexOf(c)]);
        return res.toString();
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String msg = sc.next().toLowerCase();
        String enc = encrypt(msg);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + decrypt(enc));
    }
}