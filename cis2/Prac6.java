import java.math.*;
import java.security.*;

public class Prac6 {
    BigInteger p, q, n, phi, e, d;

    Prac6() {
        SecureRandom r = new SecureRandom();
        p = BigInteger.probablePrime(4, r);
        q = BigInteger.probablePrime(4, r);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.valueOf(3);
        while (phi.gcd(e).intValue() > 1) e = e.add(BigInteger.ONE);
        d = e.modInverse(phi);

        System.out.println("p=" + p + ", q=" + q);
        System.out.println("Public key: (" + n + "," + e + ")");
        System.out.println("Private key: (" + n + "," + d + ")");

        BigInteger msg = BigInteger.valueOf(1);
        BigInteger enc = msg.modPow(e, n);
        BigInteger dec = enc.modPow(d, n);

        System.out.println("Message: " + msg);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }

    public static void main(String[] args) {
        new Prac6();
    }
}