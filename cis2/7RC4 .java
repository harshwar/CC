class Prac7 {
    static char[] cipher;

    Prac7(String text, int[] key) {
        int[] s = new int[256];
        for (int i = 0; i < 256; i++) s[i] = i;

        cipher = new char[text.length()];
        int i = 0, j = 0;

        for (int k = 0; k < text.length(); k++) {
            j = (j + s[i] + key[k % key.length]) % 256;
            int t = s[i]; s[i] = s[j]; s[j] = t;
            cipher[k] = (char)((s[(s[i] + s[j]) % 256]) ^ text.charAt(k));
            i = (i + 1) % 256;
        }
    }

    public static void main(String[] args) {
        int[] key = {1,2,3,4,5};
        String msg = "nachnewali";
        new Prac7(msg, key);

        System.out.println("Original: " + msg);
        System.out.print("Cipher: ");
        for (char c : cipher) System.out.print(c);
    }
}